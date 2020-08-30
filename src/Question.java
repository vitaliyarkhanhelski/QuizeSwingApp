public class Question {

    private String text;
    private String rightAnswer;

    public Question(String text, String rightAnswer) {
        this.text = text;
        this.rightAnswer = rightAnswer;
    }

    public String getText() {
        return text;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }
}
