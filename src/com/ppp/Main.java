package com.ppp;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        List<String> sentences = new ArrayList();
        sentences.add("What is the \"birth date\" of the first president of United States?");
        sentences.add("What a platypus you are?");
        sentences.add("Is 1/2x equals to 0.5?");
        sentences.add("QUENTIN, Victor, who are you and where do you live, really?");
        sentences.add("Integrate[Sin[x*y]+1, (x, 0, 1), {y, 0, x}]");
        sentences.add("x+31*4");

        LoadDataSet.LoadDataSet("AnnotatedQuestions.txt");

    }
}