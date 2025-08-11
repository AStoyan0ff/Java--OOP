package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double income;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
                          CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<Booth> boothRepository) {

        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.income = 0;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {

        Delicacy delicacy = delicacyRepository.getByName(name);

        if (delicacy == null) {
            DelicacyType foodType = DelicacyType.valueOf(type);

            switch (foodType) {

                case Gingerbread:
                    delicacy = new Gingerbread(name, price);
                    break;

                case Stolen:
                    delicacy = new Stolen(name, price);
                    break;
            }
        }
        else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, delicacy.getClass().getSimpleName(), name));

        }
        delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED, name, type);

    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {

        Cocktail cocktail = cocktailRepository.getByName(name);

        if (cocktail == null) {
            CocktailType cocktailType = CocktailType.valueOf(type);

            switch (cocktailType) {
                case MulledWine:
                    cocktail = new MulledWine(name, size, brand);
                    break;
                case Hibernation:
                    cocktail = new Hibernation(name, size, brand);
                    break;
            }
        }
        else {
            String message = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST,
                    cocktail.getClass().getSimpleName(), cocktail.getName());
            throw new IllegalArgumentException(message);
        }
        cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);

        if (booth == null) {
            BoothType tableType = BoothType.valueOf(type);

            switch (tableType) {

                case OpenBooth:
                    booth = new OpenBooth(boothNumber, capacity);
                    break;

                case PrivateBooth:
                    booth = new PrivateBooth(boothNumber, capacity);
                    break;
            }
        }
        else {
            String message = String.format(ExceptionMessages.BOOTH_EXIST, boothNumber);
            throw new IllegalArgumentException(message);
        }

        boothRepository.add(booth);
        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {

        for (Booth booth : boothRepository.getAll()) {

            if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople) {
                
                booth.reserve(numberOfPeople);
                return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);

            }
        }
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);

    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);

        double bill = booth.getBill();
        this.income += bill;
        booth.clear();

        return String.format(OutputMessages.BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, income);
    }

    @Override
    public String orderCocktail(int boothNumber, String cocktailName, String cocktailBrand) {
        Booth booth = boothRepository.getByNumber(boothNumber);

        Cocktail cocktail = cocktailRepository.getByName(cocktailName);
        if (booth == null || !booth.isReserved()) {
            return String.format("Could not find booth %d!", boothNumber);
        }

        if (cocktail == null) {
            return String.format("There is no %s %s available!", cocktailName, cocktailBrand);
        }

        booth.orderCocktail(cocktail);
        return String.format("Booth %d ordered %s %s!", boothNumber, cocktailName, cocktailBrand);

    }

    @Override
    public String orderDelicacy(int boothNumber, String delicacyName) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        Delicacy delicacy = delicacyRepository.getByName(delicacyName);

        if (booth == null || !booth.isReserved()) {
            return String.format("Could not find booth %d!", boothNumber);
        }
        if (delicacy == null) {
            return String.format("No %s in the pastry shop!", delicacyName);
        }
        booth.orderDelicacy(delicacy);
        return String.format("Booth %d ordered %s!", boothNumber, delicacyName);
    }
}
