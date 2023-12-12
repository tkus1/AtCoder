package src.main.java.AlgorithmAndMath;

import java.util.LinkedList;
import java.util.Scanner;

public class Main014 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();

        LinkedList<Long> primeFactorList = new LinkedList();
        while(true){
            long primeFactor = findLeastDivisor(N);

            primeFactorList.add(primeFactor);
            if(primeFactor == N){
                break;
            }else{
                N = N / primeFactor;
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (long divisor : primeFactorList) {
            if (stringBuilder.isEmpty()) {
                stringBuilder.append(divisor);
            } else {
                stringBuilder.append("\n").append(divisor);
            }
        }
        System.out.println(stringBuilder.toString());
    }
    public static long findLeastDivisor(long N){
        long sqrtN = (long) Math.ceil(Math.sqrt(N));
        for (long i = 2L; i <= sqrtN; i++) {
            if (Math.floorMod(N, i) == 0) {
                return i;
            }
        }
        return N;
    }
}
