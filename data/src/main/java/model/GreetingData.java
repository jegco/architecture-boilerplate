package model;

public class GreetingData {

    private long id;
    private String content;

    public GreetingData(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
