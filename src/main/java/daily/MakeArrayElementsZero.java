package daily;

import java.util.Arrays;

public class MakeArrayElementsZero {
    public static void main(String[] args) {
        MakeArrayElementsZero solution = new MakeArrayElementsZero();
        int[] nums = {1, 0, 2, 0, 3};
        int result = solution.countValidSelections(nums);
        System.out.println("Number of valid selections: " + result);
    }

    public int countValidSelections(int[] nums) {
        int ans = 0;
        int prefSum = 0;
        int totalSum = Arrays.stream(nums).sum();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            prefSum += nums[i];
            int leftSum = prefSum;
            int rightSum = totalSum - prefSum;
            if (nums[i]==0) continue;
            if (leftSum == rightSum) {
                ans += 2;
            } else if (Math.abs(leftSum - rightSum) == 1) {
                ans += 1;
            }
        }
        return ans;

    }
}
