package src.main.java.Typical90;

import java.util.Scanner;

public class Main016_Minimum_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextInt();
        long input1 = scanner.nextInt();
        long input2 = scanner.nextInt();
        long input3 = scanner.nextInt();
        long A = Math.max(Math.max(input1, input2), input3);
        long C = Math.min(Math.min(input1, input2), input3);
        long B = input1 + input2 + input3 - A - C;
        long minCnt = Integer.MAX_VALUE;
        long maxACnt = ((N - Math.floorMod(N, A)) + N) / A;
        //int maxACnt = Math.ceilDiv(N, A);
        for (long cntA = 0; cntA <= maxACnt; cntA++) {
            long residualAmt_A = N - A * cntA;
            long maxBCnt = ((residualAmt_A - Math.floorMod(residualAmt_A, B)) + residualAmt_A) / B;
            //int maxBCnt = Math.ceilDiv(residualAmt_A, B);
            for (long cntB = 0; cntB <= maxBCnt; cntB++) {
                long residualAmt_A_B = residualAmt_A - B * cntB;
                long cntC = residualAmt_A_B / C;
                if(cntC < 0) {
                    continue;
                }
                if((residualAmt_A_B - C * cntC) == 0){
                    minCnt = Math.min(minCnt, cntA + cntB + cntC);
                }
            }

        }
        System.out.println(minCnt);
    }
}
