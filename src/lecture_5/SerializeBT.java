package lecture_5;

import java.util.LinkedList;
import java.util.Queue;

/*
Leetcode 297. Serialize and Deserialize Binary Tree
*/

public class SerializeBT {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize_preorder(TreeNode root) {
        if (root == null) {
            return "#_";
        }

        String result = root.val + "_";
        result += serialize_preorder(root.left);
        result += serialize_preorder(root.right);

        return result;
    }

    public TreeNode deserialize_preorder(String data) {
        Queue<String> queue = collectNodes(data);
        TreeNode resNode = process(queue);

        return resNode;
    }

    public String serialize_levelorder(TreeNode root) {
        if (root == null) {
            return "#_";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        String res = "";
        res += root.val + "_";
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            if (curNode.left != null) {
                res += curNode.left.val + "_";
                queue.offer(curNode.left);
            } else {
                res += "#_";
            }

            if (curNode.right != null) {
                res += curNode.right.val + "_";
                queue.offer(curNode.right);
            } else {
                res += "#_";
            }
        }

        return res;
    }

    public TreeNode deserialize_levelorder(String data) {
        String[] strArr = data.split("_");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = generateNodeFromStr(strArr[index++]);
        TreeNode node = null;
        
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeFromStr(strArr[index++]);
            node.right = generateNodeFromStr(strArr[index++]);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }

    private Queue<String> collectNodes(String data) {
        String[] nodesArr = data.split("_");
        Queue<String> nodesQ = new LinkedList<>();
        for (String str : nodesArr) {
            nodesQ.offer(str);
        }

        return nodesQ;
    }

    private TreeNode process(Queue<String> queue) {
        String str = queue.poll();
        if (str.equals("#_")) {
            return null;
        }

        TreeNode curNode = new TreeNode(Integer.valueOf(str));
        curNode.left = process(queue);
        curNode.right = process(queue);

        return curNode;
    }

    private TreeNode generateNodeFromStr(String str) {
        if (str.equals("#")) {
            return null;
        }

        return new TreeNode(Integer.valueOf(str));
    }
}