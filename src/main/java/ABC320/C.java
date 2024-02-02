package src.main.java.ABC320;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        String S1 = sc.next();
        String S2 = sc.next();
        String S3 = sc.next();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            ans = Math.min(ans, getSlotCnt(i, S1, S2, S3, M));
            ans = Math.min(ans, getSlotCnt(i, S1, S3, S2, M));
            ans = Math.min(ans, getSlotCnt(i, S2, S1, S3, M));
            ans = Math.min(ans, getSlotCnt(i, S2, S3, S1, M));
            ans = Math.min(ans, getSlotCnt(i, S3, S1, S2, M));
            ans = Math.min(ans, getSlotCnt(i, S3, S2, S1, M));
        }
        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
    public static int getSlotCnt(int target, String S1, String S2, String S3, int length) {
        if(!S1.contains(String.valueOf(target)) || !S2.contains(String.valueOf(target)) || !S3.contains(String.valueOf(target))) {
            return Integer.MAX_VALUE;
        }
        StringBuilder sb1 = new StringBuilder(S1).append(S1).append(S1);
        StringBuilder sb2 = new StringBuilder(S2).append(S2).append(S2);
        StringBuilder sb3 = new StringBuilder(S3).append(S3).append(S3);
        StringBuilder[] targetSb = new StringBuilder[]{sb1, sb2, sb3};
        int index = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < sb1.length(); i++) {
            char c = targetSb[index].charAt(i);
            if(Integer.parseInt(String.valueOf(targetSb[index].charAt(i))) == target ) {
                index++;
                if(index == 3) {
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
}
