import java.util.*;

public class MaximumSubLengthString {

    public static List<String> maxLength(String str) {

        List<String> temp = new ArrayList<>();

        int maxLength = Integer.MIN_VALUE;

        Map<Character, Integer> indexMap = new HashMap<>();
        List<String> res = new ArrayList<>();

        int mm = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (indexMap.containsKey(ch)) {
                Integer t = indexMap.get(ch);
                if (Math.abs(t - i) > mm) {
                    res.clear();
                    res.add(str.substring(t, i + 1));
                    mm = Math.abs(t - i);
                } else if (Math.abs(t - i) == mm) {
                    res.add(str.substring(t, i + 1));
                }

            } else {
                indexMap.put(ch, i);
            }

        }


        List<String> ll = new ArrayList<>();
        ll.add("A");
        ll.add("B");
        ll.add("C");

        List<String> ll1 = ll;

        ll1.add("d");

        System.out.println(ll);
        System.out.println(ll1);


        return res;


       /* for (int i = 0; i < str.length(); i++) {
            for (int l = 1; l <= str.length() - i; l++) {
                String subStr = str.substring(i, i + l);
                if (subStr.charAt(0) == subStr.charAt(subStr.length() - 1)) {
                    if (subStr.length() > maxLength) {
                        temp.clear();
                        temp.add(subStr);
                        maxLength = subStr.length();
                    } else if (subStr.length() == maxLength)
                        temp.add(subStr);
                }
            }
        }

        return temp;*/

    }

    public static void main(String[] args) {
        System.out.println(maxLength("abacabd"));
    }

}
