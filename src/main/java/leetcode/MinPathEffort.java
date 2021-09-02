package leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinPathEffort {
    boolean[][] visited;

    class Node {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int[] X = {0, 0, -1, 1};
    int[] Y = {1, -1, 0, 0};

    public int recur(int i, int j, int prevVal, int[][] heights, int r, int c) {
        int currVal = heights[i][j];
        if (i == r - 1 && j == c - 1) {
            max = Math.max(max, Math.abs(prevVal - currVal));
            return Math.max(min, max);
        }

        visited[i][j] = true;
        max = Math.max(max, Math.abs(currVal - prevVal));
        for (int k = 0; k < 4; k++) {
            int nextX = i + X[k];
            int nextY = j + Y[k];
            if (nextX >= r || nextX < 0 || nextY >= c || nextY < 0 || visited[nextX][nextY])
                continue;
            return recur(nextX, nextY, currVal, heights, r, c);

        }

        visited[i][j] = false;
        return Math.max(min, max);
    }

    public int recurUtil(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        visited = new boolean[r][c];

        min = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    min = Math.max(min, recur(i, j, 0, heights, r, c));
                }
            }
        }
        return min;

    }


    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        visited = new boolean[heights.length][heights[0].length];
        int min = Integer.MAX_VALUE;


        Queue<Node> q = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        q.add(new Node(0, 0, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int prevVal = node.val;
            visited[x][y] = true;
            if (x == r - 1 && y == c - 1)
                return prevVal;

            for (int i = 0; i < 4; i++) {
                int nextX = x + X[i];
                int nextY = y + Y[i];
                if (nextX >= r || nextX < 0 || nextY >= c || nextY < 0 || visited[nextX][nextY])
                    continue;

                int d = Math.max(prevVal, Math.abs(heights[x][y] - heights[nextX][nextY]));
                q.add(new Node(nextX, nextY, d));
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 2}, {3, 8, 3}, {5, 2, 5}};
        MinPathEffort effort = new MinPathEffort();
        System.out.println(effort.minimumEffortPath(arr));
    }
}
