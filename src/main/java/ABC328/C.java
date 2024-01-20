package src.main.java.ABC328;

import java.util.Scanner;

public class C {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        char[] S = scanner.next().toCharArray();
        int[] res = new int[N];
        int ans = 0;
        res[0] = 0;
        for (int i = 1; i < N; i++) {
            if(S[i-1] == S[i]){
                res[i] = res[i-1]+1;
            }else {
                res[i] = res[i-1];
            }
        }
        for (int i = 0; i < Q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            ans = res[r - 1] - res[l - 1];
            System.out.println(ans);
        }


    }
}
