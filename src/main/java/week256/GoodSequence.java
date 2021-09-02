package week256;

import java.util.HashSet;
import java.util.Set;

public class GoodSequence {

    Set<String> set = new HashSet<>();

    public void recur(String str, String ans) {
        System.out.println(str.length());
        if (str.length() == 0) {
            set.add(ans);
            return;
        }
        recur(str.substring(1), ans + str.charAt(0));

        recur(str.substring(1), ans);

    }


    public int numberOfUniqueGoodSubsequences(String binary) {

//        recur(binary, "");
//        return set.size();


        int end1 = 0, end0 = 0;
        boolean flag = false;
        int mod = 1000000007;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                end1 = (end0 + end1 + 1) % mod;
            } else {
                flag = true;
                end0 = (end0 + end1) % mod;
            }
        }

        return (end0 + end1 + (flag ? 1 : 0)) % mod;
    }

    public static void main(String[] args) {
        GoodSequence gs = new GoodSequence();
        System.out.println(gs.numberOfUniqueGoodSubsequences("111001101100000001001110110101110001100"));

    }
}
