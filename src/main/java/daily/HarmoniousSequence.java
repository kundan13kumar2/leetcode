package daily;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HarmoniousSequence {
    public static void main(String[] args) {
        HarmoniousSequence hs = new HarmoniousSequence();
        System.out.println(hs.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }

    public int findLHS(int[] nums) {

        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int min = entry.getKey();
            int max =  min+1;

            if (map.containsKey(max)){
                result= Math.max(result, map.get(max)+entry.getValue());
            }

        }
        return result;
    }
}
