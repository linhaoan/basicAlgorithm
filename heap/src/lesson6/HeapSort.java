package lesson6;

import lesson4.MaxHeap;
import lesson5.SortTestHelper;

public class HeapSort {

    private HeapSort() {

    }


    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);

        // heapify
        for( int i = (n-1-1)/2 ; i >= 0 ; i -- ){
            shiftDown(arr,n,i);
        }
        for(int i = n-1;i>0;i--) {
            swap(arr,0,i);
            shiftDown(arr,i,0);
        }

    }

    private static void shiftDown(Comparable[] arr, int n, int k) {

        while( 2*k+1 < n ){
            int j = 2*k+1; // 在此轮循环中,arr[k] arr[j]交换位置
            // j+1 <= count 有右孩子
            // arr[j+1].compareTo(arr[j]) > 0 右孩子比左孩子大
            if( j+1 < n && arr[j+1].compareTo(arr[j]) > 0 )
                j ++;
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值

            if( arr[k].compareTo(arr[j]) >= 0 ) break;
            swap(arr,k, j);
            k = j;
        }
    }


    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 HeapSort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.testSort("lesson6.HeapSort", arr);

        return;
    }
}
