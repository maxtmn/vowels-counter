# vowels-counter

Java program that loads all words and determines the average number of vowels per word.
Result is written to the output file. 

Example: 

INPUT

The time traveller.


OUTPUT 

({a, e}, 9) -> 3.0,
({e, i}, 4) -> 2.0,
({e}, 3) -> 3.0

# usage 
mvn clean install 

in catalog /target find vowels-counter.jar

java -jar vowels-counter.jar C:\INPUT.TXT C:\OUTPUT.TXT


