package daily;

import java.util.Arrays;

public class NQueen {
    static class Index {
        int row;
        int col;

        Index(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }

    public static void main(String[] args) {
        Index[] idxArr = new Index[4];
        NQueen nQueen = new NQueen();
        if (nQueen.recur(0, idxArr)) {
            System.out.println(Arrays.toString(idxArr));
        }
    }

    public boolean recur(int row, Index[] idx) {
        if (row == 4) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            boolean foundSafe = true;
            for (int j = 0; j < row; j++) {
                if (idx[j].col == i || (idx[j].row - idx[j].col == row - i) || (idx[j].row + idx[j].col == row + i)) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                idx[row] = new Index(row, i);
                if (recur(row + 1, idx)) {
                    return true;
                }
            }
        }
        return false;
    }

}
