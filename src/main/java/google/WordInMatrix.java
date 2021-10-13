package google;

public class WordInMatrix {

    boolean[][] visited;

    public boolean isValid(int x, int y, int m, int n) {
        return !(x < 0 || y < 0 || x >= m || y >= n);
    }

    public boolean backtrack(int i, int[] word, int[][] grid, int m, int n, int x, int y) {

        if (i == word.length) return true;

        if (!isValid(x, y, m, n)) return false;

        if (grid[x][y] == word[i]) {

            boolean res = backtrack(i + 1, word, grid, m, n, x, y + 1) || backtrack(i + 1, word, grid, m, n, x, y - 1)
                    || backtrack(i + 1, word, grid, m, n, x + 1, y) || backtrack(i + 1, word, grid, m, n, x - 1, y);
          //  visited[x][y] = false;
            return res;

        } else
            return false;
    }


    public boolean isPresent(int[][] grid, int[] word) {

        int m = grid.length;
        int n = grid[0].length;

      //  visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == word[0]) {
                    if (backtrack(0, word, grid, m, n, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int grid[][] = {{1, 2, 3, 5, 8},
                {6, 5, 10, 22, 47},
                {20, 21, 1, 54, 33},
                {45, 8, 6, 5, 10}};

        // Function to check if word exists or not
        if (new WordInMatrix().isPresent(grid, new int[]{22}))
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}
