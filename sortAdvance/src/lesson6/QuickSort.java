package lesson6;

import lesson1.SortTestHelper;

import java.util.Arrays;

public class QuickSort {

    // 我们的算法类不允许产生任何实例
    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v

        for (int i = l + 1; i < r; i++) {
            if(arr[i].compareTo(v)<0) {
                j++;
                swap(arr,j,i);
            }
        }
        swap(arr, l, j);

        return j;
    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {

        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);


        SortTestHelper.testSort("lesson6.QuickSort", arr);
        SortTestHelper.testSort("lesson4.MergeSortBU", arr1);


        Integer[] arr2 = SortTestHelper.generateNearlyOrderedArray(N,100);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);

        SortTestHelper.testSort("lesson6.QuickSort", arr2);
        SortTestHelper.testSort("lesson4.MergeSortBU", arr3);
    }

}
