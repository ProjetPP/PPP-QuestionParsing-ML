package com.ppp;

import edu.stanford.nlp.ling.HasWord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by quentin on 10/02/15.
 */
public class AnnotatedQuestion extends Question {
    private Map<String, Annotation> annotations;
    private Map<String, AnnotatorInfo> annotators_information;

    public AnnotatedQuestion(String s, List<? extends HasWord> tokens) {
        super(s, tokens);
        this.annotations = new HashMap<String, Annotation>();
        this.annotators_information = new HashMap<String, AnnotatorInfo>();
    }

    public void set_annotation(Annotator annotator) {
        this.annotations.put(
               annotator.get_name(), annotator.annotate(this.get_tokens()));

        this.annotators_information.put(
                annotator.get_name(), annotator.get_info());
    }
    public Map<String, Annotation> get_annotations() {
        return this.annotations;
    }
    public Map<String, AnnotatorInfo> get_annotators_info() {
        return annotators_information;
    }
    public void print() {
        super.print();
        for (String annotation_name : annotations.keySet()) {
            System.out.println(annotation_name + " " + annotations.get(annotation_name).view());
        }
    }
}