package ch.killenberger;

import ch.killenberger.day.day1.Day1;
import ch.killenberger.day.day2.Day2;

import java.io.IOException;

public class Main {

    private static Day1 dOne = new Day1("1");
    private static Day2 dTwo = new Day2("2");

    public static void main(String... args) throws IOException {
        System.out.println("\n------------- Day 1 -------------");
        System.out.println("Result day one: "          + dOne.run(true));
        System.out.println("Result day one part two: " + dOne.run(false));

        System.out.println("\n------------- Day 2 -------------");
        System.out.println("Result day two: "          + dTwo.run(true));
        System.out.println("Result day two part two: " + dTwo.run(false));

    }
}
















