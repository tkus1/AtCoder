package src.main.java.ABC322;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int diff = M - N;
        String S = sc.next();
        String T = sc.next();
        boolean isHead = true;
        boolean isTail = true;
        for (int i = 0; i < N; i++) {
            if(S.charAt(i) == T.charAt(i)) {
                continue;
            } else {
                isHead = false;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if(S.charAt(N-1-i) == T.charAt(M-1-i)) {
                continue;
            } else {
                isTail = false;
                break;
            }
        }
        if(isHead && isTail) {
            System.out.println(0);
        } else if(isHead) {
            System.out.println(1);
        } else if (isTail) {
            System.out.println(2);
        }else {
            System.out.println(3);
        }
    }
}
