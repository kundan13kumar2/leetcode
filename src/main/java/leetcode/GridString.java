package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class GridString {

    class Quad {
        int i, j, x, y;

        public Quad(int i, int j, int x, int y) {
            this.i = i;
            this.j = j;
            this.x = x;
            this.y = y;
        }
    }

    boolean isValid(int i, int j, int r, int c, boolean[][] visited) {
        if (i < 0 || i >= r || j < 0 || j >= c || visited[i][j])
            return false;
        return true;

    }

    public boolean checkAvailability(char[][] grid, String word) {

        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        char ch = word.charAt(0);
        Queue<Quad> q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == ch && !visited[i][j]) {
                    q.add(new Quad(i, j, Integer.MAX_VALUE, Integer.MAX_VALUE));
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        int size = q.size();
        char ch2 = word.charAt(1);

        while (size > 0) {
            Quad qd = q.poll();
            int i = qd.i;
            int j = qd.j;
            for (int p = 0; p < 8; p++) {
                int nextI = i + dx[p];
                int nextJ = j + dy[p];
                if (isValid(nextI, nextJ, r, c, visited) && grid[nextI][nextJ] == ch2) {
                    q.add(new Quad(nextI, nextJ, dx[p], dy[p]));
                    visited[nextI][nextJ] = true;
                }
            }
            size--;
        }

        int p = 2;
        while (!q.isEmpty() && p < word.length()) {
            Quad qd = q.poll();
            int nextI = qd.i + qd.x;
            int nextJ = qd.j + qd.y;
            if (isValid(nextI, nextJ, r, c, visited) && grid[nextI][nextJ] == word.charAt(p)) {
                q.add(new Quad(nextI, nextJ, qd.x, qd.y));
                visited[nextI][nextJ] = true;
                if (p == word.length() - 1) return true;
                p++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] grid = {{'F', 'A', 'C', 'I', 'X'},
                {'O', 'B', 'Q', 'P', 'X'},
                {'A', 'N', 'O', 'B', 'X'},
                {'M', 'A', 'S', 'S', 'X'}};

        String word = "FOAM";
        GridString string = new GridString();
        System.out.println(string.checkAvailability(grid, word));
    }
}
