package daily;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        System.out.println(Arrays.toString(slidingWindowMax.maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dQueue = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!dQueue.isEmpty() && nums[dQueue.peekLast()] < nums[i]) {
                dQueue.pollLast();
            }
            while (!dQueue.isEmpty() && dQueue.peekFirst() <= i - k) {
                dQueue.pollFirst();
            }
            dQueue.offerLast(i);
            if (i >= k - 1 && !dQueue.isEmpty()) {
                res[j++] = nums[dQueue.peekFirst()];
            }
        }
        return res;
    }
}
