package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main070 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Long> A = new ArrayList<>();
        ArrayList<Long> B = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextLong());
            B.add(scanner.nextLong());
        }
        Collections.sort(A);
        Collections.sort(B);
        long medianX;
        long medianY;
        if(N % 2 == 0){
            medianX = (A.get(N/2 - 1) + A.get(N/2)) / 2;
            medianY = (B.get(N/2 - 1) + B.get(N/2)) / 2;
        } else {
            medianX = A.get(N/2);
            medianY = B.get(N/2);
        }
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.abs(A.get(i) - medianX);
            ans += Math.abs(B.get(i) - medianY);
        }
        System.out.println(ans);

    }
}
