package org.example.algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        mergSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergSort(arr, left, middle);
            mergSort(arr, middle + 1, right);

            merg(arr, left, middle, right);
        }
    }

    private static void merg(int[] arr, int left, int middle, int right) {
        int length_left = middle - left + 1;
        int length_right = right - middle;

        int[] leftArray = new int[length_left];
        int[] rightArray = new int[length_right];

        System.arraycopy(arr, left, leftArray, 0, length_left);
        System.arraycopy(arr, middle + 1, rightArray, 0, length_right);

        int i = 0, j = 0, k = left;

        while (i < length_left && j < length_right) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < length_left) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < length_right) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
