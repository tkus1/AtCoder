package src.main.java.BeginnersSelection;

import java.util.Scanner;

public class ABC085C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Y = scanner.nextInt();
        boolean isComplete = false;
        for (int i = 0; i <=N ; i++) {
            for (int j = 0; j <= N-i; j++) {
                int cnt10000 = N - i - j;
                int cnt5000 = j;
                int cnt1000 = i;
                int sumAmt = cnt10000 * 10000 + cnt5000 * 5000 + cnt1000 * 1000;
                if(sumAmt == Y){
                    System.out.println(cnt10000 + " " +cnt5000 + " " + cnt1000);
                    isComplete = true;
                    break;
                }
            }
            if(isComplete){
                break;
            }
        }
        if(!isComplete){
            System.out.println("-1 -1 -1");
        }
    }
}
