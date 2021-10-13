package topcoder.graphTheory;

import java.util.*;

public class Travel {
    double best = -1;

    int n;
    boolean[] visited;
    double[][] d;

    double dist(double x1, double y1, double z1, double x2, double y2, double z2) {
        double d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2);
        d = Math.sqrt(d) / 2;
        double t = Math.asin(d) * 2;
        return t;
    }

    void visit(int k, int from, double sum) {
        if (k == n - 1) {
            sum += d[from][0];
            if (sum < best || best < 0)
                best = sum;
            return;
        }

        for (int i = 1; i < n; ++i)
            if (!visited[i]) {
                visited[i] = true;
                visit(k + 1, i, sum + d[from][i]);
                visited[i] = false;
            }
    }

    static double pi = 3.1416;

    public int shortest(String[] s, int radius) {
        n = s.length;
        double[] x = new double[10];
        double[] y = new double[10];
        double[] z = new double[10];

        for (int i = 0; i < s.length; ++i) {
            int[] m = new int[10];
            StringTokenizer st = new StringTokenizer(s[i], " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                String t = st.nextToken();
                int k = Integer.parseInt(t);
                m[j++] = k;
            }

            double lat, lon;

            lat = m[0] * pi / 180;
            lon = m[1] * pi / 180;

            x[i] = Math.cos(lon) * Math.cos(lat);
            y[i] = Math.cos(lat) * Math.sin(lon);
            z[i] = Math.sin(lat);
            System.out.println(x[i] + " " + y[i] + " " + z[i]);
        }

        d = new double[n][n];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                d[i][j] = radius * dist(x[i], y[i], z[i], x[j], y[j], z[j]);
                System.out.println(d[i][j]);
            }

        visited = new boolean[n];
        visit(0, 0, 0);
        return (int) (Math.round(best + 0.0001));
    }

    public static void main(String[] args) {
        
    }
}

