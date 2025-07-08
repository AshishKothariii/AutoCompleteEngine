package com.example.autocomplete.service;

import com.example.autocomplete.model.SuggestionResponse;
import com.example.autocomplete.service.strategy.PrefixSuggestionStrategy;
import com.example.autocomplete.service.strategy.SuggestionStrategy;
import com.example.autocomplete.trie.Trie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoCompleteService {
    private final SuggestionStrategy suggestionStrategy;

    // Constructor injection
    public AutoCompleteService(Trie trie) {
        this.suggestionStrategy = new PrefixSuggestionStrategy(trie);
    }

    public SuggestionResponse getSuggestions(String prefix) {
        // Trim and validate input
        String cleanPrefix = prefix.trim().toLowerCase();

        if (cleanPrefix.isEmpty()) {
            return new SuggestionResponse(prefix, List.of());
        }

        return suggestionStrategy.getSuggestions(cleanPrefix);
    }
}