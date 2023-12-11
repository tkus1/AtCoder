package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main005 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Integer sum =0;
        int inputCnt = scanner.nextInt();
        for(int i = 0; i < inputCnt; i++){
            sum += scanner.nextInt();
        }
        System.out.println(Math.floorMod(sum,100) );
    }

}