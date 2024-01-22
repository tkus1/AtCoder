package src.main.java.ABC324;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        while(true){
            if(N == 1){
                System.out.println("Yes");
                return;
            }
            if(N % 2 == 0){
                N /= 2;
                continue;
            }else if (N % 3 == 0 ){
                N /= 3;
                continue;
            }
            System.out.println("No");
            return;
        }
    }
}
