package leetcode;

import java.util.*;

public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Long> map = new TreeMap<>();
        map.put(keysPressed.charAt(0), (long) releaseTimes[0]);
        for (int i = 1; i < releaseTimes.length; i++) {
            long p = map.getOrDefault(keysPressed.charAt(i), Long.MIN_VALUE);
            long curr = (releaseTimes[i] - releaseTimes[i - 1]);
            map.put(keysPressed.charAt(i), Math.max(p, curr));
        }

        List<Map.Entry<Character, Long>> list
                = new LinkedList<Map.Entry<Character, Long>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Long>>() {
            @Override
            public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
                if (o1.getValue().equals(o2.getValue()))
                    return o2.getKey() - o1.getKey();
                else return (int) (o2.getValue() - o1.getValue());
            }
        });

        return list.get(0).getKey();

    }

    public static void main(String[] args) {

        int[] releaseTimes = {12, 23, 36, 46, 62};
        String str = "spuda";
        System.out.println(new SlowestKey().slowestKey(releaseTimes, str));

    }
}
