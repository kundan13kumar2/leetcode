package daily;

public class MaxAvgSub1 {
    public static void main(String[] args) {
        MaxAvgSub1 obj = new MaxAvgSub1();
        int[] arr = {5};
        int k =1;
        System.out.println(obj.findMaxAverage(arr, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        double max = Double.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum/k;

        int i=1;
        int j = i+k-1;

        while (j<nums.length){
            sum = sum-nums[i-1]+nums[j];
            double avg = sum/k;
            max = Math.max(avg,max);
            i++;j++;
        }
        return max;
    }
}
