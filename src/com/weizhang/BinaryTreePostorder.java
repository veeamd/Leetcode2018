package com.weizhang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */


public class BinaryTreePostorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        if (root != null) {
//            recursive(output, root);
            iterative(output, root);
        }
        return output;

    }


    // recursive
    void recursive(ArrayList<Integer> output, TreeNode node) {
        if (node.left != null) {
            recursive(output, node.left);
        }
        if (node.right != null) {
            recursive(output, node.right);
        }
        output.add(node.val);
    }


    // iterative
    void iterative(ArrayList<Integer> output, TreeNode node) {
        TreeNode currentNode = node;
        // save to here when left is read
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        // save to here when right is read
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        while (currentNode != null || !s1.empty()) {
            if (currentNode != null) {
                s1.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (s2.empty() || s1.peek() != s2.peek()) {
                    // first node from s1, it's left branch is one
                    currentNode = s1.peek();
                    s2.push(currentNode);
                    // go to read the right branch
                    currentNode = currentNode.right;
                } else {
                    assert s1.peek() == s2.peek();
                    // top element's right branch is done
                    // read it
                    s1.pop();
                    output.add(s2.pop().val);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        BinaryTreePostorder test = new BinaryTreePostorder();
        List<Integer> output = test.postorderTraversal(root);
    }
}
