package leetcode;

public class WordSearch {
    public boolean isPresent(char[][] grid, String word, int r, int c, int x, int y, int idx) {

        if (idx == word.length()) return true;
        if (x < 0 || x >= r || y < 0 || y >= c || grid[x][y] != word.charAt(idx)) return false;
        char temp = grid[x][y];
        grid[x][y] = ' ';
        boolean res = isPresent(grid, word, r, c, x + 1, y, idx + 1)
                || isPresent(grid, word, r, c, x, y + 1, idx + 1)
                || isPresent(grid, word, r, c, x - 1, y, idx + 1)
                || isPresent(grid, word, r, c, x, y - 1, idx + 1);
        grid[x][y] = temp;
        return res;
    }

    public boolean exist(char[][] grid, String word) {
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == word.charAt(0))
                    if (isPresent(grid, word, r, c, i, j, 0))
                        return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {{'a'}};
        String word = "a";

        System.out.println(new WordSearch().exist(grid, word));
    }

}
