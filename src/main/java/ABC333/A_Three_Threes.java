package src.main.java.ABC333;

import java.util.Scanner;

public class A_Three_Threes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < N; i++) {
            stringBuffer.append(Integer.toString(N));
        }
        System.out.println(stringBuffer);
    }

}
