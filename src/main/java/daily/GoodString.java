package daily;

import java.util.HashSet;
import java.util.Set;

public class GoodString {
    public static void main(String[] args) {
        GoodString goodString = new GoodString();
        System.out.println(goodString.countGoodSubstrings("xyzzaz"));
    }

    int countGoodSubstrings(String s) {
        int r=0;
        for(int i=1;i<s.length()-1;i++)
            if(s.charAt(i)!=s.charAt(i-1) && s.charAt(i)!=s.charAt(i+1) && s.charAt(i-1)!=s.charAt(i+1)) r++;
        return r;
    }

    public int countGoodSubstrings1(String s) {
        if (s == null || s.length() <= 2) {
            return 0;
        }
        int counter = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            String substring = s.substring(i, i + 3);
            if (allUnique(substring)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean allUnique(String str) {
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        return set.size() == 3;
    }
}
