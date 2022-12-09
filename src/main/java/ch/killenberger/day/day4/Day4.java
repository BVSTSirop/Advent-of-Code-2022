package ch.killenberger.day.day4;

import ch.killenberger.day.AbstractDay;
import ch.killenberger.day.Day;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day4 extends AbstractDay implements Day<Integer> {
    public Day4(String day) {
        super(day);
    }

    @Override
    public Integer run(boolean partOne) throws IOException {
        checkInputFile();

        final List<String> lines = readInput();

        return processInput(lines, partOne);
    }

    private int processInput(final List<String> lines, final boolean partOne) {
        int result = 0;
        for(String s : lines) {
            // Splitting the input string, so we end up having an array of start and end indexes for either side of the pair
            final int[]         leftSection     = Arrays.stream(s.split(",")[0].split("-")).mapToInt(Integer::parseInt).toArray();
            final int[]         rightSection    = Arrays.stream(s.split(",")[1].split("-")).mapToInt(Integer::parseInt).toArray();

            // Generating the full list of section ids for either side
            final List<Integer> leftSectionIDs  = IntStream.rangeClosed(leftSection[0], leftSection[1]).boxed().toList();
            final List<Integer> rightSectionIDs = IntStream.rangeClosed(rightSection[0], rightSection[1]).boxed().toList();

            // Comparing the elements in both section-id lists to see if there are common entries
            final int overlaps = leftSectionIDs.stream().filter(rightSectionIDs::contains).toList().size();
            if(partOne) {
                // If the amount of common entries equals the length of either list -> one section assignment is contained fully in the other
                if (overlaps == rightSectionIDs.size() || overlaps == leftSectionIDs.size()) {
                    result++;
                }
            } else {
                if(overlaps > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
