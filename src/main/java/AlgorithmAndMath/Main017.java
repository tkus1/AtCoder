package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main017 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] inputList = new long[N];
        for (int i = 0; i < N; i++) {
            inputList[i] = scanner.nextLong();
        }

        long lcm = 1;
        for (int i = 0; i < N; i++) {
            if (inputList[i] != 1) {
                long gcd = EuclideanAlgorithm(lcm, inputList[i]);
                lcm = (lcm / gcd) * inputList[i];
            }
        }

        System.out.println(lcm);
    }
    public static long EuclideanAlgorithm(long A, long B){
        long denominator = Math.max(A, B);
        long numerator = Math.min(A, B);
        long residue = Math.floorMod(denominator,numerator);
        if(residue == 0){
            return numerator;
        }else{
            return EuclideanAlgorithm(numerator,residue);
        }
    }
}
