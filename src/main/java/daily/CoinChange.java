package daily;

import java.util.Arrays;

public class CoinChange {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int recur(int[] coins, int i, int remaining, int[][] memo) {
        if (remaining == 0) return 0;
        if (i >= coins.length || remaining < 0) return INF;


        if (memo[i][remaining] != -1) {
            return memo[i][remaining];
        }

        int take = 1 + recur(coins, i, remaining - coins[i], memo);

        int skip = recur(coins, i + 1, remaining, memo);

        memo[i][remaining] = Math.min(take, skip);
        return memo[i][remaining];
    }

    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = recur(coins, 0, amount, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;

        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                memo[i][j] = -1;
            }
        }

        int ans = cc.coinChange(coins, amount);
        System.out.println(ans >= INF ? -1 : ans);
    }
}
