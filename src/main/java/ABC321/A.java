package src.main.java.ABC321;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.length()==1){
            System.out.println("Yes");
            return;
        }
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) <= s.charAt(i+1)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
