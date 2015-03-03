package com.ppp;

import edu.stanford.nlp.ling.HasWord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by quentin on 19/02/15.
 */
public class LoadDataSet {
    public static void LoadDataSet(String data_set_file) {
        LookUpTableAnnotator lookup_annotator = new LookUpTableAnnotator();
        CapitalAnnotator capital_annotator = new CapitalAnnotator();

        DataSetML data_set = new DataSetML();

        BufferedReader reader = null;
        String question = null;
        String annotation = null;

        try {
            reader = new BufferedReader(new FileReader(data_set_file));
            while ((question = reader.readLine()) != null) {
                annotation = reader.readLine();
                reader.readLine();

                List<? extends HasWord> tokens = Tokenize.Tokenize(question);
                AnnotatedQuestion q = new AnnotatedQuestion(question, tokens);
                q.set_annotation(lookup_annotator);
                q.set_annotation(capital_annotator);

                ClassificationOutput cl_sentence = new ClassificationOutput(tokens, annotation);
                List<Integer> cl = cl_sentence.get_classification();

                for(int w = 0; w < tokens.size(); w++) {
                    VectorizedWindow v_window = new VectorizedWindow(q, w, 5);
                    data_set.add_line(v_window.get(), cl.get(w));
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("ok");
    }
}
