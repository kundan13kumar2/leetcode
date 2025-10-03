package daily;

import java.util.LinkedList;
import java.util.List;

public class ArithSlice {
    public static void main(String[] args) {
        ArithSlice arithSlice = new ArithSlice();
        int[] arr = {3, 7, 11, 10, 12, 17, 22, 27, 32, 37};
        System.out.println(arithSlice.numberOfArithmeticSlices(arr));
    }

    int ans = 0;
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 0;

        for (int i = 1; i < n - 1; ) {
            List<Integer> list = new LinkedList<>();
            int diff = nums[i] - nums[i - 1];
            list.add(nums[i - 1]);
            list.add(nums[i]);
            i += 1;
            while (i < n) {
                if (nums[i] - nums[i - 1] == diff) {
                    list.add(nums[i]);
                    i++;
                } else break;
            }
            if (list.size() > 2) {
                Integer[] dp = new Integer[list.size()];
                recur(2, list.size(), list, dp);
            }
        }

        return ans;
    }

    public void recur(int c, int n, List<Integer> arr, Integer[] dp) {
        if (c == n) return;
        if (dp[c] != null) return;
        for (int i = c; i < n; i++) {
            if ((arr.get(i) - arr.get(i - 1)) == (arr.get(i - 1) - arr.get(i - 2))) {
                ans += 1;
                dp[i] = ans;
                recur(i + 1, n, arr, dp);
            }
        }
    }
}
