package daily;

import java.util.*;

class Solution {

    public int solution(int[] D, int[] C, int P) {

        List<Order> orders;
        orders = new ArrayList<>();
        for (int i = 0; i < D.length; i++) {
            orders.add(new Order(D[i], C[i]));
        }

        Collections.sort(orders, Comparator.comparingInt(Order::getDistance));

        int counter =0;

        int rem=P;
        for (Order order : orders) {
            if (rem>order.quantity) {
                counter++;
            }else {
                break;
            }
            rem -=order.quantity;
        }

        return counter;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] D = {11,18,1};
        int[] C = {9,18,8};
        int P = 7; // Total number of monitors available

        Solution solution = new Solution();
        int maxOrders = solution.solution(D, C, P);
        System.out.println("Maximum total number of orders that can be fulfilled: " + maxOrders); // Output: 15
    }

    static class Order {
        int distance;
        int quantity;

        Order(int distance, int quantity) {
            this.distance = distance;
            this.quantity = quantity;
        }
        int getDistance() {
            return distance;
        }
    }
}
