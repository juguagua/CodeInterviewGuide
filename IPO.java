package Basics;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public class Program{
        public int cost;
        public int profit;
        public Program(int cost,int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }
    public class CostMinComp implements Comparator<Program>{
        @Override
        public int compare(Program o1,Program o2){
            return o1.cost - o2.cost;
        }
    }
    public class ProfitMaxComp implements Comparator<Program>{
        @Override
        public int compare(Program o1,Program o2){
            return o2.profit - o1.profit;
        }
    }
    public int getMaxMoney(int w,int k,int[] costs,int[] profits){
        if (w < 1 || k < 0 || costs == null || profits == null || costs.length != profits.length){
            return w;
        }
        PriorityQueue<Program> costMinHeap = new PriorityQueue<>(new CostMinComp());
        PriorityQueue<Program> profitMaxHeap = new PriorityQueue<>(new ProfitMaxComp());
        for (int i = 0;i < costs.length;i++){
            costMinHeap.add(new Program(costs[i],profits[i]));
        }
        for (int i = 1;i <= k;i++){
            while (!costMinHeap.isEmpty() && costMinHeap.peek().cost <= w){
                profitMaxHeap.add(costMinHeap.poll());
            }
            if (profitMaxHeap.isEmpty()){
                return w;
            }
            w += profitMaxHeap.poll().profit;
        }
        return w;
    }


}
