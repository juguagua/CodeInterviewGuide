package Basics;

public class NetherlandsFlag {
    public static int[] partition(int[] arr,int l,int r,int num){
        int less = l - 1;    // less划定小于num的区域
        int more = r + 1;    // more划定大于num的区域
        while(l < more){     // l 移动进行对数组的遍历，当与大于num的区域相遇时结束
            if (arr[l] < num){
                swap(arr,++less,l);   //当小于num时，l 位置的数与小于区域的后一个数交换，l移向下一个
            }
            else if (arr[l] > num){
                swap(arr,--more,l);     //当大于num时，l位置的数与大于区域的前一个数交换，且l不能直接移动，需判断换过来的数大小
            }
            else if (arr[l] == num){
                l++;
            }

        }
        return new int[]{less + 1,more - 1};
    }
    public static void swap(int[] arr,int i,int j){
        int temp = 0;
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    // for test
    public static int[] generateArrays(int maxSize,int maxValue){
        int[] arr = new int[maxSize];
        for (int i = 0;i < maxSize;i++){
            arr[i] = (int)((maxValue + 1) * Math.random());
        }
        return arr;
    }
    public static void printArrays(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArrays(10,10);
        printArrays(test);
        int[] res = partition(test,0,9,5);
        printArrays(test);
        printArrays(res);
    }


}
