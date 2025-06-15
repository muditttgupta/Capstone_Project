# Capstone_Project
# 🎓 Quiz Management System Portal (Java OOP Desktop App)

A Java-based desktop application designed for managing and attempting quizzes with admin control, persistent user data, and GUI-based interactivity. Built with Java Swing and standard file I/O — ideal for learning core Java concepts.

---

## ✅ Abstract

The **Quiz Management System** is a Java Swing desktop application that allows users to log in, choose a quiz difficulty level (Easy, Medium, Hard), and take a multiple-choice quiz with a built-in **50-50 lifeline**. 

Key features include:
- User login with credential verification
- Quiz selection based on difficulty
- Real-time quiz interface with a lifeline feature
- Persistent storage of quiz scores and user data
- Admin access to view scores and edit questions
- Fully GUI-based (Java Swing) and file-handled storage (I/O)

> Built to demonstrate **Object-Oriented Programming**, **Exception Handling**, **File Handling**, **Multithreading**, and **GUI design using Swing**.

---

## 🧩 Features

- 🔑 Single login system for user & admin
- 📚 Difficulty levels: Easy, Medium, Hard
- 🎮 50-50 lifeline to remove two incorrect options
- 💾 User credentials and scores saved to files
- 📈 Users can view past performance
- 🛠 Admin Panel to view/edit users and questions
- 🧱 Clean modular design with core OOP principles

---

## 🗂 Project Structure

<pre> ``` QuizManagementSystem_Full/ │ ├── bin/ # Compiled .class files │ ├── data/ │ ├── easy.txt # Easy level questions │ ├── medium.txt # Medium level questions │ ├── hard.txt # Hard level questions │ ├── users.txt # User credentials │ └── quiz_results.txt # User scores │ ├── src/ │ ├── Main.java # Entry point │ ├── LoginGUI.java # Login screen │ ├── QuizGUI.java # Quiz logic and lifeline │ ├── Question.java # Question model │ ├── DBConnection.java # JDBC connection │ └── Init.sql # DB schema │ └── README.md # Project overview ``` </pre>
