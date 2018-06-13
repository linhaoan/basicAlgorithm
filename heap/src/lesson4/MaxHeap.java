package lesson4;

public class MaxHeap<Item extends Comparable> {

    private Item[] data;
    private int count;
    protected int capacity;

    public MaxHeap(int capacity){
        data = (Item[])new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(Item arr[]) {
        int n = arr.length;
        data = (Item[])new Comparable[n+1];
        capacity = n;
        for (int i =0;i<n;i++) {
            data[i+1] = arr[i];
        }
        count = n;
        for (int i=count/2;i>=1;i--) {
            shiftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size(){
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item){

        assert count + 1 <= capacity;
        data[count+1] = item;
        count ++;
        shiftUp(count);
    }

    public Item extractMax() {
        assert count >0;
        Item ret = data[1];
        swap(1,count);
        count--;
        shiftDown(1);
        return ret;
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    // 堆 结点data[k]的父结点是 data[k/2]
    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k){

        while( k > 1 && data[k/2].compareTo(data[k]) <0 ){
            swap(k, k/2);
            k /= 2;
        }
    }

    private void shiftDown(int k) {

        while( 2*k <= count ){
            int j = 2*k; // 在此轮循环中,data[k]和data[j]交换位置
            // j+1 <= count 有右孩子
            // data[j+1].compareTo(data[j]) > 0 右孩子比左孩子大
            if( j+1 <= count && data[j+1].compareTo(data[j]) > 0 )
                j ++;
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值

            if( data[k].compareTo(data[j]) >= 0 ) break;
            swap(k, j);
            k = j;
        }
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        lesson2.MaxHeap<Integer> maxHeap = new lesson2.MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }
}
