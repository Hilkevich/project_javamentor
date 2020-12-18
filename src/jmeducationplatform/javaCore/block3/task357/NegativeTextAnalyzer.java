package jmeducationplatform.javaCore.block3.task357;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords = {":(", "=(", ":|"};
    private Label label = Label.NEGATIVE_TEXT;

    protected String[] getKeywords() {
        return keywords;
    }

    protected Label getLabel() {
        return label;
    }
}

