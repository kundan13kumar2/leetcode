package daily;

import java.math.BigInteger;
import java.util.*;

public class ReplaceNonCoprime {
    public static void main(String[] args) {
        ReplaceNonCoprime obj=new ReplaceNonCoprime();
        //System.out.println(BigInteger.valueOf(20677).gcd(BigInteger.valueOf(899)).intValue());
        //System.out.println(lcm(20677,899));
        System.out.println(obj.replaceNonCoprimes(new int[]{287,41,49,287,899,23,23,20677,5,825}));
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int val = st.pop();
            if(isNonCoprime(val, nums[i])) {
                int lcmVal = lcm(val, nums[i]);
                while (!st.isEmpty()) {
                    int topVal = st.pop();
                    if (isNonCoprime(lcmVal, topVal)) {
                        lcmVal = lcm(lcmVal, topVal);
                    }else{
                        st.push(topVal);
                        break;
                    }
                }
                st.push(lcmVal);
            } else {
                st.push(val);
                st.push(nums[i]);
            }
            System.out.println(st);
        }

        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        return ans;
    }

    public boolean isNonCoprime (int x, int y) {
        return BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue()>1;
    }

    static int lcm(int x, int y) {
        return (x / BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue()) * y;
    }
}
