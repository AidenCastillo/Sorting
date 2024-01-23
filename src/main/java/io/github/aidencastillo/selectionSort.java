package io.github.aidencastillo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class selectionSort {
    public selectionSort(String arg) {
        ObjectMapper objectMapper = new ObjectMapper();
    // load from arrays.json file
        String fileName = "largeArrays.json";

        try {
            JsonNode rootNode = objectMapper.readTree(new File(fileName));
            JsonNode randomArrayNode = rootNode.path(arg);

            List<Integer> randomArray = objectMapper.convertValue(randomArrayNode, List.class);

            // Sort the array
            sort(randomArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sort(List<Integer> randomArray) {
        int n = randomArray.size();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (randomArray.get(j) < randomArray.get(min_idx)) {
                    min_idx = j;
                }
            }

            int temp = randomArray.get(min_idx);
            randomArray.set(min_idx, randomArray.get(i));
            randomArray.set(i, temp);
        }
    }
}
