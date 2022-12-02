package ch.killenberger;

import java.util.*;

public class CumulativeMap<K> {
    List<Map.Entry<K, Integer>> entries = new ArrayList<>();

    public void put(K key, Integer value) {
        Map.Entry<K, Integer> existingEntry = findEntryByKey(key);

        if(existingEntry == null) {
            Map.Entry<K, Integer> newEntry = new AbstractMap.SimpleEntry<>(key, value);

            entries.add(newEntry);
        } else {
            existingEntry.setValue(existingEntry.getValue() + value);
        }
    }

    public void put(K key) {
        this.put(key, 1);
    }

    public Integer get(K key) {
        Map.Entry<K, Integer> e = findEntryByKey(key);

        if(e == null) {
            return null;
        }

        return e.getValue();
    }

    public Map.Entry<K, Integer> getEntry(final K key) {
        return findEntryByKey(key);
    }

    public Map.Entry<K, Integer> getHighestValueEntry() {
        Map.Entry<K, Integer> highest = null;

        for(Map.Entry<K, Integer> entry : entries) {
            if(highest == null || highest.getValue() < entry.getValue()) {
                highest = entry;
            }
        }

        return highest;
    }

    public Map.Entry<K, Integer> getLowestValueEntry() {
        Map.Entry<K, Integer> lowest = null;

        for(Map.Entry<K, Integer> entry : entries) {
            if(lowest == null || lowest.getValue() > entry.getValue()) {
                lowest = entry;
            }
        }

        return lowest;
    }

    public Map<K, Integer> toMap() {
        final Map<K, Integer> m = new HashMap<>();

        for(Map.Entry<K, Integer> e : entries) {
            m.put(e.getKey(), e.getValue());
        }

        return m;
    }

    public void clear() {
        this.entries.clear();
    }

    private Map.Entry<K, Integer> findEntryByKey(K key) {
        return entries.stream().filter(e -> e.getKey().equals(key)).findFirst().orElse(null);
    }
}
