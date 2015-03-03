package com.ppp;

import edu.stanford.nlp.ling.HasWord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by quentin on 10/02/15.
 */

public class LookUpTableAnnotator extends Annotator {
    private Map<String, double[]> dictionary = new HashMap<String, double[]>();
    private static String lookup_file = "embeddings-scaled.EMBEDDING_SIZE=25.txt";
    private AnnotatorInfo info;

    @Override
    public String get_name() {
        return "LookUpTableAnnotator";
    }

    public LookUpTableAnnotator() {
        this.set_info();
        String filename = this.lookup_file;

        BufferedReader reader = null;
        String line = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                scan_line(line);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scan_line(String line) {
        String[] split_line = line.split(" ");
        double[] vector = new double[split_line.length-1];
        for(int i = 1; i < split_line.length; i++) {
            vector[i-1] = Double.parseDouble(split_line[i]);
        }
        //If we have exactly the word in the dictionary, in lower case we use it in priority
        if(split_line[0].toLowerCase().equals(split_line[0])) {
            this.dictionary.put(split_line[0], vector);
        }
        else {
            this.dictionary.put(split_line[0].toLowerCase(), vector);
        }
    }

    @Override
    public VectorAnnotation annotate(List<? extends HasWord> tokens) {
        ArrayList<double[]> vectors = new ArrayList<double[]>();
        ArrayList<String> words = new ArrayList<String>();
        for(HasWord w: tokens) {
            String word = this.get_word(w.word());
            words.add(word);
            vectors.add(this.get_vector(word));
        }
        return new VectorAnnotation(words, vectors);
    }

    @Override
    public AnnotatorInfo get_info() {
        return this.info;
    }

    private void set_info() {
        this.info = new AnnotatorInfo(25, new double[25]);
    }

    private String get_word(String token) {
        String word = token.toLowerCase();
        if(word.equals("-lsb-") || word.equals("-lcb-") || word.equals("-lrb-")) {
            return "(";
        }
        else if(word.equals("-rsb-") || word.equals("-rcb-") || word.equals("-rrb-")) {
            return ")";
        }
        else if(this.isNumeric(word)) {
            return "3.6";
        }
        else if (this.dictionary.containsKey(word)) {
            return word;
        }
        else {
            return "*unknown*";
        }
    }

    private double[] get_vector(String word) {
        return this.dictionary.get(word);
    }

    private boolean isNumeric(String str)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

}
