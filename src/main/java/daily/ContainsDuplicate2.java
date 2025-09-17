package daily;

import java.util.HashSet;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,1,10};
        ContainsDuplicate2 obj = new ContainsDuplicate2();
        System.out.println(obj.containsNearbyDuplicate(nums, 15));

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;

            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i-k]);
        }
        return false;
    }
}
