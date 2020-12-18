package jmeducationplatform.javaCore.block3.task357;

abstract class KeywordAnalyzer implements TextAnalyzer {          // абстрактный класс реализующий интерфейс.

    abstract protected String[] getKeywords();                    // protected - видны только для наследников.

    abstract protected Label getLabel();

    public Label processText(String text) {   // метод из интерфейса.его реализация. 100% ДОЛЖЕН БЫТЬ и именно здесь!,
        String[] keywords = getKeywords();     // чтоб раздать классам наследникам KeywordAnalyzer (негативу и спаму).
        for (int i = 0; i < keywords.length; i++) {
            if (text.indexOf(keywords[i]) != -1) {   // indexOf-возвращает индекс строки если найдена или -1
                return getLabel();                   // если подстрока не найдена. т.е здесь если в text есть что то из
            }                                        // keywords(":(".., более 40 длина или spam или bad, пометит
        }                                            // конкретным Label( BAD,SPAM..), нет пометит Label OK.
        return Label.OK;
    }
}

