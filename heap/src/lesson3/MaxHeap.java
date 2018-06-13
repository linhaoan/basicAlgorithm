package lesson3;

public class MaxHeap<Item extends Comparable> {

    private Item[] data;
    private int count;
    protected int capacity;

    public MaxHeap(int capacity) {
        data = (Item[]) new Object[capacity + 1];
        count = 0;
        this.capacity = capacity;
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

    // 测试 MaxHeap
    public static void main(String[] args) {

        lesson2.MaxHeap<Integer> maxHeap = new lesson2.MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }
}
