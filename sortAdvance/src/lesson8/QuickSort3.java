package lesson8;

import lesson1.SortTestHelper;

import java.util.Arrays;

public class QuickSort3 {

    // 我们的算法类不允许产生任何实例
    private QuickSort3() {
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }


    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if(arr[i].compareTo(v)<0) {
                swap(arr,i,lt+1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v)>0) {
                swap(arr,i,gt-1);
                gt --;
            } else { // arr[i] == v
                i++;
            }
        }

        swap( arr, l, lt );

        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("lesson6.QuickSort", arr1);
        SortTestHelper.testSort("lesson8.QuickSort3", arr2);


        arr1 = SortTestHelper.generateNearlyOrderedArray(N, 100);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("lesson6.QuickSort", arr1);
        SortTestHelper.testSort("lesson8.QuickSort3", arr2);


        arr1 = SortTestHelper.generateRandomArray(N, 0, 100);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("lesson6.QuickSort", arr1);
        SortTestHelper.testSort("lesson8.QuickSort3", arr2);

    }

}
