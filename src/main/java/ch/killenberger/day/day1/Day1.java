package ch.killenberger.day.day1;

import ch.killenberger.day.AbstractDay;
import ch.killenberger.day.Day;

import java.io.IOException;
import java.util.*;

public class Day1 extends AbstractDay implements Day<Integer> {

    public Day1(String day) {
        super(day);
    }

    @Override
    public Integer run(boolean partOne) throws IOException {
        checkInputFile();

        final List<String>          lines          = readInput();
        final Map<Integer, Integer> caloriesPerElv = convertInput(lines);

        if(partOne) {
            return Collections.max(caloriesPerElv.values());
        }

        // Sort values in a descending order
        final List<Integer> sortedTotalCalories = new ArrayList<>(caloriesPerElv.values().stream().toList());
        Collections.sort(sortedTotalCalories);
        Collections.reverse(sortedTotalCalories);

        // Return the sum of the three highest values
        return sortedTotalCalories.get(0) + sortedTotalCalories.get(1) + sortedTotalCalories.get(2);
    }

    private Map<Integer, Integer> convertInput(final List<String> input) {
        final Map<Integer, Integer> result = new TreeMap<>();

        int counter  = 1;
        int calories = 0;
        for(String s : input) {
            if(s.isEmpty()) {
                result.put(counter, calories);
                calories = 0;
                counter++;
            } else {
                calories += Integer.parseInt(s);
            }
        }

        return result;
    }
}
