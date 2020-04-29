package com.candidate;

import java.util.*;
import java.util.function.Predicate;

/**
 * Hello world!
 */
public class WordLength {
    private static final String ALPHA_NUMERIC = ".*\\w.*";
    private static final String WHITE_SPACE = " ";
    private static final Set<String> TO_FILTER = new HashSet<>(Arrays.asList("a", "A", "The", "the", "of", "and"));

    public static final String WORD = "word";
    public static final String LENGTH = "length";

    public Map<String, Object> getLongestWordAndLength(String input) {
        validate(input);
        String sanitizedInput = sanitise(input);

        return createResultObject(largestWord(sanitizedInput));
    }

    public Map<String, Object> getShortestWordAndLength(String input) {
        validate(input);
        String sanitizedInput = sanitise(input);

        return createResultObject(shortestWord(sanitizedInput));
    }

    private String largestWord(String str){
        return Arrays.stream(str.split(WHITE_SPACE))
                .filter(wordFilter())
                .max(Comparator.comparingInt(String::length)).get();
    }

    private String shortestWord(String str){
        return Arrays.stream(str.split(WHITE_SPACE))
                .filter(wordFilter())
                .min(Comparator.comparingInt(String::length)).get();
    }

    /**
     * A predicate to check whether the set TO_FILTER contains a word or not
     */
    private Predicate<String> wordFilter() {
        return s -> !TO_FILTER.contains(s);
    }

    /**
     * @param input String
     * @return String contains only alpha numeric characters
     * and white spaces among words
     */
    private String sanitise(String input) {
        return input.replaceAll("[^A-Za-z0-9 ]", "").trim();
    }

    /**
     * Validate an input string by making sure that the string contains at least one
     * alpha-numeric character. Throws IllegalArgumentException otherwise.
     *
     * @param input String
     */
    private void validate(String input) {
        if (!input.matches(ALPHA_NUMERIC)) {
            throw new IllegalArgumentException("Invalid argument. Input string cannot be empty.");
        }
    }

    /**
     * Create a HashMap with a given string and length
     *
     * @param str a valid string
     * @return HashMap instance
     */
    private Map<String, Object> createResultObject(String str) {
        HashMap<String, Object> result = new HashMap<>();

        result.put(WORD, str);
        result.put(LENGTH, str.length());
        return result;
    }
}
