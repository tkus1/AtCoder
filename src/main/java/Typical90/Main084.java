package src.main.java.Typical90;

import java.util.Scanner;

public class Main084 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String S = scanner.next();
        int[] firstCircle = new int[N];
        int[] firstCross = new int[N];
        int firstCircleIndex = -1;
        for (int i = 1; i <= N; i++) {
            if(S.charAt(N-i) == 'o') {
                firstCircleIndex = N - i;
            }else{
                firstCircle[N-i] = firstCircleIndex;
            }
        }
        int firstCrossIndex = -1;
        for (int i = 1; i <= N; i++) {
            if(S.charAt(N-i) == 'x') {
                firstCrossIndex = N - i;
            }else{
                firstCross[N-i] = firstCrossIndex;
            }
        }
        long ans = 0;
        for (int i = 0; i < N; i++) {
            if(S.charAt(i)== 'o'){
                int firstCrossPoint = firstCross[i];
                if(firstCrossPoint == -1) {
                    continue;
                }
                ans += N - firstCrossPoint;
            }else{
                int firstCirclePoint = firstCircle[i];
                if(firstCirclePoint == -1) {
                    continue;
                }
                ans += N - firstCirclePoint;
            }

        }
        System.out.println(ans);
    }
}
