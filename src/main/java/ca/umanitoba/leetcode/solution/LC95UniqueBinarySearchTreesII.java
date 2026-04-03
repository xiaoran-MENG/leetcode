package ca.umanitoba.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

import ca.umanitoba.leetcode.model.TreeNode;

public class LC95UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int low, int high) {
        List<TreeNode> result = new ArrayList<>();
        if (low > high) result.add(null);
        // 枚举区间的每个值作根节点
        for (int val = low; val <= high; val++) {
            // 分：用小于当前根节点的区间找出左子树组合
            List<TreeNode> leftTrees = generate(low, val - 1);
            // 分：用大于当前根节点的区间找出右子树组合
            List<TreeNode> rightTrees = generate(val + 1, high);
            // 治：用当前根节点与左右子树组合合并
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(val);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
