package com.ppp;

import edu.stanford.nlp.ling.HasWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 11/02/15.
 */
public class CapitalAnnotator extends Annotator {
    private AnnotatorInfo info;

    public CapitalAnnotator() {
        this.set_info();
    }

    @Override
    public String get_name() {
        return "CapitalAnnotator";
    }

    @Override
    public Annotation annotate(List<? extends HasWord> tokens) {
        ArrayList<String> words_representation = new ArrayList<String>();
        ArrayList<double[]> vectors = new ArrayList<double[]>();
        for(HasWord word: tokens) {
            String annotation = this.annotate_word(word.word());
            words_representation.add(annotation);
            vectors.add(this.vector_representation(annotation));
        }
        return new VectorAnnotation(words_representation, vectors);

    }

    @Override
    public AnnotatorInfo get_info() {
        return this.info;
    }

    private void set_info() {
        this.info = new AnnotatorInfo(2, new double[2]);
    }

    private String annotate_word(String word) {
        if(Character.isUpperCase(word.charAt(0))) {
            if(word.toUpperCase().equals(word)) {
                return "UpperCase";
            }
            else {
                return "CapitalFirstLetter";
            }
        }
        else {
            return "LowerCase";
        }
    }

    private double[] vector_representation(String annotation) {
        double[] v = new double[2];
        v[0] = 0; v[1] = 0;
        if(annotation.equals("UpperCase")) {
            v[0] = 1; v[1] = 1;
        }
        else if(annotation.equals("CapitalFirstLetter")) {
            v[0] = 1;
        }
        return v;
    }

}
