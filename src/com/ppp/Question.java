package com.ppp;

import edu.stanford.nlp.ling.HasWord;

import java.util.List;

/**
 * Created by Quentin on 02/02/15.
 */

public class Question {
    private String sentence;
    private List<? extends HasWord> tokens;

    public Question(String s, List<? extends HasWord> tokens) {
        this.sentence = s;
        this.tokens = tokens;
    }

    public String get_sentence() {
        return this.sentence;
    }
    public List<? extends HasWord> get_tokens() { return this.tokens; }

    public void print() {
        System.out.println(sentence);
        System.out.println(tokens);
    }
}