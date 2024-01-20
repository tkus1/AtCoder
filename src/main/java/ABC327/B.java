package src.main.java.ABC327;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        long B = scanner.nextLong();
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            long value = 1;
            for (int j = 0; j < i; j++) {
                value *= i;
            }
            list.add(value);
        }

        if(!list.contains(B)){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == B){
                System.out.println(i+1);
                return;
            }
        }
    }
}
