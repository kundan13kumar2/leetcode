package leetcode;

public class SwapNodesInPair {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode updatedHead = null;

    public ListNode swap(ListNode f, ListNode s, ListNode ptr) {
        ListNode t = f;
        f.next = s.next;
        s.next = t;
        
        if (ptr == null) {
            ptr = f;
            updatedHead = s;
        } else {
            ptr.next = s;
            ptr = f;
        }
        return ptr;
    }

    public void swapPairs(ListNode head) {
        ListNode temp = head;
        ListNode ptr = null;
        while (temp != null && temp.next != null) {
            ptr = swap(temp, temp.next, ptr);
            if (temp.next != null) {
                temp = temp.next;
                ptr.next = temp;
            }
        }

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        SwapNodesInPair p = new SwapNodesInPair();

        p.swapPairs(n1);
        if (n1.next == null)
            p.updatedHead = n1;
        while (p.updatedHead != null) {
            System.out.println(p.updatedHead.val);
            p.updatedHead = p.updatedHead.next;
        }


    }

}
