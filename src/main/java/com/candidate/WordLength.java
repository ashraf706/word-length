package com.candidate;

import java.util.*;
import java.util.function.Predicate;

public class WordLength {
    private static final String ALPHA_NUMERIC = ".*\\w.*";
    private static final String WHITE_SPACE = " ";
    private static final Set<String> TO_FILTER = new HashSet<>(Arrays.asList("a", "A", "The", "the", "of", "and"));

    protected static final String WORD = "word";
    protected static final String LENGTH = "length";

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
                .max(stringComparator()).orElse(null);
    }

    private String shortestWord(String str){
        return Arrays.stream(str.split(WHITE_SPACE))
                .filter(wordFilter())
                .min(stringComparator()).orElse(null);
    }

    /**
     * Returns a simple length based string comparator
     */
    private Comparator<String> stringComparator() {
        return Comparator.comparingInt(String::length);
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
        if (input == null || !input.matches(ALPHA_NUMERIC)) {
            throw new IllegalArgumentException("Invalid argument. Argument cannot be empty or null. Argument must contain at least one valid alpha-numeric character.");
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

        if(str == null){
            result.put(WORD, "No valid word found");
            result.put(LENGTH, 0);
        }
        else {
            result.put(WORD, str);
            result.put(LENGTH, str.length());
        }

        return result;
    }
}
