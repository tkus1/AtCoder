package src.main.java.ABC322;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        for(int i = 0; i < s.length()-2; i++) {
            if(s.charAt(i) == 'A' && s.charAt(i+1) == 'B' && s.charAt(i+2) == 'C') {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(-1);
    }
}
