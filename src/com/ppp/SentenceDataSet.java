package com.ppp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.patterns.surface.Token;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by quentin on 02/02/15.
 */
public class SentenceDataSet {
    private List<AnnotatedQuestion> list_sentences = new ArrayList();

    public SentenceDataSet(List<String> sentences) {

        Annotator pos_annotator = new POSAnnotator();
        LookUpTableAnnotator lookup_annotator = new LookUpTableAnnotator();
        CapitalAnnotator capital_annotator = new CapitalAnnotator();

        for(String sentence: sentences) {
            List<? extends HasWord> tokens = Tokenize.Tokenize(sentence);
            AnnotatedQuestion q = new AnnotatedQuestion(sentence, tokens);
            q.set_annotation(pos_annotator);
            q.set_annotation(lookup_annotator);
            q.set_annotation(capital_annotator);
            this.list_sentences.add(q);
        }

    }

    public void print() {
        for(AnnotatedQuestion question: this.list_sentences) {
            question.print();
            System.out.println();
        }

    }
}
