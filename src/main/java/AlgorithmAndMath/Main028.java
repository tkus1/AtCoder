package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main028 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] heightArray = new int[N];
        int[] valueArray = new int[N];
        for (int i = 0; i < N; i++) {
            heightArray[i] = scanner.nextInt();
        }

        valueArray[0] = 0;
        valueArray[1] = valueArray[0] + Math.abs(heightArray[1] - heightArray[0]);
        for (int i = 2; i < N ; i++) {
            valueArray[i] = Math.min(valueArray[i-1] + Math.abs(heightArray[i] - heightArray[i-1])
                                    ,valueArray[i-2] + Math.abs(heightArray[i] - heightArray[i-2]));
        }
        System.out.println(valueArray[N-1]);

    }

}
