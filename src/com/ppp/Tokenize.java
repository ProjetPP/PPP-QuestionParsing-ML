package com.ppp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 16/02/15.
 */

public class Tokenize {
    public static List<? extends HasWord> Tokenize(String sentence) {
        List<HasWord> tokens = new ArrayList<HasWord>();
        PTBTokenizer ptbt = new PTBTokenizer(new StringReader(sentence), new CoreLabelTokenFactory(), "");
        for (CoreLabel label; ptbt.hasNext(); ) {
            HasWord w = (HasWord) ptbt.next();
            tokens.add(w);
        }
        return tokens;
    }
}
