package src.main.java.Typical90;

import java.util.Scanner;

public class Main075 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long factorialCnt = 0;
        boolean continueFlag = true;
        while (continueFlag) {
            long maxCnt = (long)Math.ceil(Math.sqrt(N));
            for (long i = 2; i <= maxCnt; i++) {
                if(N % i == 0){
                    factorialCnt++;
                    N /= i;
                    break;
                }
                if(i == maxCnt){
                    factorialCnt++;
                    continueFlag = false;
                }
            }
            if(N == 2){
                factorialCnt++;
                continueFlag = false;
            }
            if(N == 1){
                continueFlag = false;
            }
        }
        System.out.println((long)Math.ceil(Math.log(factorialCnt) / Math.log(2)));
    }
}
