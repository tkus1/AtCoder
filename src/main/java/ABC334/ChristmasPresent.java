package src.main.java.ABC334;

import java.util.Scanner;

public class ChristmasPresent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int B = scanner.nextInt();
        int G = scanner.nextInt();
        String state = "Bat";
        if(B < G){
            state = "Glove";
        }
        System.out.println(state);
    }

}
