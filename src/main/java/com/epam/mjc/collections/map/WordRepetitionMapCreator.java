package com.epam.mjc.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WordRepetitionMapCreator {
    public Map<String, Integer> createWordRepetitionMap(String sentence) {
        String[] arr = sentence.split("[ ,.]");
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && !Objects.equals(arr[i], "")){
                tokens.add(arr[i].toLowerCase());
            }
        }

        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < tokens.size(); i++) {
            result.computeIfPresent(tokens.get(i), (k, v) -> v + 1);
            result.putIfAbsent(tokens.get(i), 1);
        }
        return result;
    }
}
