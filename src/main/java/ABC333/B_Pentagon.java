package src.main.java.ABC333;

import java.util.Scanner;

public class B_Pentagon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        Character S1 = S.charAt(0);
        Character S2 = S.charAt(1);
        String T = scanner.next();
        Character T1 = T.charAt(0);
        Character T2 = T.charAt(1);
        int distanceS1_S2 = Math.abs(S1.hashCode() - S2.hashCode());
        if (distanceS1_S2 > 2) {
            distanceS1_S2 = 5 - distanceS1_S2;
        }
        int distanceT1_T2 = Math.abs(T1.hashCode() - T2.hashCode());
        if (distanceT1_T2 > 2) {
            distanceT1_T2 = 5 - distanceT1_T2;
        }
        if(distanceS1_S2 == distanceT1_T2){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

}
