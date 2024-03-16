package src.main.java.ABC343;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int sum = A + B;
        for (int i = 0; i < 10; i++) {
            if(sum != i) {
                System.out.println(i);
                break;
            }
        }

    }
}
