package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.Scanner;

public class Main085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        ArrayList<Long> divisors = getDivisors(N);
        int ansCnt = 0;
        for (int i = 0; i < divisors.size(); i++) {
            long a = divisors.get(i);
            for (long b : divisors) {
                if (a > b) {
                    continue;
                }

                if (N % a  != 0) {
                    continue;
                }
                long NdivA = N / a;
                if (NdivA % b != 0) {
                    continue;
                }

                long c = NdivA / b;
                if (b > c) {
                    continue;
                }
                ansCnt++;
            }
        }
        System.out.println(ansCnt);
    }
    public static ArrayList<Long> getDivisors(long num){
        ArrayList<Long> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                divisors.add((long)i);
                if(i != num/i){
                    divisors.add((long)num/i);
                }
            }
        }
        return divisors;
    }
}
