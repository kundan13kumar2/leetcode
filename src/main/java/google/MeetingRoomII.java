package google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public int countRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        for (int i = 0; i < intervals.length; i++) {
            if (pq.isEmpty()) pq.add(intervals[i]);
            else {
                int[] topElements = pq.peek();
                if (topElements[1] <= intervals[i][0])
                    pq.remove();
                pq.add(intervals[i]);

            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] interval = {{0, 5}, {5, 10}, {15, 25}, {40, 60}, {50, 65}, {55, 75}, {75, 90}};

        System.out.println(new MeetingRoomII().countRooms(interval));

    }
}
