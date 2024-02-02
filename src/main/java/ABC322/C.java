package src.main.java.ABC322;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = sc.nextInt();
        }
        int index = 0;
        for (int i = 1; i < N+1; i++) {

            int diff = A[index] - i;
            System.out.println(diff);
            if(diff == 0){
                index++;
            }
        }
    }
}
