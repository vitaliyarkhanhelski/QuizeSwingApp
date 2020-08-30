import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    private QuestionGenerator questionGenerator = new QuestionGenerator();
    private List<Question> questionList = questionGenerator.generateQuestions();
    private AnswerGenerator answerGenerator = new AnswerGenerator();
    private List<Answer> answerList = answerGenerator.generateAnswers();
    private int currentQuestion = 0;
    private int points = 0;
    private JLabel label;
    private JButton firstButton, secondButton, thirdButton;

    public Main() {
        Font font = new Font("Monaco", Font.BOLD, 22);
        label = new JLabel(questionList.get(0).getText(), SwingConstants.CENTER);
        label.setFont(font);
        firstButton = new JButton(answerList.get(0).getAnswer1());
        firstButton.setFont(font);
        secondButton = new JButton(answerList.get(0).getAnswer2());
        secondButton.setFont(font);
        thirdButton = new JButton(answerList.get(0).getAnswer3());
        thirdButton.setFont(font);
        setLayout(new GridLayout(2, 1));
        add(label);
        Container container = new Container();
        container.setLayout(new GridLayout(1, 3));
        container.add(firstButton);
        container.add(secondButton);
        container.add(thirdButton);
        add(container);
        setSize(500, 500);
        setTitle("Quiz");
        setDefaultCloseOperation(3);
        setVisible(true);
        firstButton.addActionListener(this);
        secondButton.addActionListener(this);
        thirdButton.addActionListener(this);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentQuestion + 1 <= questionList.size()) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
           if (buttonText.equals(questionList.get(currentQuestion).getRightAnswer())) {
               points++;
               System.out.println(points);
           }
            currentQuestion++;
            if (currentQuestion != questionList.size()) {
                label.setText(questionList.get(currentQuestion).getText());
                firstButton.setText(answerList.get(currentQuestion).getAnswer1());
                secondButton.setText(answerList.get(currentQuestion).getAnswer2());
                thirdButton.setText(answerList.get(currentQuestion).getAnswer3());
            } else {
                Icon i = new ImageIcon("/Users/vitaliyarkhanhelski/Desktop/win.png");
                label.setIcon(i);
                setTitle("End of Game");
                firstButton.setEnabled(false);
                firstButton.setText("END");
                secondButton.setEnabled(false);
                secondButton.setText("OF");
                thirdButton.setEnabled(false);
                thirdButton.setText("GAME");
                label.setText("Koniec Gry");
                final ImageIcon icon = new ImageIcon("/Users/vitaliyarkhanhelski/Desktop/victory.png");
                JOptionPane.showMessageDialog
                        (this, "End of Game!\nYour score is: " + points,
                                "Score", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }
}
