package daily;

import java.util.Arrays;

public class MysticDungeon {
    public static void main(String[] args) {
        int[] arr ={-2,-3,-1};
        MysticDungeon md = new MysticDungeon();
        System.out.println(md.maximumEnergy(arr, 2));
    }

    private int maximumEnergy(int[] energy, int k){

        for(int i = 0; i <= energy.length-k; i++){
            int sum= energy[i];
            for (int j=i+k; j<energy.length; j+=k){
                sum+=energy[j];
            }
            energy[i]=sum;
        }
        int max = Integer.MIN_VALUE;
        for (int j : energy) {
            max = Math.max(max, j);
        }
        return max;
    }

    public int maximumEnergy2(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new  int[n];
        int max = Integer.MIN_VALUE;
        for (int i= n-1; i >= 0; i--) {
            dp[i]= energy[i];
            if (i+k<n){
                dp[i]+= dp[i+k];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
