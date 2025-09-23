📘 Student Record Management System
📌 Objective

A simple CLI-based CRUD application in Java to manage student records (Add, View, Update, Delete).

🛠️ Tools & Requirements

Java JDK 8+

VS Code / IntelliJ CE / Terminal

Works on Windows, macOS, Linux

📂 Folder Structure
EL_Intern_Tasks/
 └── EL_Tasks/
      └── T2_StudentRecordManagementSystem/
           ├── Main.java
           ├── Student.java
           └── README.md

▶️ How to Compile & Run
1. With Package (Recommended ✅)

If your files have the line:

package T2_StudentRecordManagementSystem;


Then from the parent folder (EL_Tasks), run:

javac T2_StudentRecordManagementSystem/*.java
java T2_StudentRecordManagementSystem.Main

2. Without Package (Simpler 🟢)

If you remove/comment this line:

package T2_StudentRecordManagementSystem;


from both Main.java and Student.java → you can compile and run directly:

javac *.java
java Main

📋 Features

Add Student (ID, Name, Marks)

View all Students

Update Student (by ID)

Delete Student (by ID)

Exit program

📝 Example Run
--- Student Record Management System ---
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Choose an option: 1
Enter Student ID: 101
Enter Student Name: Naveen
Enter Student Marks: 88.5
Student added successfully!