package daily;

import java.util.*;

public class PowerGridMaintenance {
    static Map<Integer, List<Integer>> powerGrid = new HashMap<>();

    static Map<Integer, PriorityQueue<Integer>> componentGrid = new HashMap<>();

    static Map<Integer, Integer> componentTowerMapping = new HashMap<>();


    public static void main(String[] args) {

        //int[][] grid = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] grid = {};
        if (grid.length == 0) {
            grid = new int[1][2];
            grid[0][0] = 1;
            grid[0][1] = 1;
        }

        PowerGridMaintenance m = new PowerGridMaintenance();
        m.constructPowerGrid(grid);

        m.constructDS(2);

        //int[][] query = {{1, 2}, {2, 2}, {1, 2}, {1, 2}, {2, 2}, {2, 2}, {2, 2}, {1, 2}, {1, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 2}, {1, 2}, {2, 2}, {1, 2}, {1, 2}};

        int[][] query = {{1, 1}, {2, 1}, {1, 1}};
        List<Integer> result = new ArrayList<>();
        boolean[] removed = new boolean[2 + 1];
        for (int i = 0; i < query.length; i++) {
            if (query[i][0] == 1) {
                if (!removed[query[i][1]] && powerGrid.containsKey(query[i][1])) {
                    result.add(query[i][1]);
                } else {
                    PriorityQueue<Integer> elementList = componentGrid.get(componentTowerMapping.get(query[i][1]));
                    Integer key = elementList == null ? Integer.valueOf(-1) : elementList.peek();
                    result.add(key == null ? -1 : key);
                }
            } else {
                PriorityQueue<Integer> elementList = componentGrid.get(componentTowerMapping.get(query[i][1]));
                if (elementList != null) {
                    elementList.remove(query[i][1]);
                }
                removed[query[i][1]] = true;
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        System.out.println(Arrays.toString(ans));
        System.out.println(ans);
    }


    public void constructDS(int c) {

        int component = 1;
        boolean[] visited = new boolean[100001];

        for (int s : powerGrid.keySet()) {
            if (!visited[s]) {
                PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
                dfs(s, -1, visited, queue, component);
                componentGrid.put(component, queue);
                component++;
            }
        }
    }

    public void dfs(int u, int p, boolean[] visited, PriorityQueue<Integer> componentElement, int component) {
        if (visited[u]) return;

        visited[u] = true;
        componentTowerMapping.put(u, component);
        componentElement.add(u);
        for (int v : powerGrid.get(u)) {
            if (!visited[v] && v != p) {
                dfs(v, u, visited, componentElement, component);
            }
        }

    }


    public void constructPowerGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int x = grid[i][0];
            int y = grid[i][1];

            powerGrid.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            powerGrid.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
    }


}
