package leetcode;

public class CountSubsequence {

    public int numDistinct(String s, String t) {

        int r = s.length();
        int c = t.length();

        int[][] dp = new int[r + 1][c + 1];

        for (int i = 0; i <= r; i++)
            dp[i][0] = 1;

        for (int j = 1; j <= c; j++)
            dp[0][j] = 0;


        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[r][c];

    }

    public static void main(String[] args) {

        CountSubsequence seq = new CountSubsequence();

        System.out.println(seq.numDistinct("rabbbit", "rabbit"));

    }
}
