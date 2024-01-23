package io.github.aidencastillo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class insertionSort {
    public insertionSort(String arg) {
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
        for (int i = 1; i < n; ++i) {
            int key = randomArray.get(i);
            int j = i - 1;

            while (j >= 0 && randomArray.get(j) > key) {
                randomArray.set(j + 1, randomArray.get(j));
                j = j - 1;
            }
            randomArray.set(j + 1, key);
        }
    }
}
