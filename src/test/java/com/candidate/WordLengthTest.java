package com.candidate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.candidate.WordLength.LENGTH;
import static com.candidate.WordLength.WORD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordLengthTest {

    private WordLength wordLength;

    @BeforeEach
    void setup(){
        wordLength = new WordLength();
    }

    @Test()
    @DisplayName("Throws IllegalArgumentException for empty input string")
    public void shouldThrowExceptionForEmptyString() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    String emptyString = "";
                    wordLength.getLongestWordAndLength(emptyString);
                });
    }

    @Test()
    @DisplayName("Throws IllegalArgumentException for null input")
    public void shouldThrowExceptionForNullInput() {
        assertThrows(IllegalArgumentException.class,
                () -> wordLength.getLongestWordAndLength(null));
    }

    @Test
    @DisplayName("Throws IllegalArgumentException if input string contains only spaces")
    void shouldThrowExceptionForStringWitAllWhiteSpaces() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    String stringWithSpaces = "  ";

                    wordLength.getLongestWordAndLength(stringWithSpaces);
                });
    }

    @Test
    @DisplayName("A valid input string must contain at least one alpha-numeric char")
    void shouldThrowExceptionForStringWithoutAlphaNumericCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    String stringWithSpaces = ",;";

                    wordLength.getLongestWordAndLength(stringWithSpaces);
                });
    }

    @Test
    @DisplayName("Consider alpha-numeric characters as a word to calculate length")
    void shouldReturnStringAndLength() {
        String stringWithSpaces = " abc123;,";

        Map<String, Object> result = wordLength.getLongestWordAndLength(stringWithSpaces);

        assertThat(result.get(WORD), is("abc123"));
        assertThat(result.get(LENGTH), is(6));
    }

    @Test
    @DisplayName("Check function behaviour when string contains unexpected charters set")
    void shouldReturnStringAndLength1() {
        String stringWithSpaces = " hello;, world.";

        Map<String, Object> result = wordLength.getLongestWordAndLength(stringWithSpaces);

        assertThat(result.get(WORD), is("hello"));
        assertThat(result.get(LENGTH), is(5));
    }

    @Test
    @DisplayName("Returns longest word and length")
    void shouldReturnLongestWordAndLength() {
        String str = "The cow jumped over the moon.";

        Map<String, Object> result = wordLength.getLongestWordAndLength(str);

        assertThat(result.get(WORD), is("jumped"));
        assertThat(result.get(LENGTH), is(6));
    }

    @Test
    @DisplayName("Returns shortest word and length")
    void shouldReturnShortestWordAndLength() {
        String str = "The cow jumped over the moon.";

        Map<String, Object> result = wordLength.getShortestWordAndLength(str);

        assertThat(result.get(WORD), is("cow"));
        assertThat(result.get(LENGTH), is(3));
    }

    @Test
    @DisplayName("Function should be able to filter out 'the', 'The' , 'a', 'A', 'and', 'of' etc.")
    void shouldFilterWords() {
        String str = "A little black bird";

        Map<String, Object> result = wordLength.getShortestWordAndLength(str);

        assertThat(result.get(WORD), is("bird"));
        assertThat(result.get(LENGTH), is(4));
    }

    @Test
    @DisplayName("Shows message when input string does not contain a valid word")
    void shouldShowMessageWhenInputDoesNotContainValidWord() {
        String str = "The";

        Map<String, Object> result = wordLength.getShortestWordAndLength(str);

        assertThat(result.get(WORD), is("No valid word found"));
        assertThat(result.get(LENGTH), is(0));
    }
}
