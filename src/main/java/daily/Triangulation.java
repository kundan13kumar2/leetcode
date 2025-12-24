package daily;

public class Triangulation {

    public static void main(String[] args) {
        Triangulation t = new Triangulation();
        int[] arr = {3,7,4,5};
        int i=0, n=arr.length;
        Integer[][] dp = new Integer[n][n];
        System.out.println(t.recur(arr, 0,n-1,dp));

    }

    public int recur(int[] value, int i, int j, Integer[][] dp){
        if (i+1==j) return 0;
        if (dp[i][j]!=null) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k =i+1; k<j; k++) {
            ans = Math.min(ans,value[i]*value[j]*value[k]+recur(value,i,k,dp)+recur(value,k,j,dp));
        }
        dp[i][j]=ans;
        return ans;
    }

}
