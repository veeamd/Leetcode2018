package com.weizhang;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */

public class BinaryTreeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        // recursive solution
//        ArrayList<Integer> output = new ArrayList<Integer>();
//        helperRecursively(output, root);
//        return output;

        // iterative solution
        ArrayList<Integer> output = new ArrayList<Integer>();
        if (root == null) {
            return output;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode currentNode = root;
        while (currentNode != null || !stack.empty()) {
//            if (currentNode == null) {
//                currentNode = stack.pop();
//                output.add(currentNode.val);
//                currentNode = currentNode.right;
//            } else if (currentNode.left != null) {
//                stack.push(currentNode);
//                currentNode = currentNode.left;
//            } else {
//                output.add(currentNode.val);
//                currentNode = currentNode.right;
//            }

            // simpler version. not tested
            if (currentNode == null) {
                currentNode = stack.pop();
                output.add(currentNode.val);
                currentNode = currentNode.right;
            } else {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
        }
        return output;
    }

    void helperRecursively(ArrayList<Integer> output, TreeNode node) {
        if (node.left != null) {
            helperRecursively(output, node.left);
        }
        output.add(node.val);
        if (node.right != null) {
            helperRecursively(output, node.right);
        }
    }


}


