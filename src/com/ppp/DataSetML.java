package com.ppp;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by quentin on 12/02/15.
 */
public class DataSetML {
    List<double[]> input;
    List<Integer> output;

    public DataSetML() {
        this.input = new LinkedList<double[]>();
        this.output = new LinkedList<Integer>();
    }
    public void add_line(double[] line_vector, int corresponding_output) {
        input.add(line_vector);
        output.add(corresponding_output);
    }
}

