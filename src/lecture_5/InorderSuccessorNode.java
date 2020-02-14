package lecture_5;

public class InorderSuccessorNode {
    class TreeNode {
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) { val = x; }
    }

    public TreeNode getSuccessorNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return getRightMostLeft(node);
        } else {
            return getParentFirstLeft(node);
        }
    }

    private TreeNode getRightMostLeft(TreeNode node) {
        TreeNode mostLeft = node.right;
        while (mostLeft != null) {
            mostLeft = mostLeft.left;
        }

        return mostLeft;
    }

    private TreeNode getParentFirstLeft(TreeNode node) {
        TreeNode parentNode = node.parent;
        TreeNode curNode = node;
        while (parentNode != null && parentNode.left != curNode) {
            curNode = parentNode;
            parentNode = parentNode.parent;
        }

        return curNode;
    }
}