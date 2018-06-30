package com.weizhang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */

/** parent is read before children **/

public class BinaryTreePreorder {
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> output = new ArrayList<Integer>();
        if (root != null) {
            // recursive solution
//            preorder(output, root);
            // iterative solution
            iterative(output, root);
        }
        return output;
    }


    // recursive
    void preorder(ArrayList<Integer> output, TreeNode node) {
        output.add(node.val);
        if (node.left != null) {
            preorder(output, node.left);
        }
        if (node.right != null) {
            preorder(output, node.right);
        }
    }

    // iteratively
    // assume node is not null, output is predefined
    void iterative(ArrayList<Integer> output, TreeNode node) {
        TreeNode currentNode = node;
        // stack is for caching right node
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (currentNode != null || !stack.empty()) {
            if (currentNode == null) {
                currentNode = stack.pop();
            } else {
                output.add(currentNode.val);
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                currentNode = currentNode.left;
            }
        }
    }




}

