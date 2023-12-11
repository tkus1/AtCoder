package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main020 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] sortedInputArray = new int[N];

        int ans = 0;
        final int TARGET_VALUE = 1000;
        for (int i = 0; i < N; i++) {
            sortedInputArray[i]=scanner.nextInt();
        }

        for (int i = 0; i <= N-5; i++) {

            for (int j = i+1; j <= N-4; j++) {
                int sum_i_j = sortedInputArray[i]+ sortedInputArray[j];
                for (int k = j+1; k <= N-3; k++) {
                    int sum_i_j_k = sum_i_j + sortedInputArray[k];
                    for (int l = k+1; l <= N-2; l++) {
                        int sum_i_j_k_l = sum_i_j_k + sortedInputArray[l];
                        for (int m = l+1; m <= N-1; m++) {
                            if(sum_i_j_k_l + sortedInputArray[m] == TARGET_VALUE){
                                ans++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);


    }

}
