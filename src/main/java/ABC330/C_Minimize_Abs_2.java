package src.main.java.ABC330;

import java.util.Scanner;

public class C_Minimize_Abs_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long D = scanner.nextLong();
        long max = (long) Math.ceil(Math.sqrt(D));
        long minDist = Long.MAX_VALUE;
        for (long i = 1; i <= max; i++) {
            long thisValueI =  i *i;
            long residual = D - thisValueI;

            if(residual <= 0){
                minDist = Math.min(minDist, -residual);
            }else {
                long y;
                y= (long) Math.floor(Math.sqrt(residual));
                minDist =  Math.min(Math.abs(residual - y*y), minDist);
                y = (long) Math.ceil(Math.sqrt(residual));
                minDist =  Math.min(Math.abs(residual - y*y), minDist);

            }
        }
        System.out.println(minDist);

    }

}
