package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!st.isEmpty()) {
                while (!st.isEmpty() && st.peek() <= nums[i])
                    st.pop();
                res[i] = st.isEmpty() ? -1 : st.peek();
                st.push(nums[i]);
            } else {
                res[i] = -1;
                st.push(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        NextGreaterElement2 nex2 = new NextGreaterElement2();
        System.out.println(Arrays.toString(nex2.nextGreaterElements(arr)));
    }

}
