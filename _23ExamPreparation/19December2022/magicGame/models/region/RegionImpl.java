package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.Collection;
import java.util.stream.Collectors;

public class RegionImpl  implements Region {


    @Override
    public String start(Collection<Magician> magicians) {

        Collection<Magician> wizardsList = magicians
                .stream()
                .filter(magician -> magician instanceof Wizard && magician
                .isAlive())
                .collect(Collectors.toList());

        Collection<Magician> blackWidowList = magicians
                .stream()
                .filter(magician -> magician instanceof BlackWidow && magician.isAlive())
                .collect(Collectors.toList());

        while (!wizardsList.isEmpty() && blackWidowList.isEmpty()) {

            bestAttack(wizardsList, blackWidowList);
            bestAttack(blackWidowList, wizardsList);

            wizardsList.removeIf(magician -> !magician.isAlive());
            blackWidowList.removeIf(magician -> !magician.isAlive());
        }

        return !wizardsList.isEmpty()
                ? "Wizards win!"
                : "Black widows win!";
    }

    private void bestAttack(Collection<Magician> attack, Collection<Magician> defender) {

        for (Magician att : attack) {
            for (Magician def : defender) {

                int damage = att.getMagic().fire();

                if (damage > 0) {
                    def.takeDamage(damage);
                }
            }
        }
    }
}
