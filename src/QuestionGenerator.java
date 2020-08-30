import java.util.ArrayList;
import java.util.List;

public class QuestionGenerator {

    public List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Czy Java jest statycznie typowana?","Tak"));
        questions.add(new Question("10/3== ?", "3"));
        questions.add(new Question("Czy Java ma wartość ... ?","Null"));
        questions.add(new Question("Co jest klasą?","Integer"));
        questions.add(new Question("Jak porównujemy String?","equals()"));

        return questions;
    }
}
