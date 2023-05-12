package ts6;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.*;

public class SpelChecker {
    private Set<String> words;

    public SpelChecker(Set<String> words) {
        this.words = words;
    }
    //swap characters in the array
    public static void change(char[] chrar, int i, int j) {
        char temp = chrar[i];
        chrar[i] = chrar[j];
        chrar[j] = temp;
    }

    public List<String> check(String s) {
    	//create list to store correctly spelled words
    	List<String> correct=new ArrayList<>();
    	//create list to store incorrect words
        List<String> guesser = new ArrayList<>();
        

        // check if s is in words
        if (words.contains(s)) {
            correct.add(s);
            return correct;
        }

        // check if s is a misspelling of any word in words
        for (String word : words) {
            // check for adjacent character swap
            for (int i = 0; i < word.length() - 1; i++) {
                char[] charswap = word.toCharArray();
                change(charswap,i,i+1);
//                char temp = swapped[i];
//                swapped[i] = swapped[i + 1];
//                swapped[i + 1] = temp;
                String wordsw = new String(charswap);
                if (wordsw.equals(s)) {
                	guesser.add(word);
                }
            }

            // check for single character insertion
            for (int i = 0; i <= word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String insertedWord = word.substring(0, i) + c + word.substring(i);
                    if (insertedWord.equals(s)) {
                    	guesser.add(word);
                    }
                }
            }

            // check for single character deletion
            for (int i = 0; i < word.length(); i++) {
//                String deletedWord = word.substring(0, i) + word.substring(i + 1);
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String dellet = sb.toString();
                if (dellet.equals(s)) {
                	guesser.add(word);
                }
            }
            
            // check for single character replacement
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String replacedWord = word.substring(0, i) + c + word.substring(i + 1);
                    if (replacedWord.equals(s)) {
                    	guesser.add(word);
                    }
                }
            }
        }

        return guesser;
    }

    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        words.add("hello");
        words.add("world");
        words.add("java");
        words.add("programming");
        words.add("is");
        words.add("fun");

        SpelChecker spellChecker = new SpelChecker(words);

        // test spell checker
        String[] testCases = {"helo", "worl", "jav", "prograaming", "iss","fun"};
        for (String s : testCases) {
            List<String> checker = spellChecker.check(s);
            if (checker.size() == 0 ) {
                System.out.println(s + " is spelled correctly!");
            } else {
                System.out.println("Did you mean:");
                for (String ch : checker) {
                    System.out.println("- " + ch);
                }
            }
            System.out.println();
        }
    }
}



