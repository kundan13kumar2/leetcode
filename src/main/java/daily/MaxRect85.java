package daily;

import java.util.Stack;

public class MaxRect85 {

    public static void main(String[] args) {
        MaxRect85 maxRect85 = new MaxRect85();
        /*char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };*/

        char[][] matrix = new char[][]
                {{'1','1'}};

        System.out.println(maxRect85.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int max =0;
        int r= matrix.length;
        int c= matrix[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < c; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        Stack<Integer> idxStack = new Stack<>();
        int[] leftArr = new int[c];
        int[] rightArr = new int[c];


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                while (!idxStack.empty() && dp[i][idxStack.peek()] >= dp[i][j]) {
                    idxStack.pop();
                }
                if (idxStack.empty()) {
                    leftArr[j] = 0;
                } else {
                    leftArr[j] = idxStack.peek() + 1;
                }
                idxStack.push(j);
            }
            while (!idxStack.empty()) {
                idxStack.pop();
            }

            for (int j = c-1; j >= 0; j--) {
                while (!idxStack.empty() && dp[i][idxStack.peek()] >= dp[i][j]) {
                    idxStack.pop();
                }
                if (idxStack.empty()) {
                    rightArr[j] = c-1;
                } else {
                    rightArr[j] = idxStack.peek() - 1;
                }
                idxStack.push(j);
            }
            while (!idxStack.empty()) {
                idxStack.pop();
            }
            for (int k = 0; k < c; k++) {
                max = Math.max(max, (rightArr[k] - leftArr[k] + 1) * dp[i][k]);
            }
        }

        return max;
    }
}
