package google;

import java.util.*;

public class BipartiteGraph {

    public boolean checkBipartiteness(Map<Integer, List<Integer>> graph, int[] visited, int src) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});

        while (!q.isEmpty()) {
            int[] removed = q.remove();

            if (visited[removed[0]] != -1) {
                if (removed[1] != visited[removed[0]])
                    return false;
            } else visited[removed[0]] = removed[1];

            for (int e : graph.get(removed[0])) {
                if (visited[e] == -1) {
                    q.add(new int[]{e, removed[1] + 1});
                }
            }
        }
        return true;

    }


    public boolean isBipartite(Map<Integer, List<Integer>> graph) {

        int V = graph.size();

        int[] visited = new int[V];
        Arrays.fill(visited, -1);
        for (int i = 0; i < V; i++) {
            if (visited[i] == -1) {
                if (!checkBipartiteness(graph, visited, i))
                    return false;
            }
        }


        return true;
    }


    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(0, 4));
        graph.put(3, Arrays.asList(1, 4));
        graph.put(4, Arrays.asList(3, 2));
        // graph.put(5, Arrays.asList(3, 4));

        System.out.println(new BipartiteGraph().isBipartite(graph));


    }
}
