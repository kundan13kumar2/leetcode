package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class Micro {

    public int solution(int N, int k) {

        String str = String.valueOf(N);
        StringBuilder sb = new StringBuilder();
        for (Character ch : str.toCharArray()) {
            int t = Integer.parseInt(String.valueOf(ch));
            if (k > 0 && t != 9) {
                int temp = 9 - t;
                if (k > temp)
                    sb.append(t + temp);
                else sb.append(t + k);
                k -= temp;
            } else sb.append(ch);
        }

        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args) {
        Micro micro = new Micro();
        System.out.println(micro.solution(512, 20));
    }
}
