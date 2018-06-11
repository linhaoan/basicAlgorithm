package lesson7;

import lesson6.SortTestHelper;

public class BubbleSort {

    // 我们的算法类不允许产生任何实例
    private BubbleSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        boolean swapped = false;

        do{
            swapped = false;
            for( int i = 1 ; i < n ; i ++ ) {
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    swap( arr , i-1 , i );
                    swapped = true;
                }
            }
            n --;
        }while(swapped);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20;

        Integer[] arr1 = lesson5.SortTestHelper.getRandomArray(N, 0, N);


        printArray(arr1);
        SortTestHelper.testSort("lesson7.BubbleSort", arr1);
        printArray(arr1);

    }

    // 打印arr数组的所有内容
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();
    }
}
