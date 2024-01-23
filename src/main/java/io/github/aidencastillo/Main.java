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

//        runQuickSort("Random");
//        runQuickSort("Descending");
//        runQuickSort("Duplicates");
//        runQuickSort("Ordered");
//        runQuickSort("Duplicates");

//        runMergeSort("Random");
//        runMergeSort("Descending");
//        runMergeSort("Partially Random");
//        runMergeSort("Ordered");
//        runMergeSort("Duplicates");

//        runInsertionSort("Random");
//        runInsertionSort("Descending");
//        runInsertionSort("Partially Random");
//        runInsertionSort("Ordered");
//        runInsertionSort("Duplicates");

//        runSelectionSort("Random");
//        runSelectionSort("Descending");
//        runSelectionSort("Partially Random");
//        runSelectionSort("Ordered");
//        runSelectionSort("Duplicates");

//        runBubbleSort("Random");
//        runBubbleSort("Descending");
//        runBubbleSort("Partially Random");
//        runBubbleSort("Ordered");
        runBubbleSort("Duplicates");

    }

    private static void runBubbleSort(String arg) {
        long startTime = System.nanoTime();
        long startCpuTime = getCpuTime();
        long startTime2 = System.currentTimeMillis();

        new bubbleSort(arg);

        long endTime = System.nanoTime();
        long endCpuTime = getCpuTime();
        long endTime2 = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        long elapsedCpuTime = endCpuTime - startCpuTime;

        System.out.println("Elapsed time: " + elapsedTime + "ns");
        System.out.println("Elapsed CPU time: " + elapsedCpuTime + "ns");
        System.out.println("Elapsed time: " + (endTime2 - startTime2) + "ms");

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryBean = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryBean = memoryBean.getNonHeapMemoryUsage();

        System.out.println("Heap memory: " + heapMemoryBean.getUsed() + " bytes");
        System.out.println("Non-heap memory: " + nonHeapMemoryBean.getUsed() + " bytes");

        // Write data to text file
        String fileName = "data.txt";

        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.append("bubbleSort.java\n");
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

    private static void runSelectionSort(String arg) {
        long startTime = System.nanoTime();
        long startCpuTime = getCpuTime();
        long startTime2 = System.currentTimeMillis();

        new selectionSort(arg);

        long endTime = System.nanoTime();
        long endCpuTime = getCpuTime();
        long endTime2 = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        long elapsedCpuTime = endCpuTime - startCpuTime;

        System.out.println("Elapsed time: " + elapsedTime + "ns");
        System.out.println("Elapsed CPU time: " + elapsedCpuTime + "ns");
        System.out.println("Elapsed time: " + (endTime2 - startTime2) + "ms");

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryBean = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryBean = memoryBean.getNonHeapMemoryUsage();

        System.out.println("Heap memory: " + heapMemoryBean.getUsed() + " bytes");
        System.out.println("Non-heap memory: " + nonHeapMemoryBean.getUsed() + " bytes");

        // Write data to text file
        String fileName = "data.txt";

        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.append("selectionSort.java\n");
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

    private static void runInsertionSort(String arg) {
        long startTime = System.nanoTime();
        long startCpuTime = getCpuTime();
        long startTime2 = System.currentTimeMillis();

        new insertionSort(arg);

        long endTime = System.nanoTime();
        long endCpuTime = getCpuTime();
        long endTime2 = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        long elapsedCpuTime = endCpuTime - startCpuTime;

        System.out.println("Elapsed time: " + elapsedTime + "ns");
        System.out.println("Elapsed CPU time: " + elapsedCpuTime + "ns");
        System.out.println("Elapsed time: " + (endTime2 - startTime2) + "ms");

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryBean = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryBean = memoryBean.getNonHeapMemoryUsage();

        System.out.println("Heap memory: " + heapMemoryBean.getUsed() + " bytes");
        System.out.println("Non-heap memory: " + nonHeapMemoryBean.getUsed() + " bytes");

        // Write data to text file
        String fileName = "data.txt";

        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.append("insertionSort.java\n");
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

    private static void runQuickSort(String type) throws IOException {
        long startTime = System.nanoTime();
        long startCpuTime = getCpuTime();
        long startTime2 = System.currentTimeMillis();

        new quickSort(type);

        long endTime = System.nanoTime();
        long endCpuTime = getCpuTime();
        long endTime2 = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        long elapsedCpuTime = endCpuTime - startCpuTime;


        System.out.println("Elapsed time: " + elapsedTime + "ns");
        System.out.println("Elapsed CPU time: " + elapsedCpuTime + "ns");
        System.out.println("Elapsed time: " + (endTime2 - startTime2) + "ms");

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