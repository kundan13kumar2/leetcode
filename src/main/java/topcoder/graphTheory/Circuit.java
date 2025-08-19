package topcoder.graphTheory;

import java.util.Arrays;
import java.util.stream.Stream;

public class Circuit {

    public int howLong(String[] connects, String[] costs) {

        int n = connects.length;
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(mat[i], Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            if (connects[i].isEmpty()) continue;
            int[] nodes = Stream.of(connects[i].split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] cost = Stream.of(costs[i].split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < nodes.length; j++)
                mat[i][nodes[j]] = cost[j];
        }

        //Floyd-Warshall algorithm
        int maxVal = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (mat[i][k] != Integer.MIN_VALUE) { //little optimization
                    for (int j = 0; j < n; j++) {
                        if (mat[k][j] != Integer.MIN_VALUE) {//little optimization
                            mat[i][j] = Math.max(mat[i][j], mat[i][k] + mat[k][j]);
                            maxVal = Math.max(maxVal, mat[i][j]);
                        }
                    }
                }
            }
        }
        return maxVal;
    }


    public static void main(String[] args) {
        String[] connects = {"", "2 3", "3 4 5", "4 6", "5 6", "7", "5 7", ""};
        String[] costs = {"", "30 50", "19 6 40", "12 10", "35 23", "8", "11 20", ""};

        Circuit circuit = new Circuit();
        System.out.println(circuit.howLong(connects, costs));
    }
}
