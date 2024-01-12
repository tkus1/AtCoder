package src.main.java.ABC330;


import java.util.Scanner;

public class D_Counting_Ls {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char[][] S = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = scanner.next();
            for (int j = 0; j < N; j++) {
                S[i][j] = str.charAt(j);
            }
        }
        long[] colCnt = new long[N];
        long[] rowCnt = new long[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(S[i][j] == 'o'){
                    colCnt[j]++;
                    rowCnt[i]++;
                }
            }
        }
        long ansCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(S[i][j] == 'x'){
                    continue;
                }
                ansCnt += ((colCnt[j] - 1) * (rowCnt[i]-1));
            }
        }
        System.out.println(ansCnt);
    }

}
