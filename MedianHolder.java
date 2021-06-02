package Basics;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianHolder {
    public class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1,Integer o2){
            return o1 - o2;     //正数返回第二个，负数返回第一个
        }

    }
    public class MaxHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1,Integer o2){
            return o2 - o1;
        }
    }

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianHolder(){
        maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        minHeap = new PriorityQueue<>(new MinHeapComparator());
    }

    public void addNumber(Integer num){
        if (maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }
        modifyTwoHeap();
    }
    public Integer getMedian(){
        if (maxHeap.isEmpty()){
            return null;
        }
        if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }else if (maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }else {
            return minHeap.peek();
        }
    }
    public void modifyTwoHeap(){
        if (maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
    }
}
