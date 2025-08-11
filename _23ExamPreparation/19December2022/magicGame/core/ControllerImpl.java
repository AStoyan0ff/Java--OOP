package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepository;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepository;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private final MagicRepository<Magic> magics;
    private final MagicianRepository<Magician> magicians;
    private final Region region;

    public ControllerImpl() {

        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();


    }


    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;

        if (type.equals("RedMagic")) {
            magic = new RedMagic(name, bulletsCount);
        } else if (type.equals("BlackMagic")) {
            magic = new BlackMagic(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }

        magics.addMagic(magic);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = magics.findByName(magicName);

        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }

        Magician magician;

        if (type.equals("Wizard")) {
            magician = new Wizard(username, health, protection, magic);
        } else if (type.equals("BlackWidow")) {
            magician = new BlackWidow(username, health, protection, magic);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }

        magicians.addMagician(magician);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return region
                .start(magicians
                .getData()
                .stream()
                .filter(Magician::isAlive)
                .collect(Collectors.toList()));
    }

    @Override
    public String report() {
        StringBuilder buff = new StringBuilder();

        Collection<Magician> magicianList = magicians

                .getData()
                .stream()
                .sorted(Comparator.comparing(Magician::getHealth)
                .thenComparing(Magician::getUsername))
                .collect(Collectors.toList());

        for (Magician magician : magicianList) {
            int health = magician.getHealth();

            if (magician.getHealth() < 0) {
                health = 0;
            }

            int protection = magician.getProtection();

            if (magician.getProtection() < 0) {
                protection = 0;
            }

            buff
                    .append(String.format("%s: %s%n", magician
                            .getClass()
                            .getSimpleName(), magician
                            .getUsername()))
                    .append(String.format("Health: %d%n", health))
                    .append(String.format("Protection: %d%n", protection))
                    .append(String.format("Magic: %s%n", magician.getMagic().getName()));
        }
        return buff.toString().trim();

    }
}