package ch.killenberger;

import ch.killenberger.day.day1.Day1;
import ch.killenberger.day.day2.Day2;
import ch.killenberger.day.day3.Day3;

import java.io.IOException;
import java.util.stream.IntStream;

public class Main {
    private static Day1 dOne = new Day1("1");
    private static Day2 dTwo = new Day2("2");
    private static Day3 dThree = new Day3("3");

    public static void main(String... args) throws IOException {
        System.out.println("\n------------- Day 1 -------------");
        System.out.println("Result day one: "          + dOne.run(true));
        System.out.println("Result day one part two: " + dOne.run(false));

        System.out.println("\n------------- Day 2 -------------");
        System.out.println("Result day two: "          + dTwo.run(true));
        System.out.println("Result day two part two: " + dTwo.run(false));

        System.out.println("\n------------- Day 3 -------------");
        System.out.println("Result day three: "          + dThree.run(true));
        System.out.println("Result day three part two: " + dThree.run(false));

    }
}
















