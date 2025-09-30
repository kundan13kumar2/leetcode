package daily;

public class TriangleSum {
    public static void main(String[] args){
        int[] nums = {5};
        int n = nums.length;
        while (n>0){
            for (int i =0; i<n-1;i++){
                nums[i]= (nums[i]+nums[i+1])%10;
            }
            n--;
        }
        System.out.println(nums[0]);
    }

}
