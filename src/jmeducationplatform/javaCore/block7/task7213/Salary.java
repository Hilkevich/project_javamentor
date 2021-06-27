package jmeducationplatform.javaCore.block7.task7213;

public class Salary implements Sendable<Integer> {

    private String from;
    private String to;
    private Integer content;

    public Salary(String from, String to, Integer content) {

        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getContent() {
        return content;
    }
}
