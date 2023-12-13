package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main035 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        long N = 2;
        long[] pointA = new long[(int) N];
        long[] pointB = new long[(int) N];
        long radiusA;
        long radiusB;
        pointA[0]=scanner.nextInt();
        pointA[1]=scanner.nextInt();
        radiusA = scanner.nextInt();

        pointB[0]=scanner.nextInt();
        pointB[1]=scanner.nextInt();
        radiusB = scanner.nextInt();

        long stateInt = relationDecider(pointA, radiusA, pointB, radiusB);
        System.out.println(stateInt);
    }
    private static double getDistance (long[] A, long[] B){
        long diffX = A[0] - B[0];
        long diffY = A[1] - B[1];
        return (Math.sqrt((diffX * diffX) +(diffY * diffY)));
    }
    private static int relationDecider(long[] pointA, long radiusA, long[] pointB, long radiusB){
        double distance = getDistance(pointA, pointB);
        if(distance > radiusA + radiusB){
            return 5;
        }
        if(distance == radiusA + radiusB){
            return 4;
        }
        //if(distance + radiusA < radiusB || distance + radiusB < radiusA)
        if(distance < Math.abs(radiusA - radiusB)){
            return 1;
        }
        if(distance == Math.abs(radiusA - radiusB)){
            return 2;
        }

        return 3;
    }
}
