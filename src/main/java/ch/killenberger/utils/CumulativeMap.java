package ch.killenberger.utils;

import java.util.*;

public class CumulativeMap<K> {
    final List<Map.Entry<K, Integer>> entries = new ArrayList<>();

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

    @SafeVarargs
    public final void putAll(Collection<K>... keyCollections) {
        for(Collection<K> collection : keyCollections) {
            for(K key : collection) {
                put(key);
            }
        }
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
        return Collections.max(this.entries, Map.Entry.comparingByValue());
    }

    public Map.Entry<K, Integer> getLowestValueEntry() {
        return Collections.min(this.entries, Map.Entry.comparingByValue());
    }

    public Map<K, Integer> toMap() {
        final Map<K, Integer> m = new HashMap<>();

        for(Map.Entry<K, Integer> e : this.entries) {
            m.put(e.getKey(), e.getValue());
        }

        return m;
    }

    public void clear() {
        this.entries.clear();
    }

    private Map.Entry<K, Integer> findEntryByKey(K key) {
        return this.entries.stream().filter(e -> e.getKey().equals(key)).findFirst().orElse(null);
    }
}
