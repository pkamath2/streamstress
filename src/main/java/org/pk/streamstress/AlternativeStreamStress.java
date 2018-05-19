package org.pk.streamstress;

import java.util.Arrays;
import java.util.List;

public class AlternativeStreamStress {

    public static void main(String[] args) {

        List<Fruit> fruits = Arrays.asList(new Fruit("Mango","Yellow", true),
                                            new Fruit("Orange","Orange", true),
                                            new Fruit("Watermelon","Red", false),
                                            new Fruit("Grapes","Green", true),
                                            new Fruit("Lemon","Yellow", true),
                                            new Fruit("Cherry","Red", true),
                                            new Fruit("Avocado","Green", true),
                                            new Fruit("Pumpkin","Orange", false));


        //Alternative way to create streams instead of read out of a file.
        fruits.stream()
                .filter((f) -> f.getColor().equals("Red"))
                .filter((f) -> f.isSmall())
                .forEach(System.out::println);

    }


}
