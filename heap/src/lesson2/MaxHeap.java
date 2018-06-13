package lesson2;

public class MaxHeap<Item> {

    private Item[] data;
    private int count;

    public MaxHeap(int capacity) {
        data = (Item[]) new Object[capacity + 1];
        count = 0;
    }

    // 返回堆中的元素个数
    public int size(){
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }
}
