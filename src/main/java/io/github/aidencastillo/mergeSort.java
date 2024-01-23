package io.github.aidencastillo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class mergeSort {
    public mergeSort(String arg) {
        ObjectMapper objectMapper = new ObjectMapper();
        // load from arrays.json file
        String fileName = "largeArrays.json";

        try {
            JsonNode rootNode = objectMapper.readTree(new File(fileName));
            JsonNode randomArrayNode = rootNode.path(arg);

            List<Integer> randomArray = objectMapper.convertValue(randomArrayNode, List.class);
//            System.out.println(randomArray.size());

            // Sort the array
            sort(randomArray, 0, randomArray.size() - 1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sort(List<Integer> randomArray, int i, int i1) {
        if (i < i1) {
            int mid = (i + i1) / 2;

            sort(randomArray, i, mid);
            sort(randomArray, mid + 1, i1);

            merge(randomArray, i, mid, i1);
        }
    }

    private void merge(List<Integer> randomArray, int i, int mid, int i1) {
        int n1 = mid - i + 1;
        int n2 = i1 - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int j = 0; j < n1; j++) {
            L[j] = randomArray.get(i + j);
        }
        for (int j = 0; j < n2; j++) {
            R[j] = randomArray.get(mid + 1 + j);
        }

        int k = i;
        int j = 0;
        int l = 0;

        while (j < n1 && l < n2) {
            if (L[j] <= R[l]) {
                randomArray.set(k, L[j]);
                j++;
            } else {
                randomArray.set(k, R[l]);
                l++;
            }
            k++;
        }

        while (j < n1) {
            randomArray.set(k, L[j]);
            j++;
            k++;
        }

        while (l < n2) {
            randomArray.set(k, R[l]);
            l++;
            k++;
        }
    }

}
