package Basics;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{99, 88, 77, 66, 55, 44, 33, 22, 11, 9, 8, 5, 6, 89};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0 || left > right) {
            return;          //注意left < right 的终止条件一定得有，不然递归结束不了爆栈
        }
        int l = left;
        int r = right;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }



        }
        nums[l] = pivot;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
        return;
    }
}

