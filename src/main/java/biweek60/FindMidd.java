package biweek60;

public class FindMidd {

    public int findMiddleIndex(int[] nums) {

        int[] lSum = new int[nums.length];
        int[] rSum = new int[nums.length];


        for (int i = 1; i < nums.length; i++) {
            lSum[i] = lSum[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rSum[i] = rSum[i + 1] + nums[i + 1];
        }

        for (int i=0;i<nums.length;i++){
            if (lSum[i]==rSum[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
