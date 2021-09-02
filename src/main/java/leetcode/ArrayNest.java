package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayNest {

    boolean[] visited;
    int max = 0;

    public void recur(int[] num, int count, int u) {
        if (visited[u]) {
            max = Math.max(max, count);
            return;
        }
        visited[u] = true;
        recur(num, count + 1, num[u]);
    }

    public int arrayNesting(int[] nums) {
        visited = new boolean[nums.length];
        for (int k : nums) {
            if (!visited[k])
                recur(nums, 0, k);
        }
        return max;
    }


    public int arrayNesting1(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        for (int i = 0; i < nums.length; i++) {
            if (dp[nums[i]] == -1) {
                dp[i] = dp[i] == -1 ? nums[nums[i]] : dp[i];
                if (dp[dp[i]] == -1) dp[dp[i]] = dp[i];
            } else dp[i] = dp[nums[i]];
        }

        for (int j : dp) {
            int f = freq.getOrDefault(j, 0);
            freq.put(j, f + 1);
        }

        for (Map.Entry<Integer, Integer> map : freq.entrySet())
            max = Math.max(max, map.getValue());

        return max;

    }

    public static void main(String[] args) {

        ArrayNest nest = new ArrayNest();
        int[] nums = {1, 2, 3, 4, 0};
        System.out.println(nest.arrayNesting(nums));

    }
}
