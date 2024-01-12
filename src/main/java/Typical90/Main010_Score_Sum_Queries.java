package src.main.java.Typical90;

import java.util.Scanner;

public class Main010_Score_Sum_Queries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] firstScore = new int[N+1];
        int[] secondScore = new int[N+1];
        firstScore[0] = 0;
        secondScore[0] = 0;
        for (int i = 1; i <= N; i++) {
            int classNo = scanner.nextInt();
            int score = scanner.nextInt();
            if(classNo == 1){
                firstScore[i] = firstScore[i-1] + score;
                secondScore[i] = secondScore[i-1];
            }else{
                firstScore[i] = firstScore[i-1];
                secondScore[i] = secondScore[i-1] + score;
            }
        }
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            System.out.println(firstScore[R] - firstScore[L-1] + " " + (secondScore[R] - secondScore[L-1]));
        }
    }
}
