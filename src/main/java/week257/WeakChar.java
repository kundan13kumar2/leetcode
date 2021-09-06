package week257;

import java.util.Arrays;
import java.util.Comparator;

public class WeakChar {
    public int numberOfWeakCharacters(int[][] properties) {

        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });

        int ans = 0;
        int max = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i][1] < max)
                ans++;
            max = Math.max(max, properties[i][1]);
        }
        return ans;

    }

    public static void main(String[] args) {

        WeakChar w = new WeakChar();
        int[][] proper = {{1, 2}, {1, 5}, {4, 3}, {4, 7}, {5, 8}, {10, 4}};
        System.out.println(w.numberOfWeakCharacters(proper));
    }
}
