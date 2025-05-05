package com.example.passwordgenerator;

import java.util.HashMap;

public class LeetSpeech {

    private static LeetSpeech ls = null;

    private HashMap<Character, Character> leetmap;
    private HashMap<Character, Character> charmap;

    public static  synchronized LeetSpeech getInstance() {

        if (ls == null){
            ls = new LeetSpeech();
        }
        return ls;
    }

    private LeetSpeech()
    {
        this.leetmap = new HashMap<>();
        this.charmap = new HashMap<>();
        leetmap.put('a', '@');
        leetmap.put('h', '#');
        leetmap.put('l', '1');
        leetmap.put('o', '0');
        leetmap.put('s', '$');
        leetmap.put('t', '+');

        charmap.put('@', 'a');
        charmap.put('#', 'h');
        charmap.put('1', 'l');
        charmap.put('0', 'o');
        charmap.put('$', 's');
        charmap.put('+', 't');
    }

    public char getLeet(char in)
    {
        Character out = leetmap.get(in);
        if (out == null)
        {
            out = in;
        }
        return out;
    }

    public char getChar(char in)
    {
        Character out = charmap.get(in);
        if (out == null)
        {
            out = in;
        }
        return out;
    }

}
