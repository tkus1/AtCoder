package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main021 {
    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        long ans = combination(n,r);
        System.out.println(ans);

    }
    public static long combination(int n, int r) {
        if (n < r || n < 0 || r < 0) {
            return 0;
        }
        long ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
        }
        for (int i = 0; i < r; i++) {
            ans = ans / (i + 1);
        }
        return ans;
    }

}
