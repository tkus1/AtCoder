package src.main.java.ABC329;

import java.util.Scanner;

public class B {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            max = Math.max(max, A[i]);
        }
        for (int i = 0; i < N; i++) {
            if(A[i] == max){
                A[i]=0;
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, A[i]);
        }
        System.out.println(ans);

    }
}
