package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main029 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] valueArray = new int[N+1];


        valueArray[0] = 1;
        valueArray[1] = 1;
        for (int i = 2; i <= N ; i++) {
            valueArray[i] = valueArray[i-1] + valueArray[i-2];
        }
        System.out.println(valueArray[N]);

    }

}

