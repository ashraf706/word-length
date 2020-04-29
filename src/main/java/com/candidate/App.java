package com.candidate;

import java.util.Map;

public class App {
    public static void main( String[] args )
    {
        String str = "The cow jumped over the moon.";

        WordLength wordLength = new WordLength();
        Map<String, Object> result = wordLength.getLongestWordAndLength(str);

        System.out.println( "Longest word: " + result.get("word") );
        System.out.println( "Word length: " + result.get("length") );
    }
}
