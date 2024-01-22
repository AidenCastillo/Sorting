package io.github.aidencastillo;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class Main {
    public static void main(String[] args) throws IOException {
        // clear data.txt
        String fileName = "data.txt";
        FileWriter writer = new FileWriter(fileName);
        writer.write("");
        writer.close();

        runQuickSort("Random", "million.json");
//        runQuickSort("Descending");
//        runQuickSort("Partially Random");
//        runQuickSort("Ordered");
//        runQuickSort("Duplicates");

//        runMergeSort("Random");
//        runMergeSort("Descending");
//        runMergeSort("Partially Random");
//        runMergeSort("Ordered");
//        runMergeSort("Duplicates");
    }

    private static void runBubbleSort(String arg) {
    }

    private static void runSelectionSort(String arg) {
    }

    private static void runInsertionSort(String arg) {
    }

    private static void runMergeSort(String arg) {
        long startTime = System.nanoTime();
        long startCpuTime = getCpuTime();

        new mergeSort(arg);

        long endTime = System.nanoTime();
        long endCpuTime = getCpuTime();

        long elapsedTime = endTime - startTime;
        long elapsedCpuTime = endCpuTime - startCpuTime;

        System.out.println("Elapsed time: " + elapsedTime + "ns");
        System.out.println("Elapsed CPU time: " + elapsedCpuTime + "ns");

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryBean = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryBean = memoryBean.getNonHeapMemoryUsage();

        System.out.println("Heap memory: " + heapMemoryBean.getUsed() + " bytes");
        System.out.println("Non-heap memory: " + nonHeapMemoryBean.getUsed() + " bytes");

        // Write data to text file
        String fileName = "data.txt";

        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.append("mergeSort.java\n");
            writer.append("Type: ").append(arg).append("\n");
            writer.append("Elapsed time: ").append(String.valueOf(elapsedTime)).append("\n");
            writer.append("Elapsed CPU time: ").append(String.valueOf(elapsedCpuTime)).append("\n");
            writer.append("Heap memory: ").append(String.valueOf(heapMemoryBean.getUsed())).append("\n");
            writer.append("Non-heap memory: ").append(String.valueOf(nonHeapMemoryBean.getUsed())).append(" \n");
            writer.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runQuickSort(String type, String s) throws IOException {
        long startTime = System.nanoTime();
        long startCpuTime = getCpuTime();

        new quickSort(type, s);

        long endTime = System.nanoTime();
        long endCpuTime = getCpuTime();

        long elapsedTime = endTime - startTime;
        long elapsedCpuTime = endCpuTime - startCpuTime;

        System.out.println("Elapsed time: " + elapsedTime + "ns");
        System.out.println("Elapsed CPU time: " + elapsedCpuTime + "ns");

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryBean = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryBean = memoryBean.getNonHeapMemoryUsage();

        System.out.println("Heap memory: " + heapMemoryBean.getUsed() + " bytes");
        System.out.println("Non-heap memory: " + nonHeapMemoryBean.getUsed() + " bytes");

        // Write data to text file
        String fileName = "data.txt";

        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.append("quickSort.java\n");
            writer.append("Type: ").append(type).append("\n");
            writer.append("Elapsed time: ").append(String.valueOf(elapsedTime)).append("\n");
            writer.append("Elapsed CPU time: ").append(String.valueOf(elapsedCpuTime)).append("\n");
            writer.append("Heap memory: ").append(String.valueOf(heapMemoryBean.getUsed())).append(" bytes\n");
            writer.append("Non-heap memory: ").append(String.valueOf(nonHeapMemoryBean.getUsed())).append(" bytes\n\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getCpuTime() {
        return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
    }
}