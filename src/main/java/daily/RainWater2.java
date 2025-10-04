package daily;


import java.util.PriorityQueue;

public class RainWater2 {
    public static void main(String[] args) {

        int[][] heightMap = {
                {3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3},
                {3, 2, 1, 2, 3},
                {3, 2, 2, 2, 3},
                {3, 3, 3, 3, 3},
        };

        RainWater2 obj = new RainWater2();
        System.out.println(obj.trapRainWater(heightMap));
    }

    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public record Coordinates(int x, int y) {
    }

    public record Pair(int val, Coordinates point) {
    }

    public int trapRainWater(int[][] heightMap) {
        int water = 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < col; i++) {
            queue.add(new Pair(heightMap[0][i], new Coordinates(0, i)));
            queue.add(new Pair(heightMap[row - 1][i], new Coordinates(row - 1, i)));
            visited[0][i] = true;
            visited[row - 1][i] = true;
        }

        for (int i = 1; i < row - 1; i++) {
            queue.add(new Pair(heightMap[i][0], new Coordinates(i, 0)));
            queue.add(new Pair(heightMap[i][col - 1], new Coordinates(i, col - 1)));
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int val = pair.val;
            int x = pair.point.x;
            int y = pair.point.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + moves[i][0];
                int newY = y + moves[i][1];

                if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY]) {
                    water += Math.max(val - heightMap[newX][newY], 0);
                    visited[newX][newY] = true;
                    queue.add(new Pair(Math.max(val, heightMap[newX][newY]), new Coordinates(newX, newY)));
                }
            }
        }

        return water;


    }
}
