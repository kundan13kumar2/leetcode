package biweek60;


import java.util.ArrayList;
import java.util.List;

public class FirmLand {
    boolean[][] visited;
    int r, c;

    public boolean isValid(int i, int j) {
        if (i >= r || i < 0 || j >= c || j < 0 || visited[i][j])
            return false;
        return true;
    }


    public void dfs(int i, int j, int[] ans, int[][] land) {

        visited[i][j] = true;
        if (i == r - 1 && j == c - 1) {
            ans[2] = i;
            ans[3] = j;
        } else if (i + 1 < r && j + 1 < c && land[i + 1][j] == 0 && land[i][j + 1] == 0) {
            ans[2] = i;
            ans[3] = j;
        } else if (isValid(i + 1, j) && j == c - 1 && land[i + 1][j] == 0) {
            ans[2] = i;
            ans[3] = j;
        } else if (isValid(i, j + 1) && i == r - 1 && land[i][j + 1] == 0) {
            ans[2] = i;
            ans[3] = j;
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for (int p = 0; p < 4; p++) {
            int rx = i + dx[p];
            int ry = j + dy[p];
            if (isValid(rx, ry) && land[rx][ry] == 1)
                dfs(rx, ry, ans, land);

        }
    }

    public int[][] findFarmland(int[][] land) {

        r = land.length;
        c = land[0].length;
        visited = new boolean[r][c];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int[] ans = new int[4];
                if (land[i][j] == 1 && !visited[i][j]) {
                    ans[0] = i;
                    ans[1] = j;
                    dfs(i, j, ans, land);
                    res.add(ans);
                }
            }
        }
        int[][] result = new int[res.size()][4];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;

    }
}
