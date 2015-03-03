package com.ppp;

/**
 * Created by quentin on 16/02/15.
 */
public class WordOccurrence {
    private String word; private int occurrence;
    public WordOccurrence(String w, int n) {
        this.word = w.toLowerCase(); this.occurrence = n;
    }
    public WordOccurrence(String word_annotated) {
        String[] split_annotation = word_annotated.split("/");
        this.word = split_annotation[0].toLowerCase();

        if(split_annotation.length == 1) {
            this.occurrence = 1;
        }
        if(split_annotation.length == 2) {
            this.occurrence = Integer.valueOf(split_annotation[1]);
        }
    }
    public String get_word() { return this.word; }
    public int get_occurrence() { return this.occurrence; }

    @Override
    public String toString() {
        return "(" + this.word + ", " + Integer.toString(this.occurrence) + ")";
    }
    public Boolean equals(WordOccurrence w) {
        return w.get_occurrence() == this.occurrence && w.get_word().equals(this.word);
    }
}
