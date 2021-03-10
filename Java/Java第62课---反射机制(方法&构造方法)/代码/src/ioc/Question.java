package ioc;

public class Question {

    private String title;//题干
    private String answer;//答案

    public Question() {}
    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public String toString(){
        return "{"+title+","+answer+"}";
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
