package jmeducationplatform.javaCore.task24192;

public class Task24192 {

    public static void main(String[] args) {

        String roles[] = {"Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String textLines[] = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное " +
                "известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        printTextPerRole(roles, textLines);
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder result = new StringBuilder();

        for (int k = 0; k < roles.length; k++) {
            result.append("\n");
            result.append(roles[k] + ":" + "\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(roles[k] + ":")) {

                    result.append((i + 1) + ")" + textLines[i].replaceFirst(roles[k] + ":", "") + "\n");
                }
            }

        }
        System.out.println(result);
        return result.toString();    // перевели textSb из StringBuilder(а) в String. т.к вернуть нужно String.
    }
}
