package src.main.java.ABC343;
import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if(scanner.nextInt() == 1) {
                    sb.append(j+1).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }


    }
}
