package src.main.java.ABC343;
import java.util.Scanner;
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long loopMax = (long) Math.cbrt(N);
        for (long i = loopMax; i > 0; i--) {
            if(isReverse(i * i * i)) {
                System.out.println(i * i * i);
                return;
            }
        }
    }
    public static boolean isReverse(long N) {
        int max = (String.valueOf(N).length()) / 2;
        String strN = String.valueOf(N);
        for (int i = 0; i < max; i++) {
            if(strN.charAt(i) != strN.charAt(strN.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
