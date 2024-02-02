package src.main.java.ABC323;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] questions = new int[M];
        for (int i = 0; i < M; i++) {
            questions[i] = sc.nextInt();
        }
        ArrayList<Integer>[] restingQuestions = new ArrayList[N];
        int[] currentScore = new int[N];
        for (int i = 0; i < N; i++) {
            restingQuestions[i] = new ArrayList<>();
            currentScore[i] = i+1;
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                if(s.charAt(j) == 'o') {
                    currentScore[i] += questions[j];
                }else {
                    restingQuestions[i].add(questions[j]);
                }
            }
            Collections.sort(restingQuestions[i]);
        }
        int maxScore = -1;
        for (int i = 0; i < N; i++) {
            maxScore = Math.max(maxScore, currentScore[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            while(currentScore[i] < maxScore) {
                currentScore[i] += restingQuestions[i].remove(restingQuestions[i].size() - 1);
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
