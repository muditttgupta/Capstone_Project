import java.util.*;

public class Quiz {

    private static final HashMap<Integer, Question> easyQuestions = new HashMap<>();
    private static final HashMap<Integer, Question> mediumQuestions = new HashMap<>();
    private static final HashMap<Integer, Question> hardQuestions = new HashMap<>();

    static {
        // Easy Questions
        easyQuestions.put(1, new Question("What is OOP?", new String[]{
                "Object Oriented Programming", "Only One Parameter", "Old Original Program", "Oriented Object Process"
        }, "Object Oriented Programming"));
        easyQuestions.put(2, new Question("Which is not a feature of Java?", new String[]{
                "Object-oriented", "Portable", "Low-level", "Secure"
        }, "Low-level"));
        easyQuestions.put(3, new Question("Which keyword is used to define a class in Java?", new String[]{
                "class", "Class", "define", "struct"
        }, "class"));
        easyQuestions.put(4, new Question("Which company developed Java?", new String[]{
                "Sun Microsystems", "Microsoft", "Apple", "Google"
        }, "Sun Microsystems"));
        easyQuestions.put(5, new Question("What extension do Java files have?", new String[]{
                ".java", ".jav", ".js", ".class"
        }, ".java"));

        // Medium Questions
        mediumQuestions.put(1, new Question("What is inheritance in Java?", new String[]{
                "Creating objects", "Hiding data", "Acquiring properties from another class", "Overloading methods"
        }, "Acquiring properties from another class"));
        mediumQuestions.put(2, new Question("Which method is a constructor?", new String[]{
                "MyClass()", "void MyClass()", "public int MyClass()", "MyClass(int x);"
        }, "MyClass()"));
        mediumQuestions.put(3, new Question("Which keyword is used to inherit a class?", new String[]{
                "extends", "inherits", "super", "this"
        }, "extends"));
        mediumQuestions.put(4, new Question("Which is used for abstraction?", new String[]{
                "Abstract class", "Object", "String", "Interface"
        }, "Abstract class"));
        mediumQuestions.put(5, new Question("Which of these supports multiple inheritance?", new String[]{
                "Interfaces", "Classes", "Constructors", "Objects"
        }, "Interfaces"));

        // Hard Questions
        hardQuestions.put(1, new Question("What is the use of the 'final' keyword?", new String[]{
                "To define a class", "To make a method static", "To prevent modification", "To create interface"
        }, "To prevent modification"));
        hardQuestions.put(2, new Question("Which class is used for character-based input?", new String[]{
                "FileReader", "FileInputStream", "Scanner", "BufferedInputStream"
        }, "FileReader"));
        hardQuestions.put(3, new Question("Which method starts a thread?", new String[]{
                "start()", "run()", "begin()", "execute()"
        }, "start()"));
        hardQuestions.put(4, new Question("Which exception is thrown when dividing by zero?", new String[]{
                "ArithmeticException", "NullPointerException", "IOException", "RuntimeException"
        }, "ArithmeticException"));
        hardQuestions.put(5, new Question("Which stream is used for writing characters?", new String[]{
                "FileWriter", "OutputStream", "BufferedWriter", "DataOutputStream"
        }, "FileWriter"));
    }

    public static Collection<Question> getQuestionsByLevel(String level) {
        switch (level.toLowerCase()) {
            case "easy":
                return easyQuestions.values();
            case "medium":
                return mediumQuestions.values();
            case "hard":
                return hardQuestions.values();
            default:
                return Collections.emptyList();
        }
    }
}
