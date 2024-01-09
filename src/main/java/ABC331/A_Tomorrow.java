package src.main.java.ABC331;

import java.util.Scanner;

public class A_Tomorrow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int D = scanner.nextInt();
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        int nextY;
        int nextM;
        int nextD;
        if(d<D){
            nextD = d+1;
            nextM = m;
            nextY = y;
        }else{
            nextD = 1;
            if(m<M){
                nextM = m+1;
                nextY = y;
            }else{
                nextM = 1;
                nextY = y+1;
            }
        }
        System.out.println(nextY + " " + nextM + " " + nextD);
    }

}
