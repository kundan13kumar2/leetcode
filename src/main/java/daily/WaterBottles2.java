package daily;

public class WaterBottles2 {

    int maxDrink = 0;

    public static void main(String[] args) {
        WaterBottles2 solution = new WaterBottles2();
        System.out.println(solution.sol2(13, 6));
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        Integer[][] dp = new Integer[201][201];
        recur(numBottles, 0, numExchange, dp);
        return maxDrink;
    }

    public void recur(int full, int empty, int exchange, Integer[][] dp) {
        if (full == 0 && empty < exchange) return;
        if (dp[full][exchange] != null) {
            maxDrink = Math.max(maxDrink, dp[full][exchange]);
        }
        if (full > 0) {
            maxDrink += full;
            dp[full][exchange] = maxDrink;
            recur(0, empty + full, exchange, dp);
        } else {
            recur(full + 1, empty - exchange, exchange + 1, dp);
        }
    }

    public int sol2(int numBottles, int numExchange){
        int emptyBottles = 13;
        int ans = numBottles;
        while (emptyBottles>=numExchange){
            emptyBottles -= numExchange;
            numExchange++;
            ans++;
            emptyBottles++;
        }
        return ans;
    }

}
