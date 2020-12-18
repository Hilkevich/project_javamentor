package jmeducationplatform.javaCore.block3.task357;

public class TooLongTextAnalyzer implements TextAnalyzer {            //реализует интерфейс напрямую, без
                                                                      // наследования  KeywordAnalyzer, который его
    private int maxLength;                                            // реализует.

    public TooLongTextAnalyzer(int length) {
        this.maxLength = length;
    }

    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;    //если text длинее maxLength ( а она у нас
    }                                                                    //в main заявлена 40) вернет Label-TOO_LONG,
}                                                                        //нет- Label.OK (тернарная операция)
