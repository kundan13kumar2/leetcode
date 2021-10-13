package google;

import java.util.*;

public class ArticulationPoint {

    int t = 0;
    boolean[] visited;
    boolean[] AP;
    int[] discovery;
    int[] low;
    int[] parent;


    public void dfs(int u, Map<Integer, List<Integer>> graph) {

        low[u] = discovery[u] = ++t;
        int count = 0;
        visited[u] = true;
        List<Integer> nbr = graph.get(u);
        for (int v : nbr) {
            if (parent[u] == v) {
                continue;
            } else if (visited[v]) {
                low[u] = Math.min(low[u], discovery[v]);
            } else {
                parent[v] = u;
                count++;
                dfs(v, graph);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1) {
                    if (count >= 2) {
                        AP[u] = true;
                    }
                } else if (low[v] > discovery[u]) {
                    System.out.println(u + " " + v);
                    AP[u] = true;
                }
            }
        }

    }


    public void findArticulationPoint(Map<Integer, List<Integer>> graph) {
        int n = 9;
        visited = new boolean[n];
        AP = new boolean[n];
        discovery = new int[n];
        low = new int[n];
        parent = new int[n];
        parent[0] = -1;
        parent[1] = -1;

        dfs(1, graph);


        System.out.println(Arrays.toString(AP));
        System.out.println(Arrays.toString(visited));

    }

    List<List<Integer>> ans = new ArrayList<>();

    public void dfs1(int u, List<List<Integer>> graph) {
        discovery[u] = low[u] = ++t;
        visited[u] = true;

        List<Integer> nbr = graph.get(u);
        for (int v : nbr) {
            if (parent[u] == v) continue;

            else if (visited[v]) low[u] = Math.min(low[u], discovery[v]);
            else {
                parent[v] = u;
                dfs1(v, graph);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > discovery[u])
                    ans.add(Arrays.asList(u, v));
            }
        }

    }


    public void findArticulationPoint1(List<List<Integer>> graph) {
        int n = graph.size();
        visited = new boolean[n];
        AP = new boolean[n];
        discovery = new int[n];
        low = new int[n];
        parent = new int[n];
        parent[0] = -1;


        dfs1(0, graph);


        System.out.println(ans);
        System.out.println(Arrays.toString(visited));

    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 8));
        graph.put(2, Arrays.asList(1, 4, 5));
        graph.put(5, Arrays.asList(2, 8));
        graph.put(4, Arrays.asList(2, 3));
        graph.put(3, Arrays.asList(4, 6, 7));
        graph.put(6, Arrays.asList(3, 7));
        graph.put(7, Arrays.asList(3, 6));
        graph.put(8, Arrays.asList(1, 5));
        //  new ArticulationPoint().findArticulationPoint(graph);


        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(0, 2, 3));
        connections.add(Arrays.asList(1, 0));
        connections.add(Arrays.asList(1));

        new ArticulationPoint().findArticulationPoint1(connections);


    }
}
