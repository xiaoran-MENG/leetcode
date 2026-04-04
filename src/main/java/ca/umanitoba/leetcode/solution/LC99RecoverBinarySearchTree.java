package ca.umanitoba.leetcode.solution;

import ca.umanitoba.leetcode.model.TreeNode;

// BST中序遍历：从大到小
// 若有节点被调换，就会出现逆序
// 1 2 3 4 5
// 1 4 3 2 5
// 第一次逆序： 4 > 3
// 第二次逆序： 3 > 2
public class LC99RecoverBinarySearchTree {
    private TreeNode prev, first, second;

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        inorderTraversal(root.right);
    }
}
