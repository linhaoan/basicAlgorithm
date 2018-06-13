package lesson7;

import lesson1.SortTestHelper;

import java.util.Arrays;

public class QuickSort2 {

    // 我们的算法类不允许产生任何实例
    private QuickSort2() {
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

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;

        while (true) {
            while(i<=r && arr[i].compareTo(v)<0) i++;
            while(j>=l+1 && arr[j].compareTo(v)>0) j--;
            if(i>j) {
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
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

        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("lesson6.QuickSort", arr1);
        SortTestHelper.testSort("lesson7.QuickSort2", arr2);



        arr1 = SortTestHelper.generateNearlyOrderedArray(N,100);
        arr2 = Arrays.copyOf(arr1,arr1.length);

        SortTestHelper.testSort("lesson6.QuickSort", arr1);
        SortTestHelper.testSort("lesson7.QuickSort2", arr2);


        arr1 = SortTestHelper.generateRandomArray(N, 0, 100);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("lesson6.QuickSort", arr1);
        SortTestHelper.testSort("lesson7.QuickSort2", arr2);

    }

}
