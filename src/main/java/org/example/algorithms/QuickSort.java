package org.example.algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low <= high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int index = low - 1;

        for (int i = low; i <= high - 1; i++) {
            if (arr[i] <= pivot) {
                index++;

                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[index + 1];
        arr[index + 1] = arr[high];
        arr[high] = temp;

        return index + 1;
    }
}
