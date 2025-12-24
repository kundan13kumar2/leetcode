package daily;

import java.util.HashMap;

public class LongestNice {
    public static void main(String[] args) {
        LongestNice longestNice = new LongestNice();
        System.out.println(longestNice.longestNiceSubstring("dDzeE"));
        System.out.println(longestNice.longestNiceSubstring("c"));
    }

    public String longestNiceSubstring(String s) {
        if (s.length()<2) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(Character.toLowerCase(s.charAt(i))) && map.containsKey(Character.toUpperCase(s.charAt(i)))) continue;

            String prev = longestNiceSubstring(s.substring(0, i));
            String next = longestNiceSubstring(s.substring(i+1));

            return prev.length() >= next.length() ? prev : next;
        }
        return s;
    }
}
