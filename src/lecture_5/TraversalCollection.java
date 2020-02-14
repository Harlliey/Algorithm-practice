package lecture_5;

/*
Leetcode 94. Binary Tree Inorder Traversal
Leetcode 144. Binary Tree Preorder Traversal
Leetcode 145. Binary Tree Postorder Traversal
*/


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TraversalCollection {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> inorderResList = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalRecursive(root);
        return inorderResList;
    }

    private void inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversalRecursive(root.left);
        inorderResList.add(root.val);
        inorderTraversalRecursive(root.right);
    }

    private List<Integer> inorderTraversalunRecursive(TreeNode root) {
        Stack<TreeNode> helpStack = new Stack<>();

        while (root != null || !helpStack.isEmpty()) {
            if (root != null) {
                helpStack.push(root);
                root = root.left;
            } else {
                root = helpStack.pop();
                inorderResList.add(root.val);
                root = root.right;
            }
        }

        return inorderResList;
    }

    List<Integer> preorderResList = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversalRecursive(root);
        return preorderResList;
    }

    private void preorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        preorderResList.add(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
    }

    public List<Integer> preorderTraversalunRecursive(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> helpStack = new Stack<>();
            helpStack.push(root);
            while (! helpStack.isEmpty()) {
                root = helpStack.pop();
                preorderResList.add(root.val);
                if (root.right != null) {
                    helpStack.push(root.right);
                }
                if (root.left != null) {
                    helpStack.push(root.left);
                }
            }
        }

        return preorderResList;
    }

    List<Integer> postorderResList = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorderTraversalRecursive(root);
        return postorderResList;
    }

    private void postorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraversalRecursive(root.left);
        postorderTraversalRecursive(root.right);
        postorderResList.add(root.val);
    }

    // Method one used two stacks to solve the problem, with producing the sequece root-right-left first, 
	// then, reverse the sequence with the extra stack
    public List<Integer> postorderTraversalunRecursive_1(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> helpStack = new Stack<>();
            Stack<TreeNode> resStack = new Stack<>();
            helpStack.add(root);
            while (!helpStack.isEmpty()) {
                root = helpStack.pop();
                resStack.push(root);
                if (root.left != null) {
                    helpStack.push(root.left);
                }
                if (root.right != null) {
                    helpStack.push(root.right);
                }
            }

            while (!resStack.isEmpty()) {
                postorderResList.add(resStack.pop().val);
            }
        }

        return postorderResList;
    }

    // Method two used just one stack to solve the problem, with an extra variable to trace the top of the stack, 
    // which can be compared with the root variable to avoid the repeated traversal
    public List<Integer> postorderTraversalunRecursive_2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> helpStack = new Stack<>();
            helpStack.push(root);
            TreeNode helpNode = null;
            while (!helpStack.isEmpty()) {
                helpNode = helpStack.peek();
                if (helpNode.left != null && root != helpNode.left && root != helpNode.right) {
                    helpStack.push(helpNode);
                } else if (helpNode.right != null && root != helpNode.right) {
                    helpStack.push(helpNode);
                } else {
                    postorderResList.add(helpStack.pop().val);
                    root = helpNode;
                }
            }
        }

        return postorderResList;
    }
}