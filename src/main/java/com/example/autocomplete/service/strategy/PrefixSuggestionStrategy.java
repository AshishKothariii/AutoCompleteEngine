package com.example.autocomplete.service.strategy;

import com.example.autocomplete.model.SuggestionResponse;
import com.example.autocomplete.trie.Trie;
import com.example.autocomplete.trie.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class PrefixSuggestionStrategy implements SuggestionStrategy {
    private final Trie trie;

    public PrefixSuggestionStrategy(Trie trie) {
        this.trie = trie;
    }

    @Override
    public SuggestionResponse getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        TrieNode node = findPrefixNode(prefix.toLowerCase());
        if (node != null) {
            collectWords(node, prefix.toLowerCase(), suggestions);
        }
        return new SuggestionResponse(prefix, suggestions);
    }

    private TrieNode findPrefixNode(String prefix) {
        TrieNode current = trie.getRoot();  // Access root through the Trie instance
        for (char c : prefix.toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                return null;
            }
            current = current.getChildren().get(c);
        }
        return current;
    }

    private void collectWords(TrieNode node, String currentWord, List<String> suggestions) {
        if (node.isEndOfWord()) {
            suggestions.add(currentWord);
        }
        node.getChildren().forEach((c, child) ->
                collectWords(child, currentWord + c, suggestions));
    }
}