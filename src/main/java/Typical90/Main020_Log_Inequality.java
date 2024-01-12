package src.main.java.Typical90;

import java.math.BigInteger;
import java.util.Scanner;

public class Main020_Log_Inequality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger A = scanner.nextBigInteger();
        BigInteger B = scanner.nextBigInteger();
        BigInteger C = scanner.nextBigInteger();
        if(A.compareTo(C.pow(B.intValue())) < 0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
