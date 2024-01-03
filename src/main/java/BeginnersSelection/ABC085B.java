package src.main.java.BeginnersSelection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ABC085B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextInt());
        }
        Collections.sort(A);
        int ans = 1;
        for (int i = 1; i < N; i++) {
            if(A.get(i-1) < A.get(i)){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
