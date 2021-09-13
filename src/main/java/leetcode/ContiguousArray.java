package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0] == 0 ? -1 : 1, 0);
        int max = Integer.MIN_VALUE;
        int[] sum = new int[nums.length];
        int currSum = nums[0] == 0 ? -1 : 1;
        sum[0] = currSum;
        for (int j = 1; j < nums.length; j++) {
            currSum = sum[j - 1] + (nums[j] == 0 ? -1 : 1);
            if (map.containsKey(currSum)) {
                int i = map.get(currSum);
                max = Math.max(max, j - i);
            } else
                map.put(currSum, j);
            sum[j] = currSum;

        }
        return max;
    }

    public static void main(String[] args) {
        ContiguousArray array = new ContiguousArray();
        System.out.println(array.findMaxLength(new int[]{0, 1, 1}));
    }
}
