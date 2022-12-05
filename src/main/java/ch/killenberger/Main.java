package ch.killenberger;

import ch.killenberger.day.Day1;

import java.io.IOException;

public class Main {

    private static Day1 dOne = new Day1("1");

    public static void main(String... args) throws IOException {
        System.out.println("\n------------- Day 1 -------------");
        System.out.println("Result day one: "          + dOne.run(true));
        System.out.println("Result day one part two: " + dOne.run(false));
    }
}
















