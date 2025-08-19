package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumRabbits {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int num : answers) {
            int f = map.getOrDefault(num, 0);
            map.put(num, f + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key + 1 >= value)
                ans += (key + 1);
            else {
                key = key + 1;
                int temp = key;
                while (key < value)
                    key += temp;
                ans += key;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] answer = {2, 2, 3, 1, 0, 2, 2, 3, 1};
        NumRabbits numRabbits = new NumRabbits();
        System.out.println(numRabbits.numRabbits(answer));
    }
}
