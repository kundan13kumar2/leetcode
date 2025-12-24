package daily;

import java.util.*;

public class RussianEnvelop {

    public static void main(String[] args) {
        int[][] arr ={{2,3},{4,6},{3,7},{4,8}};
        RussianEnvelop russianEnvelop = new RussianEnvelop();
        System.out.println(russianEnvelop.maxEnvelopes(arr));
    }

    public int maxEnvelopes(int[][] envelopes) {
        int counter =1;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                else return o1[0] - o2[0];
            }
        });

        int[] list = new int[envelopes.length];
        Arrays.fill(list,1);
        for (int i =1;i<envelopes.length;i++){
            for (int j = 0 ; j<i;j++){
                if (envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    list[i]=Math.max(list[i],list[j]+1);
                    counter = Math.max(counter,list[i]);
                }
            }
        }

        return counter;

    }
}
