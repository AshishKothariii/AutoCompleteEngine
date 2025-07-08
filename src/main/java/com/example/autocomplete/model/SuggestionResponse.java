package com.example.autocomplete.model;


import java.util.List;

public class SuggestionResponse {
    private final String prefix;
    private final List<String> suggestions;
    private final int count;

    public SuggestionResponse(String prefix, List<String> suggestions) {
        this.prefix = prefix;
        this.suggestions = suggestions;
        this.count = suggestions.size();
    }

    // Getters only (immutable)
    public String getPrefix() {
        return prefix;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public int getCount() {
        return count;
    }
}