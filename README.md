##Requirements

- java 8 and following maven dependencies
- junit 5, hamcrest and maven-surefire-plugin

##Running the Tests
- To run the test execute `mvn test` from command line.
Please make sure you have the maven dependencies install in your local maven repository.
You can also execute `maven clean install` to make sure all the dependencies are in place.

##Assumption I made
- _getLongestWordAndLength_ returns the longest word and length. 
In case of multiple words the function returns the first longest word and its length.
- The function replaces '.', ';', ',' etc with white spaces and trim both beginning and end of the string.
- String with only multiple white spaces is considered as invalid string. 
- A word filter is in place to discard word such as 'a', 'and', 'the' ect. 
Words can be insert/delete from filter as necessary.
- The implementation followed java 8 recommendation rather than creating and maintaining 'for' loop by myself.
- Aso commit are not squashed intentionally.
