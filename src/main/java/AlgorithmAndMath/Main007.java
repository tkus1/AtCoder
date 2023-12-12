package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main007 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int cnt = 0;
        for (int i = 1; i<= N; i++){
            boolean xCondition = Math.floorMod(i,X)==0;
            boolean yCondition = Math.floorMod(i,Y)==0;
            if(xCondition || yCondition){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
