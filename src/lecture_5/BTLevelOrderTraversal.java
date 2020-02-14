package lecture_5;

/*
Leetcode 102. Binary Tree Level Order Traversal
*/


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Method one used two variables to record the number of nodes in current level and new level
    private List<List<Integer>> levelOrderTraversal_1(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();

        if (root == null) {
            return resList;
        }

        List<Integer> levelList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int cLevelNodes = 1;    // Trace the nodes number in current level
        int nLevelNodes = 0;    // Trace the nodes number in next level
        queue.offer(root);

        while (!queue.isEmpty()) {
            while (cLevelNodes != 0) {
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.offer(node.left);
                    nLevelNodes ++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nLevelNodes ++;
                }

                cLevelNodes --;
                levelList.add(node.val);
                if (cLevelNodes == 0) {
                    resList.add(levelList);
                    levelList = new LinkedList<>();
                    cLevelNodes = nLevelNodes;
                    nLevelNodes = 0;
                }
            }
        }

        return resList;
    }

    // Method two regards the nodes number in the queue as the nodes number in current level, reduce the use of one variable
    private List<List<Integer>> levelOrderTraversal_2(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();

        if (root == null) {
            return resList;
        }

        List<Integer> levelList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int cLevelNodes = 0;
        queue.offer(root);
        
        while (! queue.isEmpty()) {
            cLevelNodes = queue.size();
            while (cLevelNodes != 0) {
                TreeNode curNode = queue.poll();

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }

                levelList.add(curNode.val);
                cLevelNodes --;
            }

            resList.add(levelList);
            levelList = new LinkedList<>();
        }

        return resList;
    }
}