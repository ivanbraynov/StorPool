package org.storpool.countingtask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberAnalysis {

    public int countDistinctNumbers(List<Long> values) {
        Set<Long> uniqueNumbers = new HashSet<>(values);
        return uniqueNumbers.size();
    }

    public long countUniqueNumbers(List<Long> values) {
        Map<Long, Integer> frequencyMap = new HashMap<>();
        for (Long value : values) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        return frequencyMap.values().stream().filter(count -> count == 1).count();
    }
}
