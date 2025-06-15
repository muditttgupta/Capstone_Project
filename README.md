# Capstone_Project
Object Oriented Programming (Java) based Quiz Management System Portal

✅Abstract of the Project:

The Quiz Management System is a Java-based desktop application designed to facilitate interactive quiz sessions for users and provide administrative control over user data and quiz content. Built using Java Swing for the GUI and standard I/O for data storage, the system allows users to log in, select a quiz difficulty (Easy, Medium, or Hard), and take a multiple-choice quiz with the assistance of a 50-50 lifeline feature.
All user login credentials and quiz scores are securely stored in text files, ensuring persistence across sessions. Users can also view their previous scores upon logging in. The admin login grants access to a dedicated Admin Panel, where all user data and quiz results can be reviewed, and quiz questions can be edited directly within the application interface.
The project adheres strictly to core Java concepts such as object-oriented programming, file handling, exception management, and GUI design using Swing. This ensures a simplified yet robust system architecture ideal for academic learning and demonstration purposes.



📂Project Structure:

QuizManagementSystem_Full/
    bin/
        (Generated after compilation; stores .class files)
    data/
        easy.txt – Easy level quiz questions
        medium.txt – Medium level quiz questions
        hard.txt – Hard level quiz questions
        users.txt – Stores usernames and passwords
        quiz_results.txt – Stores user quiz results
    src/
        Main.java – Main entry point of the application
        LoginGUI.java – GUI for user/admin login
        QuizGUI.java – Main quiz GUI, lifeline feature, handles question flow
        Question.java – Class representing a quiz question
        DBConnection.java - Using JDBC for database Connectivity
        Init.sql - Local Database for Project data
    README.txt (optional)
        Overview and instructions for using and compiling the project
