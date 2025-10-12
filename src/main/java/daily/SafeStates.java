package daily;

import java.util.*;

public class SafeStates {
    public static void main(String[] args) {
        SafeStates ss = new SafeStates();
        /*
        int[][] graph = {
                {1, 2, 3, 4},
                {1, 2},
                {3, 4},
                {0, 4},
                {}
        };
         */

        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> ans = ss.eventualSafeNodes(graph);
        System.out.println(ss.findSafeStates(graph));
        System.out.println(Arrays.toString(ans.toArray()));
    }

    boolean[] visited;
    boolean[] inRecursionVis;

    private boolean isSafe(int i, int[][] graph) {
        visited[i] = true;
        inRecursionVis[i] = true;
        for (int v : graph[i]) {
            if (!visited[v] && isSafe(v, graph)) {
                return true;
            } else if (inRecursionVis[v]) {
                return true;
            }
        }
        inRecursionVis[i] = false;
        return false;
    }


    public List<Integer> eventualSafeNodes(int[][] graph) {
        visited = new boolean[graph.length];
        inRecursionVis = new boolean[graph.length];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                isSafe(i, graph);
            }
        }
        for (int i = 0; i < inRecursionVis.length; i++) {
            if (!inRecursionVis[i]) {
                ans.add(i);
            }
        }
        return ans;
    }


    private List<Integer> findSafeStates(int[][] graph) {
        List<Integer> ans = new ArrayList<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int edge : graph[i]) {
                adj.get(edge).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {

            int v = q.poll();
            ans.add(v);

            for (int edge : adj.get(v)) {
                indegree[edge]--;
                if (indegree[edge] == 0) {
                    q.offer(edge);
                }
            }

        }

        Collections.sort(ans);

        return ans;
    }
}
