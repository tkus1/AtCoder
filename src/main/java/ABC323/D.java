package src.main.java.ABC323;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
// In first thought, it seems to result in TLE.
// But implemented it because I guessed it may pass the test in some cases.
// However, it resulted in TLE. Then read an answer and implement D_2.java.
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<BigInteger,Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            BigInteger S = sc.nextBigInteger();
            long c = sc.nextLong();
            map.put(S, c);
        }
        while(true) {
            HashMap<BigInteger, Long> nextMap = new HashMap<>();
            for(BigInteger key : map.keySet()) {
                long value = map.get(key);
                map.put(key,0L);
                while(value>0){
                    if (value % 2 == 1) {
                        nextMap.put(key, 1L);
                        value--;
                    }
                    if (value / 2 > 0) {
                        value /= 2;
                        key = key.multiply(BigInteger.valueOf(2));
                        if(map.containsKey(key)){
                            value += map.get(key);
                            map.put(key,0L);
                        }
                        if(nextMap.containsKey(key)){
                            value += nextMap.get(key);
                            nextMap.put(key,0L);
                        }
                    }
                }

            }
            if(nextMap.values().stream().allMatch(v -> v == 1L)){
                map = nextMap;
                break;
            }
            map = nextMap;
        }
        long ans = map.keySet().size();
        System.out.println(ans);
    }
}
