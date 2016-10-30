package com.xuguo.Sort;

/**
 * Created by xu on 2016/7/20.
 */
public class Main {

    public static void main(String[] argus) {
        Main main = new Main();

        int[] array = {6, 4, 5, 1, 7, 2, 4, 3, 4, 8};

        main.mergeSort(array);
        for (int n : array) {
            System.out.println(n);
        }

    }

    public void mergeSort(int[] a) {
        int[] temp = new int[a.length];
        mergeSortHelper(a, temp, 0, a.length - 1);
    }


    public void mergeSortHelper(int[] a, int[] temp, int left, int right) {//left and right are index
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        mergeSortHelper(a, temp, left, middle);
        mergeSortHelper(a, temp, middle + 1, right);
        merge(a, temp, left, middle, right);
    }

    private void merge(int[] a, int[] temp, int left, int middle, int right) {
        int i = left, j = middle + 1; //i为左数组首元素，j为右数组首元素
        for (int k = 0; k < right - left + 1; k++) {
            if (i <= middle && (j > right || a[i] <= a[j])) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
        }
        for (int k = 0; k < right - left + 1; k++) {
            a[left + k] = temp[k];
        }
    }


    public void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = a[left];
        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            while (i <= j && a[i] < pivot) {
                i++;
            }
            while (i <= j && a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        quickSort(a, left, j);
        quickSort(a, i, right);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, minIndex, i);
        }
    }

    private void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j - i] > a[j]) {
                swap(a, j - 1, j);
                j--;
            }
        }
    }

    private void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }


}
