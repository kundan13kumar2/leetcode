package google;

import java.util.*;

public class GraphColouring {


    public boolean colorGraph(Map<Integer, List<Integer>> graph, int m) {
        Set<Integer> colorSet = new HashSet<>();
        int n = graph.size();
        boolean[] visited = new boolean[n];
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);

            List<Integer> list = graph.get(i);
            for (int t : list) {
                if (color[t] != -1)
                    visited[color[t]] = true;
            }
            for (int j = 0; j < n; j++)
                if (!visited[j]) {
                    if (colorSet.size() == 2) return false;
                    colorSet.add(j);
                    color[i] = j;
                    break;
                }
        }
        System.out.println(Arrays.toString(color));
        return colorSet.size() == 2;

    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1, 3));
        graph.put(1, Arrays.asList(0, 2, 4));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(0, 2, 4));
        graph.put(4, Arrays.asList(0, 1, 3));
        System.out.println(new GraphColouring().colorGraph(graph, 1));

    }

}
