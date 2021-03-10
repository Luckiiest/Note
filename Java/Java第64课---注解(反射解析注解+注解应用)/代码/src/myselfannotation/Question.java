package myselfannotation;

public class Question {//实体对象 只有属性 公有的方法 无参数构造方法

    private String title;
    private String answer;

    @MyAnnotation({"1+1=?A.2B.3C.4D.5","A"})
    public Question(){}

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
