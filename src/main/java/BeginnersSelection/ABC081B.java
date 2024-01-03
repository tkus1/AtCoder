package src.main.java.BeginnersSelection;

import java.util.Scanner;

public class ABC081B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        int ans = 0;
        boolean isContinue = true;
        while(isContinue){
            for (int i = 0; i < N; i++) {
                if(array[i] % 2 == 1){
                    isContinue = false;
                    break;
                } else{
                    array[i] /= 2;
                }
                if (i == N - 1) {
                    ans++;
                }
            }

        }
        System.out.println(ans);
    }
}
