package src.main.java.ABC329;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            sb.append(S.charAt(i)).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
