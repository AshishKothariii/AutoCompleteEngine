package com.example.autocomplete;


import com.example.autocomplete.trie.Trie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AutocompleteApplication {

	// Sample word list (replace with your actual words)
	private static final List<String> WORD_LIST = Arrays.asList(
			"apple","app","as","ass","ask", "banana", "cat", "dog", "elephant",
			"car", "camel", "java", "python", "spring"
	);

	public static void main(String[] args) {
		SpringApplication.run(AutocompleteApplication.class, args);
	}

	@Bean
	public Trie trie() {
		Trie trie = Trie.getInstance();
		WORD_LIST.forEach(trie::insert);
		return trie;
	}

}