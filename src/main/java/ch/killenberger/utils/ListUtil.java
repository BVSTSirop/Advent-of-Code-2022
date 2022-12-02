package ch.killenberger.utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListUtil {

    public static List<Integer> convertToIntegerList(final List<String> l) {
        return l.stream().filter(Objects::nonNull).map(Integer::parseInt).collect(Collectors.toList());
    }
}
