package com.ppp;

import edu.stanford.nlp.ling.TaggedWord;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by quentin on 10/02/15.
 */
public class POSAnnotation implements Annotation {
    private List<TaggedWord> pos_tags;
    private List<double[]> vectors;

    public POSAnnotation(List<TaggedWord> l, List<double[]> v) {
        this.pos_tags = l;
        this.vectors = v;
    }
    @Override
    public List<String> view() {
        List<String> r = new LinkedList<String>();
        for(TaggedWord w: this.pos_tags) {
            r.add(w.tag());
        }
        return r;
    }

    @Override
    public List<double[]> get_vectors() {
        return this.vectors;
    }

}
