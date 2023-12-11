package src.main.java.AlgorithmAndMath;

import java.math.BigInteger;
import java.util.Scanner;

public class Main019 {

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    cnt1++;
                    break;
                case 2:
                    cnt2++;
                    break;
                case 3:
                    cnt3++;
                    break;
            }
        }
        long combination1 = 0;
        long combination2 = 0;
        long combination3 = 0;


        if(cnt1 >= 2 ){
            combination1 = combination(cnt1,2);;
        }
        if(cnt2 >= 2 ){
            combination2 = combination(cnt2,2);
        }
        if(cnt3 >= 2 ){
            combination3 = combination(cnt3,2);
        }

        long total = combination1 + combination2 + combination3;
        System.out.println(total);


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