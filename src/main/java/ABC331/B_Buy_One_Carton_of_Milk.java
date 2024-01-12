package src.main.java.ABC331;

import java.util.Scanner;

public class B_Buy_One_Carton_of_Milk {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();
        int L = scanner.nextInt();
        int minPx = Integer.MAX_VALUE;
        int maxScnt = N / 6 + 1;
        int maxMcnt = N / 8 + 1;
        int maxLcnt = N / 12 + 1;
        for (int i = 0; i <= maxScnt; i++) {
            for (int j = 0; j <= maxMcnt; j++) {
                for (int k = 0; k <= maxLcnt; k++) {
                    if(i * 6 + j * 8 + k * 12 < N){
                        continue;
                    }
                    int totalPx = i * S + j * M + k * L;
                    minPx = Math.min(minPx, totalPx);
                }


            }
        }

        System.out.println(minPx);
    }
    Scanner scanner = new Scanner(System.in);
    int M = scanner.nextInt();
    int D = scanner.nextInt();

}
