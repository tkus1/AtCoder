package src.main.java.ABC344;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < S.length(); i++) {

            if(!flag && S.charAt(i) == '|') {
                flag = true;
                continue;
            }
            if(flag && S.charAt(i) == '|') {
                flag = false;
                continue;
            }
            if(!flag) {
                sb.append(S.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
