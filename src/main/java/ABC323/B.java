package src.main.java.ABC323;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] point = new int[N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'o') {
                    point[i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(true) {
            int max = -1;
            int maxIndex = -1;
            for (int i = 0; i< N; i++) {
                if(point[i] > max) {
                    max = point[i];
                    maxIndex = i;
                }
            }
            if(maxIndex == -1) {
                break;
            }
            point[maxIndex] = -1;
            sb.append(maxIndex + 1).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}