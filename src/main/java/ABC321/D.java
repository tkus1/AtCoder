package src.main.java.ABC321;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        ArrayList <Long> A = new ArrayList<>();
        ArrayList <Long> B = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            A.add(sc.nextLong());
        }
        for (int i = 0; i < M; i++) {
            B.add(sc.nextLong());
        }
        Collections.sort(B);
        long[] sumB = new long[M];
        sumB[0] = B.get(0);
        for (int i = 1; i < M; i++) {
            sumB[i] = sumB[i-1] + B.get(i);
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            long target = P - A.get(i);
            long index = binarySearch(B, target);
            ans += (M - index) * P;
            if(index > 0){
                ans += sumB[(int) (index-1)] + (long) A.get(i) * index;
            }

        }
        System.out.println(ans);
    }
    public static int binarySearch(ArrayList<Long> list, long target){
        int left = 0;
        int right = list.size();
        while (left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
