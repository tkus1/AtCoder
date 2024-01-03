package src.main.java.BeginnersSelection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ABC088B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextInt());
        }
        Collections.sort(A);
        int aliceScore = 0;
        int bobScore = 0;
        int lastIndex = A.size() - 1;
        while(lastIndex >= 0){
            aliceScore += A.get(lastIndex);
            lastIndex--;
            if(lastIndex < 0){
                break;
            }
            bobScore += A.get(lastIndex);
            lastIndex--;
        }
        int scoreGap = aliceScore - bobScore;
        System.out.println(scoreGap);
    }
}
