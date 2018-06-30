package com.weizhang;


/**
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer).
 * The string represents the key and the integer represents the value.
 * If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix,
 * and you need to return the sum of all the pairs' value whose key starts with the prefix.
 *
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 *
 */
class MapSumPairs {

    Trie trie;

    /** Initialize your data structure here. */
    public MapSumPairs() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.wordValueSumWithPrefix(prefix);
    }

    public static void main(String[] args) {
        MapSumPairs obj = new MapSumPairs();
        obj.insert("apple", 3);
        int sum = obj.sum("app");
        obj.insert("app", 2);
        sum = obj.sum("app");
        obj.insert("apptor", 1);
        obj.insert("appsum", 10);
        sum = obj.sum("app");
    }

    static class TrieNode {

        static int N = 26;
        TrieNode[] children;
        boolean isWord;
        int val;

        TrieNode() {
            children = new TrieNode[N];
        }

        TrieNode getChild(char atLetter) {
            return children[atLetter - 'a'];
        }

        void setChild(TrieNode child, char atLetter) {
            children[atLetter - 'a'] = child;
        }

    }

    static class Trie {

        TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        public void insert(String word, int val) {
            TrieNode currentNode = rootNode;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                TrieNode newNode = currentNode.getChild(letter);
                if (newNode == null) {
                    newNode = new TrieNode();
                }
                currentNode.setChild(newNode, letter);
                currentNode = newNode;
            }
            currentNode.isWord = true;
            currentNode.val = val;
        }

        TrieNode searchPrefix(String prefix) {
            TrieNode currentNode = rootNode;
            for (int i = 0; i < prefix.length(); i++) {
                char letter = prefix.charAt(i);
                TrieNode newNode = currentNode.getChild(letter);
                if (newNode != null) {
                    currentNode = newNode;
                } else {
                    return null;
                }
            }
            return currentNode;
        }

        int wordValueSumWithPrefix(String prefix) {
            TrieNode prefixNode = searchPrefix(prefix);
            if (prefix == null) {
                return 0;
            }

            return wordSumHelper(prefixNode);

        }

        int wordSumHelper(TrieNode node) {
            if (node == null) {
                return 0;
            }
            int sum = node.val;
            for (int i = 0; i < node.children.length; i++) {
                sum += wordSumHelper(node.children[i]);
            }
            return sum;
        }

    }
}





/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
