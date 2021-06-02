package Basics;

import java.util.PriorityQueue;

public class MinSplitCost {
    public int getMinSplitCost(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        //创建优先级队列，其默认是小顶堆结构
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0;i < arr.length;i++){
            minHeap.add(arr[i]);
        }
        int ans = 0;

        while (!minHeap.isEmpty()){
            int sum = minHeap.poll() + minHeap.poll();
            ans += sum;
            minHeap.add(sum);
        }
        return ans;
    }
}
