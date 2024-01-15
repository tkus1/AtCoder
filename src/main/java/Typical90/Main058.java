package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextInt();
        long K = scanner.nextLong();
        HashMap<Long, Long> resMap = new HashMap<>();
        resMap.put(N,0L);
        long x = N;
        long loopStartValue;
        long i = 1;
        while(true){
            long y = Helper.getSumOfDigits(x);
            x = (x + y) % 100000;
            if(!resMap.containsKey(x)) {
                resMap.put(x, i);
                i++;
                continue;
            }
            y = Helper.getSumOfDigits(x);
            loopStartValue = (x + y) % 100000;
            break;
        }
        HashMap<Long, Long> loopMap = new HashMap<>();
        for(long key : resMap.keySet()){
            loopMap.put(resMap.get(key), key);
        }
        long loopEndCnt = i;
        long loopStartCnt = resMap.get(loopStartValue);
        long loopLength = loopEndCnt - loopStartCnt + 1;
        long ans;
        if(K <= loopStartCnt) {
            ans = loopMap.get(K);
            System.out.println(ans);
            return;
        }
        long loopStartK = K - loopStartCnt;
        long residual = loopStartK % loopLength;
        long targetIndex = loopStartCnt + residual;
        if(targetIndex == loopMap.size()){
            long lastValue = loopMap.get(targetIndex - 1);
            long lastValueSum = Helper.getSumOfDigits(lastValue);
            ans = (lastValue + lastValueSum) % 100000;
            System.out.println(ans);
            return;
        }
        ans = loopMap.get(targetIndex);
        System.out.println(ans);
    }
    public static class Helper{
        public static long getSumOfDigits(long n){
            long sum = 0;
            while(n > 0){
                sum +=  (n % 10);
                n /= 10;
            }
            return sum;
        }
    }
}
