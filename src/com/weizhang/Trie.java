package com.weizhang;

/**
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 */


class Trie {

    static class Node {

        static int N = 26;
        Node[] children;
        boolean isWord;

        Node() {
            children = new Node[N];
        }

    }

    Node rootNode;

    /** Initialize your data structure here. */
    public Trie() {
        rootNode = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int indexInNode = c - 'a';
            Node newNode = currentNode.children[indexInNode];
            if (newNode == null) {
                newNode = new Node();
                currentNode.children[indexInNode] = newNode;
            }
            currentNode = newNode;
        }
        currentNode.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Node searchPrefix(String prefix) {
        Node currentNode = rootNode;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int indexInNode = c - 'a';
            Node node = currentNode.children[indexInNode];
            if (node != null) {
                currentNode = node;
            } else {
                return null;
            }
        }
        return currentNode;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        boolean found = trie.search("apple");   // returns true
        found = trie.search("app");     // returns false
        found = trie.startsWith("app"); // returns true
        trie.insert("app");
        found = trie.search("app");     // returns true
    }
}
