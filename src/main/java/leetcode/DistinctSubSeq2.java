package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubSeq2 {

    public int distinctSubseqII(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        long mod = (long) 1e9 + 7;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (2 * dp[i - 1]) % mod;
            char ch = s.charAt(i - 1);
            if (map.containsKey(ch)) {
                int j = map.get(ch);
                dp[i] = ((dp[i] - dp[j - 1]) % mod) + mod;
            }
            map.put(ch, i);
        }
        return (int) ((dp[s.length()] - 1) % mod);
    }

    public static void main(String[] args) {
        DistinctSubSeq2 seq2 = new DistinctSubSeq2();
        System.out.println(seq2.distinctSubseqII("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn"));


    }
}
