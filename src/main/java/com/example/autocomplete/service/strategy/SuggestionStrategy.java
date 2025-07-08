package com.example.autocomplete.service.strategy;

import com.example.autocomplete.model.SuggestionResponse;

public interface SuggestionStrategy {
    SuggestionResponse getSuggestions(String input); // Changed return type
}