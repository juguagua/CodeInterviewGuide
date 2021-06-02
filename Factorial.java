package Basics;

public class Factorial {
    // 暴力递归完成
    public static int getFactorial1(int n){
        if (n == 1){
            return 1;
        }
        return n * getFactorial1(n - 1);
    }

    // 动态规划循环完成，记录了中间过程的解用于下一次的计算
    public static int getFactorial2(int n){
        int res = 1;
        for (int i = 1;i <=n;i++){
            res *= i;
        }
        return res;
    }

}
