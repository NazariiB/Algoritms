package org.example.algotitm;

public class RabinKarp {
    private final int maxAmountOfCharacters = 256;
    private final int randNum = 101;

    public void match(String pattern, String text) {
        long startTime = System.currentTimeMillis();
        if(pattern.length() > text.length()) {
            return;
        }

        int patternLength = pattern.length();
        int textLength = text.length();

        int patternHash = getHash(pattern);
        int textHash = getHash(text.substring(0, patternLength));

        int constant = 1;
        for(int i = 0; i < patternLength - 1; i++) {
            constant = (constant * maxAmountOfCharacters) % randNum;
        }
        int numberOfMatching = 0;
        for(int i = 0; i < textLength - patternLength + 1; i++ ) {
            if(textHash == patternHash) {
                int counter = 0;
                for(int j = 0; j < patternLength; j++) {
                    if(text.charAt(i + j) == pattern.charAt(j)){
                        counter++;
                    }
                }
                if(counter == patternLength ) {
                    numberOfMatching++;
                }
            }
            if(i < textLength - patternLength) {
                textHash = (maxAmountOfCharacters * (textHash - text.charAt(i) * constant) + text.charAt( i + patternLength)) % randNum;

                if(textHash < 0) {
                    textHash += randNum;
                }
            }
        }
        System.out.println("matching word " + pattern + " " + numberOfMatching + " times");
        long stopTime = System.currentTimeMillis();
        System.out.println("time " + (stopTime - startTime));
    }

    public int getHash(String string) {
        int result = 0;
        for(int i = 0; i < string.length(); i++) {
            result = (maxAmountOfCharacters * result + string.charAt(i)) % randNum;
        }
        return result;
    }
}
