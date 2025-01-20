package daily;

public class EqualABRectangles {

    public static int countEqualABRectangles(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Initialize prefix sum arrays
        int[][] countA = new int[n + 1][m + 1];
        int[][] countB = new int[n + 1][m + 1];

        // Fill prefix sum arrays
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                countA[i][j] = countA[i-1][j] + countA[i][j-1] - countA[i-1][j-1] + (board[i-1][j-1] == 'A' ? 1 : 0);
                countB[i][j] = countB[i-1][j] + countB[i][j-1] - countB[i-1][j-1] + (board[i-1][j-1] == 'B' ? 1 : 0);
            }
        }

        // Count rectangles with equal number of A and B
        int equalABRectangles = 0;

        // Iterate over all pairs of top-left and bottom-right corners
        for (int i1 = 1; i1 <= n; i1++) {
            for (int j1 = 1; j1 <= m; j1++) {
                for (int i2 = i1; i2 <= n; i2++) {
                    for (int j2 = j1; j2 <= m; j2++) {
                        // Calculate number of A's and B's in this rectangle
                        int numA = (countA[i2][j2] - countA[i1-1][j2] - countA[i2][j1-1] + countA[i1-1][j1-1]);
                        int numB = (countB[i2][j2] - countB[i1-1][j2] - countB[i2][j1-1] + countB[i1-1][j1-1]);

                        // Check if they are equal
                        if (numA == numB) {
                            equalABRectangles++;
                        }
                    }
                }
            }
        }

        return equalABRectangles;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', '.'},
                {'B', '.', '.'},
                {'.', '.', 'A'}
        };

        int result = countEqualABRectangles(board);
        System.out.println("Number of rectangles with equal number of 'A's and 'B's: " + result);
    }
}
