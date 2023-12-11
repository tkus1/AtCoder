package src.main.java.AlgorithmAndMath;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main016 {
    public static void main (String[] args) {


        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long gcd = scanner.nextLong();
        for(long i = 1; i <= N-1; i++){
            gcd = EuclideanAlgorithm(gcd,scanner.nextLong());
        }

        System.out.println(gcd);


    }

    public static long EuclideanAlgorithm(long A, long B){
        long denominator = Math.max(A, B);
        long numerator = Math.min(A, B);
        long residue = Math.floorMod(denominator,numerator);
        if(residue == 0){
            return numerator;
        }else{
            return EuclideanAlgorithm(numerator,residue);
        }
    }

}

