package com.example.passwordgenerator;

import java.util.HashMap;
import java.util.Random;

public class Phrases {

    private HashMap<Integer, String> phraselib;
    private String specialChars = "!@#$%^&*()_+-=[]{}\\|;':\",./<>?";

    public Phrases() {
        this.phraselib = new HashMap<Integer, String>();
    }

    public void addPhrase(String phrase) {
        phraselib.put(phraselib.size(), phrase);
    }

    public String getPhrase() {
        Random r = new Random();
        int key = r.nextInt(phraselib.size());
        String phrase = phraselib.get(key);
        return phrase;
    }

    public String getPhrase(boolean leet, boolean camel) {
        String phrase = getPhrase();
        Random r = new Random();
        int passes = 0;
        int idx = 0;

        if (leet) {
            LeetSpeech ls = LeetSpeech.getInstance();
            do {
                idx = r.nextInt(2);
                char leetChar = ls.getLeet(phrase.charAt(passes));
                if (idx == 1) {
                    StringBuilder str = new StringBuilder(phrase);
                    str.setCharAt(passes, leetChar);
                    phrase = str.toString();
                }
                passes++;
            } while (passes < phrase.length());

        }

        if (camel) {
            passes = 0;
            idx = 0;
            do {
                idx = r.nextInt(2);
                if (!specialChars.contains(String.valueOf(phrase.charAt(passes)))) {
                    if (idx == 1) {
                        char c = phrase.toUpperCase().charAt(passes);
                        StringBuilder str = new StringBuilder(phrase);
                        str.setCharAt(passes, c);
                        phrase = str.toString();
                    }
                }
                passes++;
            } while (passes < phrase.length());
        }
        return phrase;
    }
}
