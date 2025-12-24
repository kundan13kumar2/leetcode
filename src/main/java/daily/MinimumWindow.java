package daily;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindow {
    public static void main(String[] args) {

        MinimumWindow solution = new MinimumWindow();
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(solution.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = constructTMap(t);
        Map<Character, Integer> rMap = new HashMap<>();
        if (s.length() == 1 && t.length() == 1 && s.charAt(0) == t.charAt(0)) {
            return s;
        }
        if (t.length() == 1) {
            if (s.contains("" + t.charAt(0)))
                return t;
            else return "";
        }
        int i = 0, j = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        while (j < s.length()) {
            if (tMap.containsKey(s.charAt(j))) {
                int freq = rMap.getOrDefault(s.charAt(j), 0);
                rMap.put(s.charAt(j), freq + 1);
            }
            while (tMap.size()==rMap.size() && i<j) {
                if (((j - i) < min) && check(tMap,rMap)) {
                    ans = s.substring(i, j + 1);
                    min = j - i+1;
                }
                if (!tMap.containsKey(s.charAt(i))) i++;
                else if (tMap.containsKey(s.charAt(i)) && rMap.get(s.charAt(i)) > tMap.get(s.charAt(i))) {
                    int f = rMap.get(s.charAt(i));
                    if (f - 1 == 0)
                        rMap.remove(s.charAt(i));
                    else
                        rMap.put(s.charAt(i), f - 1);
                    i++;
                }else break;
            }
            j++;
        }

        return ans;
    }

    private Boolean check(Map<Character, Integer> tMap, Map<Character, Integer> rMap) {
        if (tMap.size() != rMap.size()) return false;

        return tMap.entrySet().stream().allMatch(e -> e.getValue()<=rMap.getOrDefault(e.getKey(), 0));
    }

    Map<Character, Integer> constructTMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int freq = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), freq + 1);
        }
        return map;
    }

}
