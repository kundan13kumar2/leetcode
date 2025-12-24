package leetcode;

import java.util.Arrays;

public class RegularExpression {

    public static void main(String[] args) {

        String str = "aa";
        String pattern = "a*";
        RegularExpression regularExpression = new RegularExpression();
        System.out.println(regularExpression.isMatch(str, pattern));
    }

    int[][] dp = new int[21][21];

    public boolean recur(int i, int j, String s, String p) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean firstCharMatched = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

        if (p.length() > 2 && p.charAt(j + 1) == '*') {
            boolean noTake = recur(i, j + 2, s, p);
            boolean take = firstCharMatched && recur(i + 1, j, s, p);

            dp[i][j] = (noTake || take) ? 1 : 0;
            return dp[i][j] == 1;
        }
        dp[i][j] = firstCharMatched && recur(i + 1, j + 1, s, p) ? 1 : 0;
        return dp[i][j] == 1;
    }


    public boolean isMatch(String s, String p) {
        for (int i = 0; i < 21; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(0, 0, s, p);
    }
}
