package src.main.java.AlgorithmAndMath;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main015 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        LinkedList<Long> factorListA = factorize(A);
        LinkedList<Long> factorListB = factorize(B);

        Iterator<Long> factorIteratorA = factorListA.iterator();
        while(factorIteratorA.hasNext()){
            Long factorA = factorIteratorA.next();
            Iterator<Long> factorIteratorB = factorListB.iterator();
            boolean findCommonDivisor = false;
            while (factorIteratorB.hasNext()){
                Long factorB = factorIteratorB.next();

                if(factorA.equals(factorB)){
                    factorIteratorB.remove();
                    findCommonDivisor = true;
                    break;
                }

            }
            if(!findCommonDivisor){
                factorIteratorA.remove();
            }

        }
        long gcd = 1;
        for(long factorA : factorListA){
            gcd *= factorA;
        }

        System.out.println(gcd);
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

    public static LinkedList<Long> factorize(long N){
        LinkedList<Long> primeFactorList = new LinkedList<>();
        while(true){
            long primeFactor = findLeastDivisor(N);

            primeFactorList.add(primeFactor);
            if(primeFactor == N){
                break;
            }else{
                N = N / primeFactor;
            }

        }
        return primeFactorList;
    }

}

