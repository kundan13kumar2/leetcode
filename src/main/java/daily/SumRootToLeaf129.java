package daily;

public class SumRootToLeaf129 {

    int ans = 0;

    public static class TreeNode {
        int val;
        SumRootToLeaf129.TreeNode left;
        SumRootToLeaf129.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, SumRootToLeaf129.TreeNode left, SumRootToLeaf129.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        SumRootToLeaf129 sumLeftLeaves404 = new SumRootToLeaf129();
        SumRootToLeaf129.TreeNode left2 = new SumRootToLeaf129.TreeNode(5, null, null);
        SumRootToLeaf129.TreeNode right2 = new SumRootToLeaf129.TreeNode(1, null, null);
        SumRootToLeaf129.TreeNode left1 = new SumRootToLeaf129.TreeNode(9, left2, right2);
        SumRootToLeaf129.TreeNode right1 = new SumRootToLeaf129.TreeNode(0, null, null);
        SumRootToLeaf129.TreeNode root = new SumRootToLeaf129.TreeNode(4, left1, right1);

        sumLeftLeaves404.sumNumbers( root);
    }

    public int sumNumbers(TreeNode root) {
        RTL(0, root);
        System.out.println(ans);
        return ans;
    }

    public void RTL(int val, TreeNode node) {
        if (node.left == null && node.right == null) {
            ans += (val * 10 + node.val);
        }
        if (node.left != null)
            RTL(val * 10 + node.val, node.left);

        if (node.right != null)
            RTL(val * 10 + node.val, node.right);
    }
}
