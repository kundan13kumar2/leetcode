package leetcode;

import java.util.Arrays;

public class Checknew {


    static int[] arr = new int[]{5, 2, 9, 4, 6, 8};


    static int bSearch(int k) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] == k) return k;
            if (arr[mid] > k) {
                if (mid > 0 && k > arr[mid - 1]) {
                    int p = getClose(arr[mid - 1], arr[mid], k);
                    if (p <= k) return p;

                }
                r = mid;

            } else {

                if (mid < arr.length - 1 && k < arr[mid + 1]) {
                    int p = getClose(arr[mid], arr[mid + 1], k);
                    if (p <= k) return p;
                }
                l = mid + 1;
            }
        }

        return arr[mid];
    }

    public static int getClose(int val1, int val2, int k) {
        if (k - val1 >= val2 - k && k <= val2) return val2;
        else if (k < val1)
            return val1;
        return Integer.MAX_VALUE;
    }


    static int nearestVal(int k) {

        int[] temp = new int[arr.length];

        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            temp[i] = Math.abs(arr[i] - k);
            if (min >= temp[i]) {
                min = temp[i];
                if (arr[i] <= k)
                    res = arr[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(bSearch(7));

    }
}
