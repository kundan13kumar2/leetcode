package leetcode;

import java.util.PriorityQueue;

public class RainWaterII {

    class Node implements Comparable<Node> {
        int x, y, h;
        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override
        public int compareTo(Node node) {
            return this.h - node.h;
        }

    }


    public int trapRainWater(int[][] heightMap) {

        int r = heightMap.length;
        int c = heightMap[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            pq.add(new Node(i, 0, heightMap[i][0]));
            pq.add(new Node(i, c - 1, heightMap[i][c - 1]));
            visited[i][0] = true;
            visited[i][c - 1] = true;
        }

        for (int j = 1; j < c - 1; j++) {
            pq.add(new Node(0, j, heightMap[0][j]));
            pq.add(new Node(r - 1, j, heightMap[r - 1][j]));
            visited[0][j] = true;
            visited[r - 1][j] = true;
        }

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        int res = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            Node removed = pq.remove();
            for (int i = 0; i < 4; i++) {
                int newX = removed.x + dir[i][0];
                int newY = removed.y + dir[i][1];
                if (isValid(newX, newY, visited, r, c)) {
                    int diff = Math.max(0, removed.h - heightMap[newX][newY]);
                    res = Math.max(res, diff);
                    ans += diff;
                    pq.add(new Node(newX, newY, Math.max(removed.h, heightMap[newX][newY])));
                    visited[newX][newY] = true;
                }
            }
        }

        System.out.println("Res : " + res);

        return ans;
    }

    public boolean isValid(int newX, int newY, boolean[][] visited, int R, int C) {
        return !(newX < 0 || newX >= R || newY < 0 || newY >= C || visited[newX][newY]);
    }

    public static void main(String[] args) {
        int[][] heightMap = {{5, 5, 5, 5, 5}, {5, 2, 3, 3, 5}, {5, 3, 3, 1, 5}, {4, 5, 5, 5, 5}};

        System.out.println(new RainWaterII().trapRainWater(heightMap));
    }
}
