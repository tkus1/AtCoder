package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main049 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MOD_NUM = 1000000007;
        int N = scanner.nextInt();
        long prev_1 = 1;
        long prev_2 = 1;
        long fib_i = 0;
        for (int i = 3; i <= N; i++) {
            fib_i = prev_1 + prev_2;
            if(fib_i > MOD_NUM){
                fib_i = (Math.floorMod(fib_i,MOD_NUM));
            }
            prev_2 = prev_1;
            prev_1 = fib_i;
        }
        System.out.println(fib_i);
    }
}
