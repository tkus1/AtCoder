package src.main.java.ABC330;
import java.util.Scanner;

public class A_Counting_Passes{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int ansCnt = 0;
        for (int i = 0; i < N; i++) {
            if(scanner.nextInt() >= L){
                ansCnt++;
            }
        }
        System.out.println(ansCnt);
    }

}
