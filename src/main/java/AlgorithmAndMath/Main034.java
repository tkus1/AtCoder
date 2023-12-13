package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] xCoordinate = new int[N];
        int[] yCoordinate = new int[N];
        for (int i = 0; i < N; i++) {
            xCoordinate[i] = scanner.nextInt();
            yCoordinate[i] = scanner.nextInt();
        }
        double minDistance = Double.POSITIVE_INFINITY;
        int[] pointA = new int[2];
        int[] pointB = new int[2];

        for (int i = 0; i < N - 1; i++) {
            pointA[0] = xCoordinate[i];
            pointA[1] = yCoordinate[i];
            for (int j = i+1; j < N; j++) {
                pointB[0] = xCoordinate[j];
                pointB[1] = yCoordinate[j];
                minDistance = Math.min(getDistance(pointA,pointB), minDistance);
            }
        }

        System.out.println(minDistance);
    }
    private static double getDistance (int[] A, int[] B){
        int diffX = A[0] - B[0];
        int diffY = A[1] - B[1];
        return (Math.sqrt((diffX * diffX) +(diffY * diffY)));
    }
}
