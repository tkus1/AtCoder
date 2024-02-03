package src.main.java.ABC319;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        long[] l = new long[(int) N];
        long totalLength = 0;
        for (int i = 0; i < N; i++) {
            long length = sc.nextLong();
            l[i] = length;
            totalLength += length;
        }
        long maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, l[i]);
        }
        long minW = Math.max((totalLength / M), maxLength);
        long maxW = (minW +1) * 2;
        long left = minW;
        long right = maxW;
        while (right - left > 1){
            long mid = (left + right) / 2;
            if(canDisplay(l, mid, M)){
                right = mid;
            } else {
                left = mid;
            }
        }
        if(canDisplay(l, left, M))
            System.out.println(left);
        else{
            System.out.println(right);
        }
    }
    static boolean canDisplay(long[] l, long W, long M){
        long cnt = 1;
        long residualLength = W;
        for (int i = 0; i < l.length; i++){

            long length = l[i];

            if(length <= residualLength){
                residualLength -= (length + 1);
            } else {
                cnt++;
                residualLength = W - (length + 1);
            }
            if(residualLength < -1){
                return false;
            }
        }
        return cnt <= M;
    }
}
