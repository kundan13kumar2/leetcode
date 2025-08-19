package week256;

import java.util.Arrays;

public class MinDiff {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int j = k - 1;
        for (int i = 0; i <= nums.length - k; i++) {
            j = i + k - 1;
            diff = Math.min(diff, nums[j] - nums[i]);
        }

        return diff == Integer.MAX_VALUE ? 0 : diff;
    }

    /**
     * [87063,61094,44530,21297,95857,93551,9918]
     * 6
     *
     * @param args
     */
    public static void main(String[] args) {

        MinDiff diff = new MinDiff();
        int[] nums = {87063, 61094, 44530, 21297, 95857, 93551, 9918};
        System.out.println(diff.minimumDifference(nums, 6));


    }
}
