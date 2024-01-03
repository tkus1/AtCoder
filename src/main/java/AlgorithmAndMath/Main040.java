package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main040 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long[] distanceList = new long[N-1];
        for (int i = 0; i < N-1; i++) {
            distanceList[i] = scanner.nextLong();
        }
        int M = scanner.nextInt();
        int[] travelList = new int[M];

        for (int i = 0; i < M; i++) {
            travelList[i] = scanner.nextInt()-1;
        }
        long[][] distanceTable = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = i; k < j; k++) {
                    distanceTable[i][j] += distanceList[k];
                }
            }
        }
        for (int j = 0; j < N; j++) {
            for (int i = j + 1; i < N; i++) {
                distanceTable[i][j] = distanceTable[j][i];
            }
        }

        long totalDistance = 0;
        int currentLocation = travelList[0];
        int nextLocation;

        for (int i = 1; i < M; i++) {
            nextLocation = travelList[i];
            totalDistance += distanceTable[currentLocation][nextLocation];
            currentLocation = nextLocation;
        }


        System.out.println(totalDistance);

    }
}
