package io.github.aidencastillo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class bubbleSort {
    public bubbleSort(String arg) {
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
            for (int j = 0; j < (n - i - 1); j++) {
                if (randomArray.get(j) > randomArray.get(j + 1)) {
                    int temp = randomArray.get(j);
                    randomArray.set(j, randomArray.get(j + 1));
                    randomArray.set(j + 1, temp);
                }
            }
        }
    }
}
