package lecture_5;

/*
Leetcode 110. Balanced Binary Tree
*/

public class IsBalancedTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Info {
        int height;
        boolean isBalanced;

        Info(int h, boolean isB) {
            height = h;
            isBalanced = isB; 
        }
    }

    public boolean isBalanced(TreeNode root) {
        Info info = process(root);

        return info.isBalanced;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && (Math.abs(leftInfo.height - rightInfo.height) <= 1);

        return new Info(height, isBalanced);
    }
}