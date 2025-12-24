package daily;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WithoutRepeat {
    public static void main(String[] args) {
        WithoutRepeat sol = new WithoutRepeat();
        String str = "tmmzuxt";
        System.out.println(sol.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();

        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (!queue.isEmpty()) {
                    Character c = queue.poll();
                    set.remove(c);
                    if (c.equals(s.charAt(i))) {
                        break;
                    }
                }
                set.remove(s.charAt(i));
            }
            queue.offer(s.charAt(i));
            set.add(s.charAt(i));
            max = Math.max(max, queue.size());
        }
        return max;
    }
}
