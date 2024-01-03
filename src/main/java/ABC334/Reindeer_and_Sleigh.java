package src.main.java.ABC334;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Reindeer_and_Sleigh {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        ArrayList<Integer> R = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            R.add(scanner.nextInt());
        }
        Collections.sort(R);
        long[] totalRequiredReindeer = new long[N];
        totalRequiredReindeer[0] = R.get(0);
        for (int i = 1; i < N; i++) {
            totalRequiredReindeer[i] = totalRequiredReindeer[i-1] + R.get(i);
        }
        long reindeerCnt;
        int ans = 0;
        for (int i = 0; i < Q; i++) {
            reindeerCnt = scanner.nextLong();
            ans = Helper.binarySearchLargestElement(totalRequiredReindeer, reindeerCnt);
            System.out.println(ans);
        }

    }

    public static class Helper{
        private static int binarySearchLargestElement(long[] A, long X) {
            int left = -1;
            int right = A.length - 1;

            while (left < right) {
                int mid = left + (right - left + 1) / 2;

                if (A[mid] <= X) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            // left が最も大きい要素の要素番号になります
            return left + 1;
        }
    }
}
