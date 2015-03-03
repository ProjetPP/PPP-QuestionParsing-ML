package com.ppp;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by quentin on 03/03/15.
 */
public class VectorizedWindow {
    private double[] vector;

    public VectorizedWindow(AnnotatedQuestion question, int word_index, int window_size) {
        int size_vector = this.get_size_vector(question.get_annotators_info(), window_size);
        this.vector = new double[size_vector];
        this.fill_vector(question, word_index, window_size);
    }
    private int get_size_vector(Map<String, AnnotatorInfo> annotators_information, int window_size) {
        int size = 0;
        for(String key: annotators_information.keySet()) {
            size += annotators_information.get(key).get_size_vector();
        }
        return size * window_size;
    }

    private void fill_vector(AnnotatedQuestion question, int word_index, int window_size) {
        int index_vector = 0;
        for(String key: question.get_annotations().keySet()) {
            for(int i = word_index-window_size/2; i <= word_index + window_size/2; i++) {
                double v[];
                int length_v = question.get_annotators_info().get(key).get_size_vector();
                if(i < 0 || i >= question.get_tokens().size()) {
                    v = question.get_annotators_info().get(key).get_unknown_vector();
                }
                else {
                    v = question.get_annotations().get(key).get_vectors().get(i);
                }
                System.arraycopy(v, 0, this.vector, index_vector, length_v);
                index_vector += length_v;
            }
        }
    }
    public void view() {
        System.out.println(Arrays.toString(this.vector));
    }
    public double[] get() {
        return this.vector;
    }
}
