package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long K  = scanner.nextLong();
        ArrayList<Long> A = new ArrayList<>();
        ArrayList<Long> B = new ArrayList<>();

        for (long i = 0; i < N; i++) {
            A.add(scanner.nextLong());

        }
        for (long i = 0; i < N; i++) {
            B.add(scanner.nextLong());
        }
        //Collections.sort(A);
        //Collections.sort(B);
        long smallestOperationCnt = 0;
        for (long i = 0; i < N; i++) {
            smallestOperationCnt += Math.abs(A.get((int) i) - B.get((int) i));
        }
        if(smallestOperationCnt > K){
            System.out.println("No");
            return;
        }
        if ((K - smallestOperationCnt) % 2 == 0) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");

    }
}
