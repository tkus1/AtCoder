package src.main.java.AlgorithmAndMath;

import java.util.ArrayList;
import java.util.Scanner;

public class Main039 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        long[] snowHeight = new long[N+1];
        for (int i = 0; i < N + 1; i++) {
            snowHeight[i]=0;
        }
        int[] L = new int[Q];
        int[] R = new int[Q];
        int[] snowFall = new int[Q];
        for (int i = 0; i < Q; i++) {
            L[i] = scanner.nextInt();
            R[i] = scanner.nextInt();
            snowFall[i] = scanner.nextInt();
        }


        for (int i = 0; i < Q; i++) {
            for (int j = L[i]; j <= R[i] ; j++) {
                snowHeight[j] += snowFall[i];
            }
        }

        StringBuilder resultArray = new StringBuilder();
        for (int i = 1; i < N; i++) {
            if(snowHeight[i] < snowHeight[i+1]){
                resultArray.append("<");
                continue;
            }
            if(snowHeight[i] > snowHeight[i+1]){
                resultArray.append(">");
                continue;
            }
            if(snowHeight[i] == snowHeight[i+1]){
                resultArray.append("=");
                continue;
            }


        }

        System.out.println(resultArray.toString());

    }
}
