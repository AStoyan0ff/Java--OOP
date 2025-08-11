package _05Inheritance.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {

       Random rdm = new Random();

       int idx = rdm.nextInt(this.size());
       return this.remove(idx);
    }
}
