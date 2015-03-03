package com.ppp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by quentin on 10/02/15.
 */
public class VectorAnnotation implements Annotation {
    private List<double[]> vectors;
    private List<String> words;
    public VectorAnnotation(ArrayList<String> words, ArrayList<double[]> vectors) {
        this.vectors = vectors;
        this.words = words;
    }
    @Override
    public List<String> view() {
        List<String> r = new LinkedList<String>();
        for (int i = 0; i < vectors.size(); i++) {
            r.add(String.format("%s [%2.2f, ...]", this.words.get(i), this.vectors.get(i)[0]));
        }
        return r;
    }
    @Override
    public List<double[]> get_vectors() {
        return vectors;
    }
}
