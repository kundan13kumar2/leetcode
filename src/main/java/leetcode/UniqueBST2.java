package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST2 {

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

    public static TreeNode copyTheTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(root.val, null, null);
        newNode.left = copyTheTree(root.left);
        newNode.right = copyTheTree(root.right);
        return newNode;
    }

    public static TreeNode insert2(TreeNode node, TreeNode root, TreeNode temp, boolean flag) {
        if (flag)
            temp.left = node;
        else {

            int val = node.val;
            node.val = temp.val;
            temp.val = val;
        }

        return root;
    }

    public static TreeNode insert3(TreeNode node, TreeNode root, TreeNode temp, boolean flag) {
        if (flag)
            temp.right = node;
        else {

            int val = node.val;
            node.val = temp.val;
            temp.val = val;
        }

        return root;
    }

    public static List<TreeNode> insert(int val, List<TreeNode> prevList) {
        List<TreeNode> results = new ArrayList<>();
        TreeNode node = new TreeNode(val);
        TreeNode node1 = new TreeNode(val);
        TreeNode node2 = new TreeNode(val);
        TreeNode node3 = new TreeNode(val);

        int size = prevList.size();
        int i = size;
        while (size > 0) {
            TreeNode temp = prevList.get(i - size);
            TreeNode temp1 = copyTheTree(prevList.get(i - size));
            TreeNode root = temp;
            TreeNode root11 = copyTheTree(temp);
            TreeNode root1 = temp1;
            TreeNode root21 = copyTheTree(temp1);
            size--;

            if (root.val > val) {
                node2.right = root;
                results.add(node2);
            } else {
                node3.left = root1;
                results.add(node3);
            }

            while (temp != null) {
                if (temp.val > val && temp.left != null)
                    temp = temp.left;
                else if (temp.val < val && temp.right != null)
                    temp = temp.right;
                else break;
            }
            while (temp1 != null) {
                if (temp1.val > val && temp1.left != null)
                    temp1 = temp1.left;
                else if (temp1.val < val && temp1.right != null)
                    temp1 = temp1.right;
                else break;
            }
            if (temp == null) continue;
            if (temp.left == null) {
                if (val > temp.val) {

                    TreeNode root3 = insert3(node, root, temp, true);
                    results.add(root3);
                    if (temp.right == null && temp.left == null) {
                        TreeNode root4 = insert3(node1, root1, temp1, false);
                        temp1.left = node1;
                        results.add(root4);
                    }


                } else {

                    TreeNode root3 = insert2(node, root11, temp, true);
                    results.add(root3);
                    if (temp1.left == null && temp1.right == null) {
                        TreeNode root4 = insert2(node1, root21, temp1, false);
                        temp1.right = node1;
                        results.add(root4);
                    }

                }
            }
        }

        return results;
    }

    public static TreeNode insert1(int val, TreeNode node1) {
        TreeNode node = new TreeNode(val);
        if (val < node1.val)
            node1.left = node;
        else
            node1.right = node;
        return node1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        List<TreeNode> resultList = new ArrayList<>();
        TreeNode node1 = new TreeNode(arr[arr.length - 1]);
        TreeNode node2 = new TreeNode(arr[arr.length - 2]);

        TreeNode vv = insert1(2, node1);
        resultList.add(vv);


        TreeNode vv1 = insert1(3, node2);
        resultList.add(vv1);

        for (int i = arr.length - 3; i >= 0; i--) {
            resultList = insert(arr[i], resultList);
        }
        System.out.println("sdfs");
    }
}
