package com.ppp;

import java.util.List;

/**
 * Created by quentin on 10/02/15.
 * Define the type Annotation.
 * view: return a list of String, in order to print easily the annotation of each word of the sentence
 * get_vectors: return a list of vector (one vector per words)
 */

public interface Annotation {
    public List<String> view();
    public List<double[]> get_vectors();//One vector per word of the sentence
}