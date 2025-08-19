package leetcode;

import java.util.Arrays;

public class NextGreater3 {

    void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public int nextGreaterElement(int n) {
        char[] str = String.valueOf(n).toCharArray();
        int i = str.length - 1;

        for (; i > 0; i--) {
            if (str[i] > str[i - 1]) {
                break;
            }
        }
        if (i == 0) return -1;

        int x = str[i - 1], min = i;

        for (int j = i + 1; j < str.length; j++) {
            if (str[j] > x && str[j] < str[min]) {
                min = j;
            }
        }

        swap(str, i - 1, min);

        Arrays.sort(str, i, str.length);
        int ans = -1;
        try {
            ans = Integer.parseInt(String.valueOf(str));
        } catch (NumberFormatException e) {
            ans = -1;
        }
        return ans;


    }

    public static void main(String[] args) {
        NextGreater3 nxg = new NextGreater3();
/*
        12
        230241
        21
        218765
        534976
        2147483486
        1999999999*/
        System.out.println(nxg.nextGreaterElement(534976));
    }
}
