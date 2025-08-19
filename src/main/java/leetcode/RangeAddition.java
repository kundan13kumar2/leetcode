package leetcode;

public class RangeAddition {

    public int maxCount(int m, int n, int[][] ops) {

        int minX = m;
        int minY = n;
        for (int i = 0; i < ops.length; i++) {
            minX = Math.min(minX, ops[i][0]);
            minY = Math.min(minY, ops[i][1]);
        }

        return Math.min(minX * minY, m * n);
    }

    public static void main(String[] args) {
        // int[][] ops = {{16,1},{14,3},{14,2},{4,1},{10,1},{11,1},{8,3},{16,2},{13,1},{8,3},{2,2},{9,1},{3,1},{2,2},{6,3}};

        RangeAddition rd = new RangeAddition();
        System.out.println(rd.maxCount(3, 3, new int[0][0]));

    }
}
