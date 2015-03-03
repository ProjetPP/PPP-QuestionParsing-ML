package com.ppp;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by quentin on 10/02/15.
 */
public class POSAnnotator extends Annotator {
    private MaxentTagger tagger;

    public POSAnnotator() {
        this.tagger = new MaxentTagger(
                "edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");
    }
    @Override
    public String get_name() {
        return "POSAnnotator";
    }

    @Override
    public Annotation annotate(List<? extends HasWord> tokens) {
        List<TaggedWord> pos_tags =  this.tagger.apply(tokens);
        return new POSAnnotation(pos_tags, new LinkedList<double[]>());
    }

    @Override
    public AnnotatorInfo get_info() {
        return new AnnotatorInfo(0, new double[0]);
    }
}
