package com.ppp;

/**
 * Created by quentin on 03/03/15.
 */
public class AnnotatorInfo {
    private int size_vector;
    private double[] unknown_vector;
    public AnnotatorInfo(int size_vector, double[] unknown_vector) {
        this.size_vector = size_vector;
        this.unknown_vector = unknown_vector;
    }
    public int get_size_vector() {
        return size_vector;
    }
    public double[] get_unknown_vector() {
        return unknown_vector;
    }
}
