package leetcode;

public class MaxProduct {
    public static void main(String[] args) {

        int[] arr = {-1, -2, -2};

        int max = Integer.MIN_VALUE;
        int temp = 1;

        for (int j : arr) {
            temp *= j;
            max = Math.max(max, temp);
            if (temp == 0)
                temp = 1;
        }

        temp = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            temp *= arr[i];
            max = Math.max(temp, max);
            if (temp == 0)
                temp = 1;
        }
        System.out.println(max);
    }
}
