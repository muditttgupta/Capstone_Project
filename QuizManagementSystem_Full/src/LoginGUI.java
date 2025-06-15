import java.awt.*;
import java.io.*;
import java.util.Collection;
import javax.swing.*;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginGUI() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel name = new JLabel("Username:");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolion Baiti", Font.BOLD, 18));
        add(name);
        usernameField = new JTextField();
        usernameField.setBounds(735, 200, 300, 25);
        usernameField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(usernameField);

        JLabel password = new JLabel("Password:");
        password.setBounds(810, 150, 300, 20);
        password.setFont(new Font("Mongolion Baiti", Font.BOLD, 18));
        add(password);
        passwordField = new JPasswordField();
        passwordField.setBounds(735, 200, 300, 25);
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(735, 270, 120, 25);
        loginButton.setBackground(new Color(30, 144, 254));
        loginButton.setForeground(Color.BLACK);
        loginButton.addActionListener(e -> handleLogin());
        add(loginButton);
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        saveUserData(username, password);

        String[] levels = {"Easy", "Medium", "Hard"};
        String level = (String) JOptionPane.showInputDialog(this, "Choose difficulty:",
                "Level", JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]);

        if (level != null) {
            JOptionPane.showMessageDialog(this,
                "Quiz Instructions:\n\n"
                + "1. The quiz consists of 5 multiple-choice questions.\n"
                + "2. You can select one correct answer per question.\n"
                + "3. You have a 50-50 lifeline that removes two incorrect options.\n"
                + "4. The 50-50 lifeline can only be used once.\n"
                + "5. Your score will be saved after submission.\n"
                + "6. No time limit. Attempt at your own pace.\n\n"
                + "Good luck!",
                "Quiz Instructions", JOptionPane.INFORMATION_MESSAGE
            );

            Collection<Question> questionCollection = Quiz.getQuestionsByLevel(level.toLowerCase());
            Question[] questions = questionCollection.toArray(new Question[0]);
            new QuizGUI(questions, username);
            dispose();
        }
    }

    private void saveUserData(String username, String password) {
        try {
            File dir = new File("../data");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileWriter writer = new FileWriter("../data/user_data.txt", true);
            writer.write("Username: " + username + ", Password: " + password + "\n");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving user data");
            e.printStackTrace();
        }
    }
}
