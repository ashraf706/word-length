package com.candidate;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;

/**
 * Hello world!
 *
 */
public class WordLength
{
    private static final String ALPHA_NUMERIC = ".*\\w.*";
    private static final String WHITE_SPACE = " ";

    public static final String WORD = "word";
    public static final String LENGTH = "length";

    public Map<String, Object> getLongestWordAndLength(String input) {
        validate(input);
        String sanitizedInput = sanitise(input);

        String str = Arrays.stream(sanitizedInput.split(WHITE_SPACE))
                .max( Comparator.comparingInt(String::length) )
                .orElse(null);

        HashMap<String, Object> result = new HashMap<>();
        result.put(WORD, str);
        result.put(LENGTH, str.length());
        return result;
    }

    /**
     *
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
     * @param input String
     */
    private void validate(String input){
        if(!input.matches(ALPHA_NUMERIC)){
            throw new IllegalArgumentException("Invalid argument. Input string cannot be empty.");
        }
    }
}
