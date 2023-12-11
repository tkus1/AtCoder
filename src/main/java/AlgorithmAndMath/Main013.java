package src.main.java.AlgorithmAndMath;

import java.util.LinkedList;
import java.util.Scanner;

public class Main013 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long ceilN = (long) Math.ceil(Math.sqrt(N));
        LinkedList<Long> divisorList = new LinkedList();
        for(long i = 1L; i <= ceilN; i++){
            if(Math.floorMod(N, i) == 0){
                if(!divisorList.contains(i)){
                    divisorList.add(i);
                }

                if (i < ceilN){
                    long counter = N / i;
                    divisorList.add(counter);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(long divisor : divisorList){
            if(stringBuilder.isEmpty()){
                stringBuilder.append(divisor);
            }else{
            stringBuilder.append("\n").append(divisor);
                }
        }
        System.out.println(stringBuilder.toString());

    }

}