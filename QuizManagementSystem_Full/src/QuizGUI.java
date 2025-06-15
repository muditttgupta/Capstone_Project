import java.awt.*;
import java.io.*;
import java.util.Collection;
import javax.swing.*;

public class QuizGUI extends JFrame {
    private Question[] questions;
    private String username;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private boolean lifelineUsed = false;

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private JButton nextButton;
    private JButton lifelineButton;
    private ButtonGroup optionsGroup;

    public static void startQuiz(String username, int level) {
        String instructions = "Quiz Instructions:\n"
                + "1. Select the correct option for each question.\n"
                + "2. Use the '50-50 Lifeline' to eliminate two wrong options.\n"
                + "3. Your score will be saved at the end.\n"
                + "4. Click 'Submit' to finish the quiz.\n";

        JOptionPane.showMessageDialog(null, instructions, "Quiz Instructions", JOptionPane.INFORMATION_MESSAGE);
        new QuizGUI(username, level);
    }

    public QuizGUI(String username, int level) {
        Collection<Question> questionCollection = Quiz.getQuestionsByLevel(level == 1 ? "easy" : level == 2 ? "medium" : "hard");
        this.questions = questionCollection.toArray(new Question[0]);
        this.username = username;

        setupGUI();
    }

    public QuizGUI(Question[] questions, String username) {
        this.questions = questions;
        this.username = username;
        setupGUI();
    }

    private void setupGUI() {
        setTitle("Quiz");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        questionLabel = new JLabel("Question");
        centerPanel.add(questionLabel);

        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionsGroup.add(optionButtons[i]);
            centerPanel.add(optionButtons[i]);
        }

        add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> nextQuestion());
        buttonPanel.add(nextButton);

        lifelineButton = new JButton("50-50 Lifeline");
        lifelineButton.addActionListener(e -> useLifeline());
        buttonPanel.add(lifelineButton);

        add(buttonPanel, BorderLayout.SOUTH);

        showQuestion();
        setVisible(true);
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.length) {
            Question q = questions[currentQuestionIndex];
            questionLabel.setText("Q" + (currentQuestionIndex + 1) + ": " + q.getQuestionText());
            String[] options = q.getOptions();

            for (int i = 0; i < optionButtons.length; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setVisible(true);
            }

            optionsGroup.clearSelection();
        } else {
            finishQuiz();
        }
    }

    private void nextQuestion() {
        Question q = questions[currentQuestionIndex];
        String selected = null;

        for (JRadioButton rb : optionButtons) {
            if (rb.isSelected()) {
                selected = rb.getText();
                break;
            }
        }

        if (selected != null && selected.equals(q.getCorrectAnswer())) {
            score++;
        }

        currentQuestionIndex++;
        lifelineButton.setEnabled(!lifelineUsed);
        showQuestion();
    }

    private void useLifeline() {
        if (!lifelineUsed && currentQuestionIndex < questions.length) {
            Question q = questions[currentQuestionIndex];
            String correct = q.getCorrectAnswer();
            int removed = 0;

            for (int i = 0; i < optionButtons.length && removed < 2; i++) {
                if (!optionButtons[i].getText().equals(correct)) {
                    optionButtons[i].setVisible(false);
                    removed++;
                }
            }

            lifelineUsed = true;
            lifelineButton.setEnabled(false);
        }
    }

    private void finishQuiz() {
        JOptionPane.showMessageDialog(this, "Quiz finished! Your score: " + score + "/" + questions.length);
        saveResult(score, questions.length);
        dispose();
    }

    private void saveResult(int score, int total) {
        try {
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }
            File resultFile = new File("../data/quiz_results.txt");
            FileWriter writer = new FileWriter(resultFile, true);
            writer.write("User: " + username + ", Score: " + score + "/" + questions.length + "\n");
            writer.close();

            JOptionPane.showMessageDialog(this, "Quiz results saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving quiz results: " + e.getMessage());
        }
    }
}
