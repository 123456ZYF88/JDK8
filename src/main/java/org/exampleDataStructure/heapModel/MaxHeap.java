package org.exampleDataStructure.heapModel;

/**
 * 堆定义
 *<a href="https://www.runoob.com/data-structures/heap-storage.html">...</a>
 */
public class MaxHeap<T> {
    private T[] data;
    private int count;

    //构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity){
        data = (T[])new Object[capacity+1];
        count = 0;
    }
    //返回堆中的元素个数
    public int size(){
        return count;
    }
    //返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }
    //测试 MaxHeap
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }


}
