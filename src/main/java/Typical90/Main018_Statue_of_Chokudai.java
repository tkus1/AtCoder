package src.main.java.Typical90;

import java.util.Scanner;

public class Main018_Statue_of_Chokudai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long T = scanner.nextInt();
        int L = scanner.nextInt();
        int X_statue = scanner.nextInt();
        int Y_statue = scanner.nextInt();
        int Q = scanner.nextInt();
        StringBuilder ansStr = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            long E = scanner.nextInt();
            double radian = 2 * Math.PI * E / T;
            double y_k = (double) -L / 2 * Math.sin(radian);
            double z_k = (double) L / 2 - (double) L / 2 * Math.cos(radian);
            double distance = Math.sqrt(Math.pow(X_statue, 2) + Math.pow(Y_statue - y_k, 2));
            ansStr.append(Math.toDegrees(Math.atan2(z_k, distance))).append("\n");
        }
        System.out.println(ansStr);
    }
}
