import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {

    public List<Answer> generateAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("Tak","Nie","Chyba raczej"));
        answers.add(new Answer("2","3","4"));
        answers.add(new Answer("Nil","Nol","Null"));
        answers.add(new Answer("int","Integer","boolean"));
        answers.add(new Answer("==","=","equals()"));

        return answers;
    }
}
