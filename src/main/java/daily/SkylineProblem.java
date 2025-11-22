package daily;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {
    public static void main(String[] args) {

    }

    public List<int[]> getSkyline(int[][] buildings) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] b : buildings) {
            pq.add(new int[]{b[0], -b[2]});
            pq.add(new int[]{b[1], b[2]});
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(0);
        List<int[]> result = new ArrayList<>();
        int currMax = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] < 0) {
                maxHeap.add(-curr[1]);
                if (currMax< -curr[1]) {
                    currMax = -curr[1];
                    result.add(new int[]{curr[0], currMax});
                }
                maxHeap.add(-curr[1]);
            } else {
                maxHeap.remove(curr[1]);
                int maxVal = maxHeap.isEmpty()?0:maxHeap.peek();
                if (maxVal!=currMax) {
                    result.add(new int[]{curr[0], currMax});
                }
                currMax= Math.max(currMax, maxVal);
            }

        }
        return result;
    }
}
