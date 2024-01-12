package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main014_We_Used_to_Sing_a_Song_Together {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            A.add(scanner.nextInt());
        }
        for (int i = 0; i < N; i++) {
            B.add(scanner.nextInt());
        }
        Collections.sort(A);
        Collections.sort(B);
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.abs(A.get(i) - B.get(i));
        }
        System.out.println(ans);
    }
}
