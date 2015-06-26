# vowels-counter

Coding task:

 

Given the supplied text file (INPUT.TXT), write a Java program that loads all words and determines the average number of vowels per word grouped by: set of vowels present in a word and length of the word. Result should be written to the output file (OUTPUT.TXT).

 

Example:

 

INPUT

 

Platon made bamboo boats.

 

OUTPUT

 

({a, o}, 6) -> 2.5

({a, o}, 5) -> 2

({a, e}, 4) -> 2

# usage 
mvn clean install 

in catalog /target find vowels-counter.jar

java -jar vowels-counter C:\INPUT.TXT C:\OUTPUT.TXT


