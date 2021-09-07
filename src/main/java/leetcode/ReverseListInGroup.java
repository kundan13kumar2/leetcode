package leetcode;

public class ReverseListInGroup {

    static Node updateHead = null;

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node reverse(Node head, Node ptr, int k) {

        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (updateHead == null) {
            ptr = head;
            updateHead = prev;
        } else {
            Node dummy = ptr.next;
            ptr.next = prev;
            ptr = dummy;

        }
        return ptr;
    }

    public static void reverseUtil(Node head, int k) {
        Node temp = head;
        int count = 0;
        Node ptr = null;
        while (temp != null) {
            count++;
            if (count % k == 0) {
                temp = temp.next;
                ptr = reverse(head, ptr, k);
                ptr.next = temp;
                head = temp;
                count++;
            }
            if (temp != null)
                temp = temp.next;
        }
        if (count % k != 0) {
            int rem = count % k;
            ptr = reverse(head, ptr, rem);
            ptr.next = temp;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node n5 = new Node(5, null);
        // Node n6 = new Node(6, null);
        // Node n7 = new Node(7, null);
        // Node n8 = new Node(8, null);
        //  Node n9 = new Node(9, null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        // n5.next = n6;
        // n6.next = n7;
        // n7.next = n8;
        // n8.next = n9;


        reverseUtil(n1, 2);
        while (updateHead != null) {
            System.out.print(updateHead.val + " ");
            updateHead = updateHead.next;
        }
    }
}
