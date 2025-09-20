package daily;

import java.util.*;

// It is working fine but throwing TLE on Leetcode

public class Router {

    class Node {
        int source;
        int destination;
        int timestamp;

        Node(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            Node n = (Node) o;

            return n.timestamp == timestamp && n.source == source && n.destination == destination;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }

        @Override
        public String toString() {
            return source + "-" + destination + "-" + timestamp;
        }
    }

    Queue<Node> queue = new LinkedList<>();
    int routerSize;
    Map<Integer, List<Node>> map = new HashMap<>();

    public static void main(String[] args) {
        Router router = new Router(3);
        router.addPacket(1, 4, 90);
        router.addPacket(2, 5, 90);
        router.addPacket(1, 4, 90);
        router.addPacket(3, 5, 95);
        router.addPacket(4, 5, 105);
        System.out.println(Arrays.toString(router.forwardPacket()));
        router.addPacket(5, 2, 110);
        System.out.println(router.getCount(5, 100, 105));


        router = new Router(2);
        router.addPacket(3,1,3);
        router.addPacket(1,2,3);
        router.addPacket(4,5,3);
        System.out.println(router.getCount(1,2,3));
        //System.out.println(Arrays.toString(router.forwardPacket()));
    }

    public Router(int memoryLimit) {
        routerSize = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        System.out.println(queue);
        boolean duplicate = false;
        if (queue.contains(new Node(source, destination, timestamp))) {
            return false;
        }
        Node removedNode = null;
        if (queue.size() == routerSize) {
            removedNode = queue.remove();
        }
        queue.add(new Node(source, destination, timestamp));
        List<Node> existingNode = map.getOrDefault(destination, new ArrayList<>());
        resetMap(removedNode);
        existingNode.add(new Node(source, destination, timestamp));
        map.put(destination, existingNode);
        return !duplicate;
    }


    private void resetMap(Node removedNode) {
        if (removedNode==null) return;

        map.get(removedNode.destination).remove(removedNode);
        if(map.get(removedNode.destination).isEmpty()) {
            map.remove(removedNode.destination);
        }

    }

    public int[] forwardPacket() {
        System.out.println(queue);
        Node node = queue.poll();
        if (node == null) return new int[]{};
        map.get(node.destination).remove(node);
        return new int[]{node.source, node.destination, node.timestamp};// queue.remove();
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!map.containsKey(destination)) {
            return 0;
        }

        List<Node> list = map.get(destination);

        list.sort(Comparator.comparingInt(node -> node.timestamp));

        int lb = lowerBound(list, startTime);
        int ub = upperBound(list, endTime);
        return ub - lb;
    }

    private int lowerBound(List<Node> list, int lb) {

        int l = 0;
        int r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;

            if (list.get(m).timestamp < lb) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int upperBound(List<Node> list, int ub) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m).timestamp <= ub) l = m + 1;
            else r = m;
        }
        return l;
    }
}
