package daily;

import java.util.*;
import java.util.stream.Collectors;

//It will solve by recursion and DP . Not Greedy
public class MinCostPile {
    public static void main(String[] args) {
        MinCostPile mc = new MinCostPile();
        int[] arr = {6,4,4,2};
        int k = 2;
        System.out.println(mc.mergeStones(arr, k));
    }


    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if (n < k) return 0;
        return findSol(stones, k);
    }

    int minVal = Integer.MAX_VALUE;
    int minIndex = -1;
    int ans = 0;

    public int findSol(int[] arr, int k) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        while (list.size() >= k) {
            finMinValIndex(list, k);
            list = updateArray(list, k);
        }
        if (list.size() >1)  { return -1;}
        return ans;
    }

    List<Integer> updateArray(List<Integer> oList, int k) {
        List<Integer> uList = new ArrayList<>();
        if (minIndex == -1) return uList;
        for (int i = 0; i < minIndex; i++) {
            uList.add(oList.get(i));
        }
        uList.add(minVal);
        for (int i = minIndex + k; i < oList.size(); i++) {
            uList.add(oList.get(i));
        }
        ans += minVal;
        minVal = Integer.MAX_VALUE;
        minIndex = -1;

        return uList;
    }

    void finMinValIndex(List<Integer> list, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += list.get(i);
        }
        if (sum < minVal) {
            minVal = sum;
            minIndex = 0;
        }
        for (int i = 1; i <= list.size() - k; i++) {
            sum = (sum + list.get(i + k - 1) - list.get(i - 1));
            if (sum < minVal) {
                minVal = sum;
                minIndex = i;
            }
        }
    }


}
