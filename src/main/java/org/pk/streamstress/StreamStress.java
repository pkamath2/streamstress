package org.pk.streamstress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStress {

    public static void main(String[] args) {

        System.out.println("\n//1. Create fruit stream");
        getFruitStream().forEach(FruitColorPrinter::printWithColor);

        System.out.println("\n//2. Filter: Print all small fruits");
        getFruitStream().filter((f) -> f.isSmall())
                    .forEach(FruitColorPrinter::printWithColor);


        System.out.println("\n//3. Map & Collect: Apply function to each element of the stream");
        List<String> fruitList1 = getFruitStream().map((f) -> f.getName().toUpperCase())
                    .collect(Collectors.toList());
        System.out.println("All fruits: "+fruitList1);

        List<String> fruitList = getFruitStream().flatMap((f) -> Arrays.asList(f.getName().toUpperCase(), "\uD83C\uDF7A").stream()) //<-- This is Beer Emoji!!
                    .collect(Collectors.toList());
        System.out.println("All fruits w/ Beer! : "+fruitList);


        System.out.println("\n//4. Reduce/count: ");
        long count_of_small_fruits = getFruitStream().filter((f) -> f.isSmall()).count();
        System.out.println("Number of small fruits = "+count_of_small_fruits);

        Optional<Fruit> fruit = getFruitStream().filter(f -> f.isSmall())
                    .reduce((f1, f2) -> {return new Fruit(f1.getName()+"-"+f2.getName(),f1.getColor()+"-"+f2.getColor(),Boolean.FALSE);});
        System.out.println("Fruits reduced: \n"+fruit.get());

    }

    private static Stream<Fruit> getFruitStream() {
        // Create the fruit stream from file
        Stream<Fruit> fruitStream = null;
        try(InputStreamReader inputStreamReader = new InputStreamReader(StreamStress.class.getClassLoader().getResourceAsStream("fruits.txt"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){

            Stream.Builder<Fruit> fruitStreamBuilder = Stream.builder();

            bufferedReader.lines().forEach((line) -> {
                String[] tokens = line.split(",");
                fruitStreamBuilder.add(new Fruit(tokens[0],tokens[1],new Boolean(tokens[2])));
            });
            fruitStream = fruitStreamBuilder.build();
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        return fruitStream;
    }


}
