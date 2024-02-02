package src.main.java.ABC320;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long Apow = 1;
        long Bpow = 1;
        for (int i = 0; i < B; i++) {
            Apow *= A;
        }
        for (int i = 0; i < A; i++) {
            Bpow *= B;
        }
        System.out.println(Apow + Bpow);
    }
}
