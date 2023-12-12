package src.main.java.AlgorithmAndMath;

import java.util.LinkedList;
import java.util.Scanner;

public class Main012 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Long N = scanner.nextLong();
        boolean isPrime = true;
        if(!N.equals(2L)){
            Long sqrtN = (long) Math.ceil(Math.sqrt(N.doubleValue()));
            for(Long i = 2L; i <= sqrtN; i++){
                if(Math.floorMod(N, i) == 0){
                    isPrime = false;
                    break;
                }
            }
        }
        String state = "No";
        if(isPrime){
            state = "Yes";
        }
        System.out.println(state);

    }

}