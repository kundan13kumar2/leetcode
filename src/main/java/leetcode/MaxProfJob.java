package leetcode;

import java.util.*;

public class MaxProfJob {

    static class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<Job> jobList = new ArrayList<>();
        int n = profit.length;
        for (int i = 0; i < n; i++)
            jobList.add(new Job(startTime[i], endTime[i], profit[i]));

        jobList.sort((a, b) -> (a.start - b.start));
        TreeMap<Integer, Integer> profitMap = new TreeMap<>();

        int ans = 0;

        for (Job job : jobList) {
            Integer tillKey = profitMap.floorKey(job.start);
            int initialProfit = tillKey == null ? 0 : profitMap.get(tillKey);
            ans = Math.max(ans, initialProfit + job.profit);
            profitMap.put(job.end, ans);
        }
        return ans;

    }


    public static void main(String[] args) {

        MaxProfJob pr = new MaxProfJob();

        int[] start = {1, 2, 3, 3};
        int[] end = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println(pr.jobScheduling(start, end, profit));
    }
}
