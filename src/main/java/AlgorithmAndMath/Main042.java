package src.main.java.AlgorithmAndMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main042 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        ArrayList<ArrayList<Long>> primeFactorList = new ArrayList();
        primeFactorList.add(new ArrayList<Long>());
        primeFactorList.get(0).add(1L);
        long ans = 1;
        for (int i = 2; i <= N; i++) {
            long leastDivisor = findLeastDivisor(i);
            ArrayList<Long> primeFactorListFor_i;
            if(leastDivisor == i){
                primeFactorListFor_i = new ArrayList<>(getPrimeFactorList(i));
                //primeFactorListFor_i = getPrimeFactorList(i);
            }else{
                primeFactorListFor_i = new ArrayList<>(primeFactorList.get((int) (i/leastDivisor)-1));
                primeFactorListFor_i.add(leastDivisor);
            }
            long divisorCnt = getUniqueDivisorCnt(primeFactorListFor_i);
            ans += divisorCnt * i;
            primeFactorList.add(primeFactorListFor_i);;
        }
        System.out.println(ans);
    }
    private static long getUniqueDivisorCnt (ArrayList<Long> primeFactorList){
        HashMap<Long, Integer> divisorMap = new HashMap<Long, Integer>();
        for (long primeNum : primeFactorList){
            if(divisorMap.get(primeNum) == null){
                divisorMap.put(primeNum, 1);
            }else{
                divisorMap.put(primeNum,divisorMap.get(primeNum) + 1);
            }
        }
        long ans = 1;
        for(long key : divisorMap.keySet()){
            ans *= divisorMap.get(key) + 1;
        }
        return ans;
    }
    private static ArrayList<Long> getPrimeFactorList(long N){

        ArrayList<Long> primeFactorList = new ArrayList();
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
