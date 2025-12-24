package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams f = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(f.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> tempFreqMap = freqMap;

        for (int i = 0; i < s.length(); ) {
            System.out.println(i);
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (tempFreqMap.containsKey(c)) {
                    tempFreqMap.put(c, tempFreqMap.get(c) - 1);
                    if (tempFreqMap.get(c) == 0) {
                        tempFreqMap.remove(c);
                    }
                } else {
                    i = j;
                    tempFreqMap = new HashMap<>(freqMap);
                    break;
                }

                if (tempFreqMap.isEmpty()) {
                    ans.add(i);
                    i = j;
                    tempFreqMap = new HashMap<>(freqMap);
                    break;
                }
            }
        }


        return ans;
    }
}
