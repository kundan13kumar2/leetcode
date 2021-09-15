package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean recur(TreeNode root, List<Integer> list, int target) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            int sum = root.val;
            for (int k : list)
                sum += k;
            return sum == target;
        }

        list.add(root.val);
        boolean l = recur(root.left, new ArrayList<>(list), target);
        boolean r = recur(root.right, new ArrayList<>(list), target);

        return l || r;


    }

    public static void main(String[] args) {

        RootToLeafPathSum leafPathSum = new RootToLeafPathSum();

        TreeNode root10 = leafPathSum.new TreeNode(10);
        TreeNode root8 = leafPathSum.new TreeNode(8);
        TreeNode root2 = leafPathSum.new TreeNode(2);
        TreeNode root3 = leafPathSum.new TreeNode(3);
        TreeNode root5 = leafPathSum.new TreeNode(5);
        TreeNode root6 = leafPathSum.new TreeNode(6);

        root10.left = root8;
        root10.right = root2;
        root8.left = root3;
        root8.right = root5;
        root2.left = root6;


        System.out.println(leafPathSum.recur(root10, new ArrayList<>(), 22));
    }
}
