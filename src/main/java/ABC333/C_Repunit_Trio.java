package src.main.java.ABC333;

import java.util.Scanner;

public class C_Repunit_Trio {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder A = new StringBuilder().append("1");
        StringBuilder B = new StringBuilder().append("1");
        StringBuilder C = new StringBuilder().append("1");

        for (int i = 0; i <N-1; i++) {
            if(A.length() == B.length() && B.length() == C.length()){
                A.append("1");
                B = new StringBuilder().append("1");
                C = new StringBuilder().append("1");
                continue;
            }
            if(B.length() == C.length()){
                B.append("1");
                C = new StringBuilder().append("1");
                continue;
            }
            C.append("1");

        }
            Long intA = Long.parseLong(A.toString());
            Long intB = Long.parseLong(B.toString());
            Long intC = Long.parseLong(C.toString());
            System.out.println((intA + intB + intC));

    }
}
