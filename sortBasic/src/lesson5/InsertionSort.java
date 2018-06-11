package lesson5;

import java.util.Arrays;

public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1;i<n;i++) {
//            for (int j=i;j>0;j--) {
//                if (arr[j].compareTo(arr[j-1])<0) {
//                    swap(arr,j,j-1);
//                } else {
//                    break;
//                }
//            }

            for (int j=i ;j>0 && arr[j].compareTo(arr[j-1])<0;j--) {
                swap(arr,j,j-1);
            }
        }

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;

        Integer[] arr1 = SortTestHelper.getRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("lesson2.SelectionSort", arr1);
        SortTestHelper.testSort("lesson5.InsertionSort", arr2);

    }
}
