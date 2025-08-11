package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;

    private int boothNumber;
    private int numberOfPeople;
    private int capacity;
    private  double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {

        setNumberOfPeople(boothNumber);
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.price = 0;

    }

    public void setCapacity(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {

        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }


    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {

        this.setNumberOfPeople(numberOfPeople);
        this.price = numberOfPeople * pricePerPerson;
        this.isReserved = true;
    }

    @Override
    public double getBill() {
        // ?
        double bill = 0;
        bill += delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        bill += cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        bill += getPrice();
        return bill;
    }

    @Override
    public void clear() {

        this.cocktailOrders.clear();
        this.delicacyOrders.clear();
        this.isReserved = false;
        this.price = 0;
        this.numberOfPeople = 0;

    }

    @Override
    public void orderCocktail(Cocktail cocktail) {
        this.cocktailOrders.add(cocktail);
    }

    @Override
    public void orderDelicacy(Delicacy food) {
        delicacyOrders.add(food);
    }
}
