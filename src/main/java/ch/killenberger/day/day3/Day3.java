package ch.killenberger.day.day3;

import ch.killenberger.day.AbstractDay;
import ch.killenberger.day.Day;
import ch.killenberger.utils.CumulativeMap;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3 extends AbstractDay implements Day<Integer> {
    private List<Character> alphabet;

    public Day3(String day) {
        super(day);

        // Generate a - Z characters as a List
        this.alphabet = IntStream.concat(IntStream.rangeClosed('a', 'z'), IntStream.rangeClosed('A', 'Z')).mapToObj(c -> (char) c).toList();
    }

    @Override
    public Integer run(boolean partOne) throws IOException {
        checkInputFile();

        final List<String> lines = readInput();

        if(partOne) {
            return processInputPartOne(lines);
        }

        return processInputPartTwo(lines);

    }

    private int processInputPartOne(final List<String> lines) {
        final CumulativeMap<Character> characters = new CumulativeMap<>();

        int      result = 0;
        String[] halves;
        for(String s : lines) {
            halves = splitStringInHalf(s);

            // Reducing both halves so that there are no duplicate chars in either of them
            HashSet<Character> reducedFirstHalf  = reduceDuplicateCharacters(halves[0]);
            HashSet<Character> reducedSecondHalf = reduceDuplicateCharacters(halves[1]);

            // Combining the entries will result in only one duplicate character
            characters.putAll(reducedFirstHalf);
            characters.putAll(reducedSecondHalf);

            // Gets the character whith the highest occurrence (which is 2) and adds its priority to the result
            result +=  getPriority(characters.getHighestValueEntry().getKey());

            characters.clear();
        }

        return result;
    }

    private int processInputPartTwo(final List<String> lines) {
        final CumulativeMap<Character> characters = new CumulativeMap<>();

        int counter = 0;
        int result  = 0;
        for (String line : lines) {

            // Reducing the String to single character occurrences and adding it to the cummulative map
            characters.putAll(reduceDuplicateCharacters(line));
            counter++;

            if (counter == 3) {
                // Because the added strings were all reduced to single occurrences, the common character will have the most occurrences
                result += getPriority(characters.getHighestValueEntry().getKey());

                characters.clear();
                counter = 0;
            }
        }

        return result;
    }

    public String[] splitStringInHalf(String s) {
        return new String[]{s.substring(0, s.length() / 2), s.substring(s.length() / 2)};
    }

    // HashSets don't allow for duplicate entries which leaves us with one entry per character occurrence
    private HashSet<Character> reduceDuplicateCharacters(final String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(HashSet::new));
    }

    private int  getPriority(final Character c) {
        return alphabet.indexOf(c) + 1;
    }
}
