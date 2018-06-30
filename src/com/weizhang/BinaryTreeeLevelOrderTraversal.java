package com.weizhang;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class BinaryTreeeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> output;
        output = new ArrayList<List<Integer>>();
        if (root == null) {
            return output;
        }
        ArrayList<TreeNode> input = new ArrayList<TreeNode>();
        input.add(root);
        while (input.size() > 0) {
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            ArrayList<Integer> levelOutput = new ArrayList<Integer>();
            for (int i = 0; i < input.size(); i++) {
                TreeNode node = input.get(i);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                levelOutput.add(node.val);
            }
            output.add(levelOutput);
            input = nextLevel;
        }
        return output;
    }
}
