package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main030 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int W = scanner.nextInt();
        long[] valueArray = new long[N];
        int[] weightArray = new int[N];
        for (int i = 0; i < N; i++) {
            weightArray[i] = scanner.nextInt();
            valueArray[i] = scanner.nextLong();
        }
        long[][] resultTable = new long[N][W+1];
        for (int i = 0; i < N; i++) {
            long value = valueArray[i];
            int weight = weightArray[i];
            for (int j = 0; j <= W; j++) {

                if(i == 0){
                    if(j >= weight){
                        resultTable[i][j] = value;
                    }else{
                        resultTable[i][j] = 0;
                    }
                    continue;
                }
                int prevWeight = j - weight;
                if(prevWeight < 0){
                    resultTable[i][j] = resultTable[i-1][j];
                    continue;
                }
                resultTable[i][j] = Math.max(resultTable[i-1][j], resultTable[i-1][prevWeight] + value);
            }
        }

        System.out.println(resultTable[N-1][W]);

    }
}
