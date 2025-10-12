package daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MagicSpells {
    public static void main(String[] args) {

        int[] arr = {7, 1, 6, 6};
        MagicSpells sp = new MagicSpells();
        int n = arr.length;
        System.out.println(sp.maximumTotalDamage(arr));

    }

    Map<Integer, Integer> freqMap = new HashMap<>();
    long[] dp;

    private long recur(int[] arr, int i) {
        if (i < 0 || i >= arr.length) return 0;

        if (dp[i] != -1) return dp[i];
        long skip = recur(arr, i + 1);
        int j = findIndex(arr, i + 1, arr.length, arr[i] + 3);
        long taken = (long) arr[i] * freqMap.get(arr[i]) + recur(arr, j);

        return dp[i] = Math.max(skip, taken);
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);

        for (int x : power) {
            int freq = freqMap.getOrDefault(x, 0);
            freqMap.put(x, freq + 1);
        }
        dp = new long[power.length + 1];
        Arrays.fill(dp, -1);

        return recur(power, 0);
    }

    private int findIndex(int[] arr, int l, int r, int val) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < val) l = mid + 1;
            else r = mid;
        }
        return l < arr.length ? l : -1;
    }

}
