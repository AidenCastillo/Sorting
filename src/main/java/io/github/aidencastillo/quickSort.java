package io.github.aidencastillo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class quickSort {
    public quickSort(String type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // load from arrays.json file
        String fileName = "largeArrays.json";

        try {
            JsonNode rootNode = objectMapper.readTree(new File(fileName));
            JsonNode randomArrayNode = rootNode.path(type);

            List<Integer> randomArray = objectMapper.convertValue(randomArrayNode, List.class);

            // Sort the array
            sort(randomArray, 0, randomArray.size() - 1);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    static void sort (List<Integer> randomArray, int low, int high) {
        if (low < high) {
            int pi = partition(randomArray, low, high);

            sort(randomArray, low, pi - 1);
            sort(randomArray, pi + 1, high);
        }
    }
    static void swap(List<Integer> randomArray, int i, int j) {
        int temp = randomArray.get(i);
        randomArray.set(i, randomArray.get(j));
        randomArray.set(j, temp);
    }

    private static int partition(List<Integer> randomArray, int low, int high) {
        int pivot = randomArray.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (randomArray.get(j) < pivot) {
                i++;

                swap(randomArray, i, j);
            }
        }

        int temp = randomArray.get(i + 1);
        randomArray.set(i + 1, randomArray.get(high));
        randomArray.set(high, temp);

        return i + 1;
    }
}
