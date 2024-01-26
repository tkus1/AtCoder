package src.main.java.ABC323;
import java.util.HashMap;
import java.util.Scanner;
public class D_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long S = sc.nextLong();
            long c = sc.nextLong();
            while(S % 2 == 0) {
                S /= 2;
                c *= 2;
            }
            map.put(S, map.getOrDefault(S,0L)+ c);
        }
        long ans = 0;
        for(long key : map.keySet()) {
            long value = map.get(key);
            while(value > 0) {
                if(value % 2 == 1) {
                    ans++;
                    value--;
                }
                if(value / 2 > 0) {
                    value /= 2;
                }
            }
        }
        System.out.println(ans);

    }
}
