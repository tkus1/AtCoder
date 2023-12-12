package src.main.java.AlgorithmAndMath;

import java.util.*;

public class Main022 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextInt();

        ArrayList<Long> inputArray = new ArrayList<>();
        HashMap<Long,Long> inputMap = new HashMap<>();
        long ans = 0;
        final long TARGET_VALUE = 100000;
        for (long i = 0; i < N; i++) {
            inputArray.add(scanner.nextLong());
        }

        for (long i = 0; i < N; i++) {
            Long num = inputArray.get((int) i);
            if(inputMap.get(num) == null){
                inputMap.put(num,1L);
                continue;
            }
            inputMap.put(num,inputMap.get(num)+1);
        }
        Iterator<Long> iterator = inputMap.keySet().iterator();
        while (iterator.hasNext()) {
            long i = iterator.next();
            long i_cnt = inputMap.get(i);

            if (i == TARGET_VALUE / 2) {
                if (i_cnt == 1) {
                    continue;
                }
                ans += combination(i_cnt, 2);
                continue;
            }

            long targetNum = TARGET_VALUE - i;

            if (inputMap.get(targetNum) == null) {
                continue;
            }

            long target_cnt = inputMap.get(targetNum);
            ans += i_cnt * target_cnt;

            iterator.remove();

        }
        System.out.println(ans);
    }
    public static long combination(long n, long r) {
        if (n < r || n < 0 || r < 0) {
            return 0;
        }
        long ans = 1;
        for (long i = 0; i < r; i++) {
            ans *= (n - i);
        }
        for (long i = 0; i < r; i++) {
            ans = ans / (i + 1);
        }
        return ans;
    }
}

