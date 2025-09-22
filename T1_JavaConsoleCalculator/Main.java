package T1_JavaConsoleCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Java Console Calculator ---");
        while(true){
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            if(choice == 5){
                System.out.println("Exiting.. Thank you!");
                break;
            }

            System.out.println("Enter first number: ");
            double n1 = sc.nextDouble();
            System.out.println("Enter second number: ");
            double n2 = sc.nextDouble();

            double result = 0;

            switch(choice){
                case 1:
                    result = add(n1, n2);
                    break;
                case 2:
                    result = sub(n1, n2);
                    break;
                case 3:
                    result = mult(n1, n2);
                    break;
                case 4:
                    result = div(n1, n2);
                    break;
                default:
                    System.out.println("Invaild choice! Please select a vaild operation.");
                    continue;
            }
            System.out.println("Result: "+ result);
        }
        sc.close();
    }

    public static double add(double num1, double num2){
        return num1 + num2;
    } 

    public static double sub(double num1, double num2){
        return num1 - num2;
    } 

    public static double mult(double num1, double num2){
        return num1 * num2;
    } 

    public static double div(double num1, double num2){
        if(num2 == 0){
            System.out.println("Division by zero is not allowed");
            return Double.NaN;
        }
        return num1 / num2;
    } 
}
