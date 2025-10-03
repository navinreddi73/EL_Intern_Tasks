package T8_QuizApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Question {
    String question;
    List<String> options;
    int correctAnswer;

    public Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

public class QuizApp {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Question List
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("1. What is the size of int in Java?",
                Arrays.asList("1. 2 bytes", "2. 4 bytes", "3. 8 bytes", "4. 16 bytes"), 2));
        questions.add(new Question("2. Which collection allows duplicates?",
                Arrays.asList("1. Set", "2. Map", "3. List", "4. Queue"), 3));
        questions.add(new Question("3. Who developed Java?",
                Arrays.asList("1. Microsoft", "2. Sun Microsystems", "3. Google", "4. Oracle"), 2));
        questions.add(new Question("4. Which keyword is used to inherit a class?",
                Arrays.asList("1. super", "2. extends", "3. implements", "4. this"), 2));
        questions.add(new Question("5. What is the default value of a boolean in Java?",
                Arrays.asList("1. true", "2. false", "3. null", "4. 0"), 2));
                
        int score = 0;
        System.out.println("=== Welcome to the Online Quiz App ===\n");
        // Iterate through questions
        for (Question q : questions) {
            System.out.println(q.question);
            for (String opt : q.options) {
                System.out.println(opt);
            }
            System.out.print("Enter your answer (1-4): ");
            int ans = sc.nextInt();

            if (q.isCorrect(ans)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct Answer is Option " + q.correctAnswer + "\n");
            }
        }
        // Final Result
        System.out.println("🎯 Quiz Over! Your Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("🏆 Excellent! Perfect Score!");
        } else if (score >= 3) {
            System.out.println("👍 Good Job!");
        } else {
            System.out.println("📖 Keep Practicing!");
        }
        sc.close();
    }
}
