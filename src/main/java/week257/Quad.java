package week257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Quad {

    public int countQuadruplets(int[] nums1) {
        int[] nums = new int[]{28, 8, 49, 85, 37, 90, 20, 8};
        Arrays.sort(nums);
        if (nums.length < 4 || (nums[0] + nums[1] + nums[2]) > nums[nums.length - 1])
            return 0;

        int ans = 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> contain = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (list.contains(nums[i] + nums[j] + nums[k]) && !contain.contains(nums[i]) &&
                            !contain.contains(nums[j]) && !contain.contains(nums[k])) {
                        ans += Collections.frequency(list, nums[i] + nums[j] + nums[k]);
                        contain.add(nums[i]);
                        contain.add(nums[j]);
                        contain.add(nums[k]);
                    }
                }
            }
        }

       // System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        Quad q = new Quad();
        q.countQuadruplets(new int[3]);
    }
}
