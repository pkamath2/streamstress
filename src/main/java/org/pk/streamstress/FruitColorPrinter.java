package org.pk.streamstress;

public class FruitColorPrinter {

    // Color code from https://gist.github.com/chrisopedia/8754917
    // Beer mug for bash: http://www.fileformat.info/info/unicode/char/1f37a/index.htm
    private static final String RESET = "\u001b[0m";
    private static final String RED = "\u001b[1;31m";
    private static final String GREEN = "\u001b[1;32m";
    private static final String YELLOW = "\u001b[1;33m";
    private static final String ORANGE = "\u001b[1;35m";

    public static void printWithColor(Fruit fruit){

        switch (fruit.getColor()) {
            case "Yellow":
                System.out.print(YELLOW);
                break;
            case "Red":
                System.out.print(RED);
                break;
            case "Green":
                System.out.print(GREEN);
                break;
            case "Orange":
                System.out.print(ORANGE);
                break;
        }
        System.out.println(fruit);
        System.out.print(RESET);
    }

}
