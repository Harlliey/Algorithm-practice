package lecture_5;

/*
Leetcode 98. Validate Binary Search Tree
*/

import java.util.Stack;

public class ValidateBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Info {
        int max;
        int min;
        boolean isBST;
        
        Info(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public boolean validateBSTRecur(TreeNode root) {
        Info info = processRecur(root);

        return info.isBST;
    }

    private Info processRecur(TreeNode root) {
        if (root == null) {
            return null;
        }

        Info leftInfo = processRecur(root.left);
        Info rightInfo = processRecur(root.right);

        int max = root.val;
        int min = root.val;

        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }

        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }

        boolean isBST = false;
        isBST = (leftInfo != null ? (leftInfo.isBST && leftInfo.max < root.val) : true) 
        && (rightInfo != null ? (rightInfo.isBST && rightInfo.min > root.val) : true); 

        return new Info(max, min, isBST);
    }

    public boolean validateBSTunRcur(TreeNode root) {
        boolean isBST = false;

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            // There is a test case in Leetcode passing the Integer.MIN_VALUE as the value of a node, so the prev should be set to a smaller number
            // Notice, the smallest edge a double value can represent is the -Double.MAX_VALUE, which is a negative number, instead of the Double.MIN_VALUE
            // The explanation is attached here, https://stackoverflow.com/questions/3884793/why-is-double-min-value-in-not-negative
            double prev = -Double.MAX_VALUE;
            int cur = 0;

            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    cur = root.val;
                    isBST = cur > prev ? true : false;
                    if (!isBST) break;
                    prev = cur;
                    root = root.right; 
                }
            }
        }

        return isBST;
    }
}