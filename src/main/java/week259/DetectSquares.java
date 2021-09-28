package week259;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Map<String, Integer> freqMap;
    List<Pair> pairList;

    public DetectSquares() {
        freqMap = new HashMap<>();
        pairList = new ArrayList<>();
    }

    public void add(int[] point) {
        String str = point[0] + "," + point[1];
        int f = freqMap.getOrDefault(str, 0);
        pairList.add(new Pair(point[0], point[1]));

        freqMap.put(str, f + 1);

    }

    public int count(int[] point) {

         add(point);

        if (pairList.size() < 3) return 0;
        int res = 0;
        for (Pair p : pairList) {
            if ((Math.abs(p.x - point[0]) != Math.abs(p.y - point[1]) || p.x == point[0] || p.y == point[1]))
                continue;
            if (freqMap.containsKey(p.x + "," + point[1])
                    && freqMap.containsKey(point[0] + "," + p.y)) {
                res += freqMap.getOrDefault(p.x + "," + point[1], 0)
                        * freqMap.getOrDefault(point[0] + "," + p.y, 0);
            }
        }

        return res;

    }

    public static void main(String[] args) {

        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});

        System.out.println(detectSquares.count(new int[]{11, 10}));

        System.out.println(detectSquares.count(new int[]{14, 8}));

        detectSquares.add(new int[]{11, 2});

        System.out.println(detectSquares.count(new int[]{11, 10}));


    }
}
