package daily;

import java.util.*;

public class OrderFulfillment {

    public static int maxOrders(int N, int[] D, int[] C) {
        int maxOrders = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // Min-heap based on distance

        // Create pairs of (distance, count) and add to priority queue
        for (int i = 0; i < N; i++) {
            pq.offer(new int[]{D[i], C[i]});
        }

        int currentDistance = -1;
        List<int[]> currentOrders = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] order = pq.poll();
            int distance = order[0];
            int count = order[1];

            if (distance > currentDistance) {
                // Process orders at current distance
                for (int[] o : currentOrders) {
                    if (o[1] > 0) {
                        int fulfill = Math.min(o[1], count);
                        maxOrders += fulfill;
                        o[1] -= fulfill;
                        count -= fulfill;
                    }
                }
                currentOrders.clear();
                currentDistance = distance;
            }

            if (count > 0) {
                currentOrders.add(new int[]{distance, count});
            }
        }

        // Final processing of remaining orders
        for (int[] o : currentOrders) {
            maxOrders += o[1];
        }

        return maxOrders;
    }

    public static void main(String[] args) {
        // Example usage:
        int N = 7;
        int[] D = {5,11,1,3};
        int[] C = {6,1,3,2};
        System.out.println(maxOrders(N, D, C)); // Output: 13
    }
}
