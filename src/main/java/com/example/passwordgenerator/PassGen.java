package com.example.passwordgenerator;

import java.util.Random;

public class PassGen {
    private final String specialChars = "!@#$%^&*()_+-=[]{}\\|;':\",./<>?";
    private Phrases p;
    private Random r;

    public PassGen() {
        this.r = new Random();
        this.p = new Phrases();
    }


    public String getPassword(int min_len, int nums, boolean specs,char upper, boolean leet) {
        String pass = new String();
        String phrase = new String();
        LeetSpeech ls = LeetSpeech.getInstance();
        char c;

        do {
            if (upper == 'R') {
                pass = pass.concat(p.getPhrase(leet, true));
            } else if (upper == 'S') {
                phrase = p.getPhrase(leet, false);
                c = phrase.charAt(0);
                if (specialChars.contains(String.valueOf(c))) {
                    c = ls.getChar(c);
                }
                c = Character.toUpperCase(c);
                StringBuilder str = new StringBuilder(phrase);
                str.setCharAt(0, c);
                phrase = str.toString();
                pass = pass.concat(phrase);
            } else if (upper == 'E') {
                phrase = p.getPhrase(leet, false);
                c = phrase.charAt(phrase.length() - 1);
                if (specialChars.contains(String.valueOf(c))) {
                    c = ls.getChar(c);
                }
                c = Character.toUpperCase(c);
                StringBuilder str = new StringBuilder(phrase);
                str.setCharAt((phrase.length() - 1), c);
                phrase = str.toString();
                pass = pass.concat(phrase);
            }

        } while (pass.length() < min_len);

        int i = 0;
        int idx = 0;
if (specs){
        idx = r.nextInt(specialChars.length());
        pass = pass.concat(String.valueOf(specialChars.charAt(idx)));
    }
        do {
            idx = r.nextInt(10);
            pass = pass.concat(String.valueOf(idx));
            i++;
        }while (i < nums);

        return pass;
    }

    public void addPhrase(String phrase) {
        p.addPhrase(phrase);
    }

    public void removePhrase(String phrase) {
        p.removePhrase(phrase);
    }
}