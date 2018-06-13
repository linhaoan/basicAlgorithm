package lesson1;

import java.util.Arrays;

public class InsertionSortAdvance {

    private InsertionSortAdvance() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // 寻找元素arr[i]合适的插入位置
            Comparable e = arr[i];
            //  j保存元素e应该插入的位置
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }

    }

}
