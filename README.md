##Requirements

- java 8 and following maven dependencies
- junit 5, hamcrest and maven-surefire-plugin

##Running the Tests
- To run the test execute `mvn test` from command line.
Please make sure you have the maven dependencies install in your local maven repository.
You can also execute `maven clean install` to make sure all the dependencies are in place.

##Assumption I made
- _getLongestWordAndLength_ in __com.candidate.WordLength__ class returns the longest word and length. 
In case of multiple longest words the function returns the first longest word and its length.
- The function replaces '.', ';', ',' etc with white spaces and trim both beginning and end of the sentence.
- Sentence with only multiple white spaces is considered as invalid string. 
- A word filter is in place to discard word such as 'a', 'and', 'the' ect. 
Words can be insert/delete from filter as necessary.
- The implementation followed java 8 recommendation rather than creating and maintaining 'for' loop by myself.
- Aso commit are not squashed intentionally.
- The __com.candidate.App__ class is a place holder and does not contribute to the exercise. 
