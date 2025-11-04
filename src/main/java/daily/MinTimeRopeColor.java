package daily;

import java.util.Arrays;

public class MinTimeRopeColor {

    public static void main(String[] args) {
        String colors = "bbbaaa";
        int[] neededTime = {4,9,3,8,8,9};
        MinTimeRopeColor m = new MinTimeRopeColor();
        System.out.println(m.minCost(colors, neededTime));
    }

    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int totalSum = Arrays.stream(neededTime).sum();
        int l = 1;
        int max = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i-1)==colors.charAt(i)) {
                l++;
                max = Math.max(max, neededTime[i]);
            } else {
                if (l >= 1) {
                    ans += max;
                }
                l = 1;
                max = neededTime[i];
            }
        }

        if (l >= 1) {
            ans += max;
        }


        return totalSum-ans;
    }
}
