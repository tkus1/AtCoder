package src.main.java.ABC326;

import java.util.Scanner;

public class B {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; N+i <1000 ; i++) {
            if(is326LikeNumber(String.valueOf(N+i))){
                System.out.println(N+i);
                return;
            }
        }
    }
    public static boolean is326LikeNumber(String number){
        int digit100 = Integer.parseInt(number.substring(0,1));
        int digit10 = Integer.parseInt(number.substring(1,2));
        int digit1 = Integer.parseInt(number.substring(2,3));
        if(digit100 * digit10 == digit1){
            return true;
        }else {
            return false;
        }
    }
}
