package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoodLeaf1530 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        GoodLeaf1530 goodLeaf1530 = new GoodLeaf1530();
        TreeNode node4= new TreeNode(4, null, null);
        TreeNode node2= new TreeNode(2, null, node4);
        TreeNode node3= new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, node2, node3);

        int distance = 3;
        System.out.println(goodLeaf1530.countPairs(root, distance));
    }

    int ans=0;
    public List<Integer> recur(TreeNode node, int d) {
        if (node == null) return Collections.singletonList(0);
        if (node.left == null && node.right == null) {
            return Collections.singletonList(1);
        }
        List<Integer> left = recur(node.left, d);
        List<Integer> right = recur(node.right, d);

        for (int l : left) {
            for (int r : right) {
                if ((l != 0 && r != 0) && l + r <= d) {
                    ans++;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int l : left) {
            if (l != 0 && l + 1 < d)
                list.add(l+1);
        }
        for (int r : right) {
            if (r != 0 && r + 1 < d)
                list.add(r+1);
        }
        return list;
    }

    public int countPairs(TreeNode root, int distance) {
        recur(root,distance);
        return ans;
    }


}
