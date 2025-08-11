package aquarium.entries.fish;

public class FreshwaterFish extends BaseFish {

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price, 3);
    }


    @Override
    public void eat() {
        increaseSize(3);
    }
}
