package topcoder.graphTheory;


import java.util.PriorityQueue;

public class LakeDepth {
    int depth(String[] plot) {

        int r = plot.length;
        int c = plot[0].length();
        int[][] heightMap = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                heightMap[i][j] = plot[i].charAt(j);
            }
        }

        return trapRainWater(heightMap);

    }

    public int trapRainWater(int[][] heightMap) {

        int r = heightMap.length;
        int c = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            pq.add(new int[]{i, 0, heightMap[i][0]});
            pq.add(new int[]{i, c - 1, heightMap[i][c - 1]});
            visited[i][0] = true;
            visited[i][c - 1] = true;
        }

        for (int j = 1; j < c - 1; j++) {
            pq.add(new int[]{0, j, heightMap[0][j]});
            pq.add(new int[]{r - 1, j, heightMap[r - 1][j]});
            visited[0][j] = true;
            visited[r - 1][j] = true;
        }

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // int ans = 0;
        int res = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int[] removed = pq.remove();
            for (int i = 0; i < 4; i++) {
                int newX = removed[0] + dir[i][0];
                int newY = removed[1] + dir[i][1];
                if (isValid(newX, newY, visited, r, c)) {
                    int diff = Math.max(0, removed[2] - heightMap[newX][newY]);
                    res = Math.max(res, diff);
                    // ans += diff;
                    pq.add(new int[]{newX, newY, Math.max(removed[2], heightMap[newX][newY])});
                    visited[newX][newY] = true;
                }
            }
        }


        return res;
    }

    public boolean isValid(int newX, int newY, boolean[][] visited, int R, int C) {
        return !(newX < 0 || newX >= R || newY < 0 || newY >= C || visited[newX][newY]);
    }

    public static void main(String[] args) {
        String[] plot = {"asdkl;jhbgdsapo834ytwproiuenbvdflkuhg3908hbhg;sdlk", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "4p9uihbnrtews;o84yht43q;puitbe;piughbv4we3['tih3e4", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe498hgerp9ihge34w[o8hs[-0te34woighvnera;oibge4w3;", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", "pe3hgte34wohgte349ht23wujt-ujt3wsugtehngvero;n bvf", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", ";oijhbt32p49uhtgerlkjngvsa;dlkj398yr32poiuthger;lj", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", " tgp4398 4oiu3h t4398 yt3498y 43oih tpi4h t4p83y t", "fr4iojng 43598th43iu ht43qp98 yt4398y t34q htpoeh4"};
        System.out.println(new LakeDepth().depth(plot));

    }

}
