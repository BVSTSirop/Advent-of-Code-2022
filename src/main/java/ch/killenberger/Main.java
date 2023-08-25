package ch.killenberger;

import ch.killenberger.day.day1.Day1;
import ch.killenberger.day.day2.Day2;
import ch.killenberger.day.day3.Day3;
import ch.killenberger.day.day4.Day4;
import ch.killenberger.day.day5.Day5;

import java.io.IOException;
import java.util.stream.IntStream;

public class Main {
    private static Day1 dOne   = new Day1("1");
    private static Day2 dTwo   = new Day2("2");
    private static Day3 dThree = new Day3("3");
    private static Day4 dFour  = new Day4("4");
    private static Day5 dFive  = new Day5("5");

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

        System.out.println("\n------------- Day 4 -------------");
        System.out.println("Result day four: "          + dFour.run(true));
        System.out.println("Result day four part two: " + dFour.run(false));

        System.out.println("\n------------- Day 5 -------------");
        System.out.println("Result day five: "          + dFive.run(true));

    }
}
















