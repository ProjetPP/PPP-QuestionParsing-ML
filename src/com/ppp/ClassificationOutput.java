package com.ppp;

import edu.stanford.nlp.ling.HasWord;

import java.util.*;

/**
 * Created by quentin on 16/02/15.
 */
public class ClassificationOutput {

    List<WordOccurrence> subject;
    List<WordOccurrence> predicate;
    List<WordOccurrence> object;
    List<WordOccurrence> question;

    public ClassificationOutput(List<? extends HasWord> tokens_question, String annotation) {

        String[] split_annotation = annotation.split("\\|");

        this.subject = this.parse_field(split_annotation[0]);
        this.predicate = this.parse_field(split_annotation[1]);
        this.object = this.parse_field(split_annotation[2]);

        this.question = this.occurrences_sentence(tokens_question);


    }

    public List<Integer> get_classification() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(WordOccurrence w: this.question) {
            result.add(this.get_word_field(w));
        }
        return result;
    }

    private List<WordOccurrence> parse_field(String s) {
        List<WordOccurrence> r = new LinkedList<WordOccurrence>();
        for(HasWord w: Tokenize.Tokenize(s)) {
            r.add(new WordOccurrence(w.word()));
        }
        return r;
    }

    private List<WordOccurrence> occurrences_sentence(List<? extends HasWord> tokens) {
        List<WordOccurrence> r = new ArrayList<WordOccurrence>();
        Map<String, Integer> occurrences = new HashMap<String, Integer>();
        for(HasWord w: tokens) {
            if(occurrences.containsKey(w.word())) {
                occurrences.replace(w.word(), 1 + occurrences.get(w.word()));
                r.add(new WordOccurrence(w.word(), occurrences.get(w.word())));
            }
            else {
                occurrences.put(w.word(), 1);
                r.add(new WordOccurrence(w.word(), 1));
            }
        }
        return r;
    }

    private Boolean is_word_in_field(WordOccurrence word, List<WordOccurrence> field) {
        for(WordOccurrence w:field) {
            if(w.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private int get_word_field(WordOccurrence w) {
        if(this.is_word_in_field(w, this.subject)) {
            return 1;
        }
        else if(this.is_word_in_field(w, this.predicate)) {
            return 2;
        }
        else if(this.is_word_in_field(w, this.object)) {
            return 3;
        }
        else {
            return 0;
        }
    }


}
