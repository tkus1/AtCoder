package src.main.java.Typical90;

import java.util.Scanner;

public class Main033 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int unitCntH = H / 2;
        int unitCntW = W / 2;
        int residualCntH = H % 2;
        int residualCntW = W % 2;
        int ans = 0;
        if (unitCntH == 0 || unitCntW == 0) {
            ans = H * W;
        } else {
            ans = unitCntH * unitCntW + residualCntH * unitCntW + unitCntH * residualCntW + residualCntH * residualCntW;
        }
        System.out.println(ans);
    }
}
