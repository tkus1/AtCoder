package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MOD_NUM = 1000000007;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long ans = 1;
        int bulkMultiplyCnt = 0;
        long bulkMultiplier = 1;
        int residualMultiplyCnt = 0;

        /*
        for (int i = 1; i <= b; i++) {
            ans *= a;
            if(ans > MOD_NUM){
                ans = Math.floorMod(ans, MOD_NUM);
                bulkMultiplier = ans;
                bulkMultiplyCnt = i;
                while(i + bulkMultiplyCnt <= b){
                    i+= bulkMultiplyCnt;
                    ans *= bulkMultiplier;
                    ans = Math.floorMod(ans, MOD_NUM);
                }
            };
        }

         */


        long ans2 = ModMultiplier.modMultiply(MOD_NUM, a, b);
        System.out.println(Math.floorMod(ans, MOD_NUM));
        System.out.println(Math.floorMod(ans2, MOD_NUM));

    }
    public static class ModMultiplier{
        public static long modMultiply(long modNum, long inputNum,long times){
            long ans = 1;
            for (long i = 1; i <= times; i++) {
                ans *= inputNum;
                if(ans > modNum){
                    long bulkMultiplyCnt = i;
                    long newInputNum = Math.floorMod(ans,modNum);
                    long loopCnt = (times - i)/bulkMultiplyCnt;
                    i += loopCnt * bulkMultiplyCnt;
                    ans = Math.floorMod(ans, modNum);
                    ans *= modMultiply(modNum, newInputNum, loopCnt);

                }
            }
            return ans;
        }
    }
}
