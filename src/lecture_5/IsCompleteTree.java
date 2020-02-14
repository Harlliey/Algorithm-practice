package lecture_5;

/*
Leetcode 958. Check Completeness of a Binary Tree
*/

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean checkLeaf = false;
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            leftNode = curNode.left;
            rightNode = curNode.right;

            if ((leftNode == null && rightNode != null) || (checkLeaf && !(leftNode == null && rightNode == null))) {
                return false;
            }

            if (leftNode != null) {
                queue.offer(leftNode);
            }

            if (rightNode != null) {
                queue.offer(rightNode);
            }

            checkLeaf = rightNode == null;
        }

        return true;
    }
}