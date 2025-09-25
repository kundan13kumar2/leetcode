package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        List<List<Integer>> items = new ArrayList<>();
        items.add(Arrays.asList(1));
        items.add(Arrays.asList(-5, -2));
        items.add(Arrays.asList(3, 6, 1));
        items.add(Arrays.asList(-1, 2, 4, -3));
        System.out.println(triangle.minimumTotal(items));
        System.out.println(triangle.optimized(items));
    }

    List<List<Integer>> items;

    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        items = triangle;
        dp = new Integer[n][n];

        return recur(n, 0, 0);
    }

    private int recur(int n, int i, int j) {
        if (i >= n - 1) return items.get(i).get(j);

       if (dp[i][j] != null) return dp[i][j];

       int l = recur(n, i + 1,j);
       int r = recur(n,i+1, j+1);
       dp[i][j] = items.get(i).get(j)+ Math.min(l, r);
       return dp[i][j];
    }


    private int optimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        int mem[] = new int[n];

        for (int i = 0; i < triangle.size(); i++) {
            mem[i] = triangle.get(n - 1).get(i);
        }

        for (int row = n-2; row >= 0; row--) {
            for (int col =0 ; col<=row; col++) {
                mem[col] = triangle.get(row).get(col) + Math.min(mem[col], mem[col+1]);
            }
        }
        return mem[0];
    }
}
