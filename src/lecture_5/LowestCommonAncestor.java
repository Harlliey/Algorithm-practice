package lecture_5;

/*
Leetcode 236. Lowest Common Ancestor
*/

public class LowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // The neat solution
    public TreeNode lowestCommonAnc_1 (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        
        TreeNode leftRet = lowestCommonAnc_1(root.left, p, q);
        TreeNode rightRet = lowestCommonAnc_1(root.right, p ,q);
        
        if (leftRet != null && rightRet != null) return root;
        if (leftRet == null && rightRet == null) return null;
        
        return leftRet == null ? rightRet : leftRet;
    }

    
    // The complex but widely adapted solution
    class Info {
        boolean hasP;
        boolean hasQ;
        TreeNode ancestor;

        Info(boolean hp, boolean hq, TreeNode anc) {
            hasP = hp;
            hasQ = hq;
            ancestor = anc;
        }
    }

    public TreeNode lowestCommonAnc_2(TreeNode root, TreeNode p, TreeNode q) {
        Info info = process(root, p, q);

        return info.ancestor;
    }

    private Info process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Info(false, false, null);
        }

        Info leftInfo = process(root.left, p, q);
        Info rightInfo = process(root.right, p, q);

        boolean hasP;
        boolean hasQ;
        TreeNode ancestor = null;

        if (leftInfo.ancestor != null || rightInfo.ancestor != null) {
            hasP = true;
            hasQ = true;
            ancestor = leftInfo.ancestor != null ? leftInfo.ancestor : rightInfo.ancestor;
            return new Info(hasP, hasQ, ancestor);
        }

        if (leftInfo.hasP && rightInfo.hasQ) {
            hasP = true;
            hasQ = true;
            ancestor = root;
            return new Info(hasP, hasQ, ancestor);
        }

        if (leftInfo.hasQ && rightInfo.hasP) {
            hasP = true;
            hasQ = true;
            ancestor = root;
            return new Info(hasP, hasQ, ancestor);
        }

        hasP = root == p ? true : false;
        hasQ = root == q ? true : false;

        if (hasP) {
            ancestor = leftInfo.hasQ || rightInfo.hasQ ? root : null;
        }
        if (hasQ) {
            ancestor = leftInfo.hasP || rightInfo.hasP ? root : null;
        }

        hasP = hasP || leftInfo.hasP || rightInfo.hasP;
        hasQ = hasQ || leftInfo.hasQ || rightInfo.hasQ;

        return new Info(hasP, hasQ, ancestor);
    }
}