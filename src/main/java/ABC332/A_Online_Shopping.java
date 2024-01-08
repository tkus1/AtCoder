package src.main.java.ABC332;

import java.util.Scanner;

public class A_Online_Shopping {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int K = scanner.nextInt();
        int P;
        int Q;
        long totalCost = 0;
        for (int i = 0; i < N; i++) {
            P = scanner.nextInt();
            Q = scanner.nextInt();
            totalCost += P * Q;
        }
        if(totalCost < S){
            totalCost += K;
        }
        System.out.println(totalCost);
    }
}
