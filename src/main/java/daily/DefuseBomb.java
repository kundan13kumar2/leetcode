package daily;

import java.util.Arrays;

public class DefuseBomb {
    public static void main(String[] args) {

        DefuseBomb defuseBomb = new DefuseBomb();
        int[] code = {2,4,9,3};
        int k=-2;
        System.out.println(Arrays.toString(defuseBomb.decrypt(code, k)));
    }

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];

        if(k==0) {
            Arrays.fill(result,0);
            return result;
        }

        if (k>0) {

            for (int i = 0; i < code.length; i++) {

                int j=i+1;
                int sum = 0;
                int t= j+k;
                for (; j <t; j++) {
                    sum+=code[j%(code.length)];
                }
                result[i] = sum;
            }

        }else {
            for (int i =code.length-1;i>=0;i--) {
                int j =i-1;
                int sum = 0;
                int t= j+k;
                for (; j >t; j--) {
                    sum+=code[(code.length+j)%(code.length)];
                }
                result[i] = sum;
            }

        }

        return result;
    }
}
