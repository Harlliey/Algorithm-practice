package lecture_5;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
Leetcode 662. Maximum Width of Binary Tree
*/

public class WidthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solve the problem with bfs, record the position of every valid node using a hashmap
    public int getMaxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> qDeque = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int pos = 1;
        int maxWidth = 1;
        int cLevelNodes = 0;
        qDeque.offerLast(root);
        map.put(root, pos);

        while (!qDeque.isEmpty()) {
            TreeNode lastNode = qDeque.peekLast();
            TreeNode firstNode = qDeque.peekFirst();
            int curWidth = map.get(lastNode) - map.get(firstNode) + 1;
            maxWidth = maxWidth > curWidth ? maxWidth : curWidth;
        	
            cLevelNodes = qDeque.size();
            while (cLevelNodes != 0) {
                TreeNode curNode = qDeque.pollFirst();
                pos = map.get(curNode);
                if (curNode.left != null) {
                    qDeque.offerLast(curNode.left);
                    map.put(curNode.left, pos * 2);
                }
                if (curNode.right != null) {
                    qDeque.offerLast(curNode.right);
                    map.put(curNode.right, pos * 2 + 1);
                }
                cLevelNodes --;
            }
        }

        return maxWidth;
    }
}