package src.main.java.Typical90;

import java.util.Scanner;

public class Main076 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] A = new long[2 * N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            A[i + N] = A[i];
        }
        long targetNum = 0;
        for (int i = 0; i < N; i++) {
            targetNum += A[i];
        }
        targetNum /= 10;
        int startIndex = 0;
        int endIndex = 1;
        long sum = A[0];

        if(targetNum == 0){
            System.out.println("No");
            return;
        }

        while(startIndex < N){
            if(sum < targetNum){
                sum += A[endIndex];
                endIndex++;
            }else if(sum > targetNum){
                sum -= A[startIndex];
                startIndex++;
            }else{
                System.out.println("Yes");
                return;
            }

        }
        System.out.println("No");

    }
}
