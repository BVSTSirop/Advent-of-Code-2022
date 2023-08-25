package ch.killenberger.day.day5;

import ch.killenberger.day.AbstractDay;
import ch.killenberger.day.Day;

import java.io.IOException;
import java.util.*;

public class Day5 extends AbstractDay implements Day<String> {
    Map<Integer, ArrayList<String>> crates = new HashMap<>();
    public Day5(String day) {
        super(day);
    }

    @Override
    public String run(boolean partOne) throws IOException {
        checkInputFile();

        final List<String> lines = readInput();



        processInput(lines);

        return null;
    }

    private void processInput(final List<String> lines) {
        final int    endOfDrawingLineNr = getEndOfDrawingLine(lines);
        final String columnCounter      = lines.get(endOfDrawingLineNr - 1).trim();
        final int    amountOfColumns    = Integer.parseInt(columnCounter.substring(columnCounter.lastIndexOf(" ") + 1));

        for(int col = 1; col <= amountOfColumns; col++) {
            crates.computeIfAbsent(col, k -> new ArrayList<>());

            for(int row = 0; row < (endOfDrawingLineNr - 1); row++) {
                if (col == 1) {
                    crates.get(col).add(String.valueOf(lines.get(row).charAt(1)));
                } else {
                    crates.get(col).add(String.valueOf(lines.get(row).charAt(col + 3)));
                }
            }
        }

        System.out.println(crates);
    }

    private int getAmountOfCrateStacks(final List<String> lines) {
        final int    endOfDrawingLineNr = getEndOfDrawingLine(lines);
        final String columnCounter      = lines.get(endOfDrawingLineNr - 1);
// 1 5 9 13
        System.out.println(columnCounter);

        return 0;
    }

    private int getEndOfDrawingLine(final List<String> lines) {
        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).isEmpty()) {
                return i;
            }
        }

        throw new IllegalArgumentException("Invalid input. No newline has been found between drawing and instructions");
    }
}
