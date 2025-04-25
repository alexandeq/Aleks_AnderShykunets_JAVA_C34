package org.example;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args){

        int number = 5500000;

        int count;
        for(count = 0; number % 10 == 0; number /= 10) {
            ++count;
        }

        System.out.println("number of zeros: " + count);





        Scanner scanner1 = new Scanner(System.in);
        long value = scanner1.nextInt();
        long sum = 1;

        for(long i = 1; i <= value; ++i) {
            sum *= i;
        }

        System.out.println(sum);





        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter first number");

        double value1 = scanner2.nextInt();
        System.out.println("Please enter second number");

        double value2 = scanner2.nextInt();
        double sum1 = (value1 + value2) / 2.0;
        double sum2 = value1 + value2;

        System.out.println("Average:" + sum1);
        System.out.println("Sum:" + sum2);

    }
}
