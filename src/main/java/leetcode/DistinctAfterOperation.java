package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctAfterOperation {
    public static void main(String[] args) {
        DistinctAfterOperation d = new DistinctAfterOperation();
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5};
        int k = 3;
        System.out.println(d.maxDistinctElements(nums, k));
    }

    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        int prev = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < n; i++) {
            int minVal = nums[i] - k;
            if (prev < minVal) {
                prev = minVal;
                count++;
            } else if (prev < nums[i] + k) {
                prev = prev + 1;
                count++;
            }
        }
        return count;
    }


    public int maxDistinctElements1(int[] nums, int k) {
        Arrays.sort(nums);
        int lastUsed = -1 * k;
        nums[0] = nums[0] + lastUsed;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i] + lastUsed;
            int temp = lastUsed;
            while (val == nums[i - 1] && temp <= k) {
                val = nums[i] + temp;
                if (val != nums[i - 1]) {
                    break;
                } else
                    temp++;
            }
            if (val == nums[i - 1])
                break;
            else {
                nums[i] = val;
                lastUsed = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        return sets.size();
    }
}
