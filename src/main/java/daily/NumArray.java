package daily;

import java.util.Arrays;

public class NumArray {

    static int[] segmentTreeArray;
    static int n;

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        NumArray numArray = new NumArray(arr);
        numArray.buildSegmentTree(arr, 0, 0, arr.length - 1);

        System.out.println(Arrays.toString(segmentTreeArray));
        System.out.println(numArray.sumRange(0, 2));

        numArray.update(1,2);
        System.out.println(Arrays.toString(segmentTreeArray));

        System.out.println(numArray.sumRange(0,2));
    }


    public NumArray(int[] nums) {
        segmentTreeArray = new int[4 * nums.length];
        n = nums.length;
    }

    public void buildSegmentTree(int[] nums, int index, int left, int right) {
        if (left == right) {
            segmentTreeArray[index] = nums[left];
            return;
        }

        int mid = (right + left) / 2;

        buildSegmentTree(nums, 2 * index + 1, left, mid);

        buildSegmentTree(nums, 2 * index + 2, mid + 1, right);

        segmentTreeArray[index] = segmentTreeArray[2 * index + 1] + segmentTreeArray[2 * index + 2];
    }

    public int sumRange(int left, int right) {
        return getSumRecur(0, left, right, 0, n - 1);
    }

    public int getSumRecur(int index, int left, int right, int start, int end) {


        if (start > right || end < left)
            return 0;

        if (start >= left && end <= right)
            return segmentTreeArray[index];

        int mid = (start + end) / 2;

        return getSumRecur(2 * index + 1, left, right, start, mid)
                + getSumRecur(2 * index + 2, left, right, mid + 1, end);

    }

    public void update(int index, int val) {
        updateRecur(0, index, val, 0, n - 1);
    }

    public void updateRecur(int idx, int updIdx, int val, int left, int right) {
        if (left == right) {
            segmentTreeArray[idx] = val;
            return;
        }

        int mid = (left + right) / 2;

        if (mid >= updIdx) {
            updateRecur(2 * idx + 1, updIdx, val, left, mid);
        } else {
            updateRecur(2 * idx + 2, updIdx, val, mid + 1, right);
        }
        segmentTreeArray[idx] = segmentTreeArray[2 * idx + 1] + segmentTreeArray[2 * idx + 2];
    }
}
