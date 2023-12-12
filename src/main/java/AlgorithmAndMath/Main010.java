package src.main.java.AlgorithmAndMath;

import java.util.Scanner;


public class Main010 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextInt();
        long factorial = 1;
        for (long i = 1; i<= N; i++){
            factorial *= i;
        }
        System.out.println(factorial);
    }

}

