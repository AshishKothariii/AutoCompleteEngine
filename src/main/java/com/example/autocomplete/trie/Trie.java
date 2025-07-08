package com.example.autocomplete.trie;

import java.util.ArrayList;
import java.util.List;


public class Trie {
    private static Trie instance;
    private final TrieNode root = new TrieNode();

    // Private constructor
    private Trie() {}
    public TrieNode getRoot() {
        return root;
    }
    public static Trie getInstance() {
        if (instance == null) {
            instance = new Trie();
        }
        return instance;
    }

    // Trie methods
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, k -> new TrieNode());
        }
        current.setEndOfWord(true);
    }


}