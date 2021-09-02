package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PatchArray {

    public int minPatches(int[] nums, int n) {

        long tillReach = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] <= (tillReach + 1)) {
                tillReach = tillReach + nums[i];
                i++;
            } else {
                tillReach = tillReach * 2 + 1;
                ans++;
            }

            if (tillReach >= n)
                break;
        }


        while (tillReach < n) {
            ans++;
            tillReach = tillReach * 2 + 1;
        }


        return ans;
    }

    /**
     * [1,2,31,33]
     * 2147483647
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 45, 67};
        PatchArray pt = new PatchArray();
        System.out.println(pt.minPatches(arr, 2147483647));
    }
}
