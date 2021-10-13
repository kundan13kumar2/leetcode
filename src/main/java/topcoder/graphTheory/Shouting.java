package topcoder.graphTheory;

public class Shouting {

    double shout(int[] x, int[] y) {
        int n = x.length;
        double[][] adj = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
            }
        }

        //Floyd-warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    adj[i][j] = Math.min(adj[i][j], Math.max(adj[i][k], adj[k][j]));
            }
        }

        double max = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                max = Math.max(max, adj[i][j]);
        }

        return Math.sqrt(max);
    }

    public static void main(String[] args) {

        int[] x = {10000, 10000, 10000, 10000, 10000, 10000, 10000, 9998, 9990, 9990, 9995, 9992, 9990, 9990, 9989, 9984, 9999, 9981, 9984, 9995, 9988, 9999, 9995, 9973, 9975, 9982, 9985, 9993, 9999, 9980, 9989, 9962, 9966, 9985, 9964, 9958, 9972, 9965, 9993, 9987, 10000, 9967, 9959, 9966, 9971, 9996, 9955, 9988, 9982, -10000};
        int[] y = {10000, 9991, 9983, 9972, 9972, 9998, 9987, 10000, 9994, 9980, 9971, 9970, 9989, 9965, 10000, 9998, 9991, 9973, 9992, 9995, 9985, 10000, 9991, 9987, 9996, 9986, 9950, 9983, 10000, 9994, 9986, 9975, 9970, 9982, 9997, 10000, 9991, 9997, 9972, 9968, 9965, 9988, 10000, 9992, 9994, 9999, 9973, 9970, 9952, -10000};
        System.out.println(new Shouting().shout(x, y));

    }
}
