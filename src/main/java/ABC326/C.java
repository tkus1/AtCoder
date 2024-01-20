package src.main.java.ABC326;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        ArrayList<Long> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextLong());
        }
        Collections.sort(A);
        int[] counter = new int[N];
        int startIndex = 0;
        int endIndex = 0;
        int cnt = 0;
        while(endIndex< N){
            long startNum = A.get(startIndex);
            long endNum = A.get(endIndex);
            long diff = endNum - startNum;
            while(diff >= M) {
                counter[startIndex] = cnt;
                startIndex++;
                cnt--;
                diff = A.get(endIndex) - A.get(startIndex);
            }
            cnt++;
            endIndex++;
        }
        counter[startIndex] = cnt;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, counter[i]);
        }
        System.out.println(ans);
    }


}
