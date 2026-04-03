package ca.umanitoba.leetcode.solution;

import ca.umanitoba.leetcode.model.TreeNode;

public class LC98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
