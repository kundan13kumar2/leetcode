package daily;

public class SumLeftLeaves404 {
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
    int sum=0;
    public static void main(String[] args) {
        SumLeftLeaves404 sumLeftLeaves404 = new SumLeftLeaves404();
        TreeNode left2 = new TreeNode(15, null, null);
        TreeNode right2 = new TreeNode(7, null, null);
        TreeNode left1 = new TreeNode(9, null, null);
        TreeNode right1 = new TreeNode(20, left2, right2);
        TreeNode root = new TreeNode(3, left1, right1);

        System.out.println(sumLeftLeaves404.sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        SLL(root,false);
        return sum;
    }

    public void SLL(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
            return;
        }
        if (node.left != null) SLL(node.left, true);
        if (node.right != null) SLL(node.right, false);
    }
}
