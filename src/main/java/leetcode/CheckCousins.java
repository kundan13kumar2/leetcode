package leetcode;

public class CheckCousins {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Node {
        int depth;
        int parent;

        public Node(int depth, int parent) {
            this.depth = depth;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "depth=" + depth +
                    ", parent=" + parent +
                    '}';
        }
    }

    public Node findDepthParent(TreeNode root, int data, int depth, int parent) {
        if (root == null) return null;
        if (root.val == data) {
            return new Node(depth, parent);
        }
        Node left = findDepthParent(root.left, data, depth + 1, root.val);
        Node right = findDepthParent(root.right, data, depth + 1, root.val);
        return left == null ? right : left;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Node xNode = findDepthParent(root, x, 0, -1);
        Node yNode = findDepthParent(root, y, 0, -1);
        System.out.println(xNode);
        System.out.println(yNode);
        return xNode.depth == yNode.depth && xNode.parent != yNode.parent;
    }

    public static void main(String[] args) {
        CheckCousins cousins = new CheckCousins();
        TreeNode root1 = cousins.new TreeNode(1, null, null);
        TreeNode root2 = cousins.new TreeNode(2, null, null);
        TreeNode root3 = cousins.new TreeNode(3, null, null);
        TreeNode root4 = cousins.new TreeNode(4, null, null);
        TreeNode root5 = cousins.new TreeNode(5, null, null);
        root1.left = root2;
        root1.right = root3;
        root2.right = root4;
        root3.right = root5;

        System.out.println(cousins.isCousins(root1, 5, 4));

    }

}
