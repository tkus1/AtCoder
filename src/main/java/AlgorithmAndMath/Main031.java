package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] valueArray = new long[N];

        for (int i = 0; i < N; i++) {
            valueArray[i] = scanner.nextLong();
        }
        long[] resultArray = new long[N];
        resultArray[0] = valueArray[0];
        resultArray[1] = valueArray[1];
        for (int i = 2; i < N; i++) {
            resultArray[i] = Math.max(resultArray[i-1], resultArray[i-2]+valueArray[i]);
        }
        System.out.println(resultArray[N-1]);
    }
}
