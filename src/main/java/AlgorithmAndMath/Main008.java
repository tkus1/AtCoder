package src.main.java.AlgorithmAndMath;

import java.util.Scanner;


public class Main008 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int cnt = 0;
        for (int i = 1; i<= N; i++){
            for (int j = 1; j <= N; j++){
                if(i + j <= S){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}

