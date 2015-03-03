package com.ppp;

import edu.stanford.nlp.ling.HasWord;

import java.util.List;

/**
 * Created by quentin on 10/02/15.
 */
public abstract class Annotator {
    abstract public String get_name();
    abstract public Annotation annotate(List<? extends HasWord> tokens);
    abstract public AnnotatorInfo get_info();
}