package Basics;

public class NumberOfCow {
    public static int cowNumber1(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2 || n == 3){
            return n;
        }
        return cowNumber1(n - 1) + cowNumber1(n - 3);
    }

    public static  int cowNumber2(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2 || n == 3){
            return n;
        }
        int res = 3;
        int pre = 2;
        int prep = 1;
        int tmp1 = 0;
        int tmp2 = 0;

        for (int i = 4;i <= n;i++){
            tmp1 = res;
            tmp2 = pre;
            res += prep;
            pre = tmp1;
            prep = tmp2;
        }
        return res;
    }
}
