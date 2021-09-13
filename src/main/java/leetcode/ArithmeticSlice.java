package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSlice {

    public int numberOfArithmeticSlices(int[] nums) {

        List<Map<Long, Long>> resultMap = new ArrayList<>();
        int n = nums.length;
        int res = 0;
        resultMap.add(new HashMap<>());

        for (int i = 1; i < n; i++) {
            long k = nums[i];
            Map<Long, Long> currMap = new HashMap<>();
            for (int j = 0; j < i; j++) {
                Map<Long, Long> prevMap = resultMap.get(j);
                long p = k - nums[j];
                long t = prevMap.getOrDefault(p, 0l);
                if (t >= 1) res += t;
                long m = currMap.getOrDefault(p, 0l);
                currMap.put(p, t + m + 1);
            }
            resultMap.add(currMap);
        }

        return res;
    }

    public static void main(String[] args) {
        ArithmeticSlice ar = new ArithmeticSlice();
        System.out.println(ar.numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296}));
    }
}
