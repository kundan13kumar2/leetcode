package daily;

public class MinRectangleBlackPixel {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
        };

        MinRectangleBlackPixel minRectangleBlackPixel = new MinRectangleBlackPixel();

        int a = minRectangleBlackPixel.topMostRow(1, matrix);
        int b = minRectangleBlackPixel.bottomMostRow(1, matrix);

        int c = minRectangleBlackPixel.leftMostColumn(2, matrix);
        int d = minRectangleBlackPixel.rightMostColumn(2, matrix);

        System.out.println((b - a + 1) * (d - c + 1));
    }

    public int topMostRow(int x, int[][] matrix) {

        int l = 0;
        int r = x;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (anyOneRow(matrix, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int bottomMostRow(int x, int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int l = x;
        int r = m - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (anyOneRow(matrix, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public int leftMostColumn(int y, int[][] matrix) {

        int l = 0;
        int r = y;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (anyOneColumn(matrix, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int rightMostColumn(int y, int[][] matrix) {
        int n = matrix[0].length;

        int l = y;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (anyOneColumn(matrix, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }


    public boolean anyOneRow(int[][] matrix, int r) {
        int n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[r][i] == 1) return true;
        }
        return false;
    }

    public boolean anyOneColumn(int[][] matrix, int c) {
        int m = matrix.length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][c] == 1) return true;
        }
        return false;
    }
}
