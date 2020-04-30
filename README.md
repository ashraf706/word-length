##Requirements

- java 8 and following maven dependencies
- junit 5, hamcrest and maven-surefire-plugin

##Running the Tests
- Execute `git clone https://github.com/ashraf706/word-length.git` to clone the public repository to your local machine.
- From command line change directory and go to the downloaded __word-length__ directory. 
- To run the test execute `mvn test` from command line.
This should execute all tests in  __com.candidate.WordLengthTest__ under test package.
Please make sure you have the maven dependencies install in your local maven repository in case you have problem running the tests.
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
