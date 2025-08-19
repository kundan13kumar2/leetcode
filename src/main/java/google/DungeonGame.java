package google;

import java.util.PriorityQueue;

public class DungeonGame {

    public int bfs(int[][] mat, int m, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{mat[m][n], m, n});
        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            if (curr[1] == 0 && curr[2] == 0)
                min = Math.min(min, curr[0]);

            if (curr[1] - 1>=0 && curr[2]>=0 && curr[0] + mat[curr[1] - 1][curr[2]] > 0)
                pq.add(new int[]{curr[0] + mat[curr[1] - 1][curr[2]], curr[1] - 1, curr[2]});
            if (curr[2] - 1>=0 && curr[1]>=0 && curr[0] + mat[curr[1]][curr[2] - 1] > 0)
                pq.add(new int[]{curr[0] + mat[curr[1]][curr[2] - 1], curr[1], curr[2] - 1});
        }
        return min+1;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dungeon[i][j] *= -1;
        return bfs(dungeon, m - 1, n - 1);
    }

    public static void main(String[] args) {
        int[][] mat = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(new DungeonGame().calculateMinimumHP(mat));

    }
}
