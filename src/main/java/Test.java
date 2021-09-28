import java.util.*;

public class Test {
    public static int sumOfBeauties(int[] nums) {

        int c2 = 0;
        int c1 = 0;
        int c0 = 0;
        int[] maxA = new int[nums.length - 2];
        int[] minA = new int[nums.length - 2];
        boolean f1 = true;
        boolean f2 = true;
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            if (max > nums[i])
                maxA[i - 1] = max;
            else {
                f1 = false;
                maxA[i - 1] = -1;
            }

            max = Math.max(max, nums[i]);
        }

        int min = nums[0];
        for (int i = 1; i <= nums.length - 2; i++) {
            if (min < nums[i])
                minA[i - 1] = min;
            else {
                f2 = false;
                minA[i - 1] = Integer.MAX_VALUE;
            }
            min = Math.min(min, nums[i]);
        }

        System.out.println(Arrays.toString(maxA));

        boolean flag = false;
        for (int i = nums.length - 2; i >= 1; i--) {
            if (maxA[i - 1] > nums[i] && minA[i - 1] < nums[i] && f1 && f2)
                c2++;
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                c1++;
                flag = true;
            } else {
                c0++;
                flag = true;
            }
        }
        if (c2 == nums.length - 2)
            return 2 * c2;
        if (flag) {
            return c2 + c1;
        } else
            return 0;


    }

    public static void main(String[] args) {

        System.out.println(sumOfBeauties(new int[]{9, 9, 3, 8, 7, 9, 6, 10}));

    }
}
