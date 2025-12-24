package daily;


public class CountRangeSum {
    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        CountRangeSum crs = new CountRangeSum();
        int result = crs.countRangeSum(nums, lower, upper);
        System.out.println(result); // Output: 3
    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return mergeSortAndCount(prefixSum, 0, prefixSum.length - 1, lower, upper);
    }

    private int mergeSortAndCount(long[] prefixSum, int left, int right, int lower, int upper) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSortAndCount(prefixSum, left, mid, lower, upper) +
                mergeSortAndCount(prefixSum, mid + 1, right, lower, upper);


        int i = left, j1 = mid + 1, j2 = mid + 1;


        while (i <= mid) {

            while (j1 <= right && prefixSum[j1] - prefixSum[i] < lower)
                j1++;


            while (j2 <= right && prefixSum[j2] - prefixSum[i] <= upper)
                j2++;

            count += (j2 - j1);
            i++;
        }

        merge(prefixSum, left, mid, right);
        return count;
    }

    private void merge(long[] prefixSum, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (prefixSum[i] <= prefixSum[j]) {
                temp[k++] = prefixSum[i++];
            } else {
                temp[k++] = prefixSum[j++];
            }
        }

        while (i <= mid) temp[k++] = prefixSum[i++];
        while (j <= right) temp[k++] = prefixSum[j++];

        System.arraycopy(temp, 0, prefixSum, left, temp.length);
    }

}
