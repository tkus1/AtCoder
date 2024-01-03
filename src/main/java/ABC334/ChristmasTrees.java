package src.main.java.ABC334;

import java.util.Scanner;

public class ChristmasTrees {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long M = scanner.nextInt();
        long L = scanner.nextLong();
        long R = scanner.nextLong();
        long ansCnt = 0;
        long criteriaMod = Math.floorMod(A, M);
        long residualDistance = 0;
        long lMod = Math.floorMod(L,M);
        long startPointOffset;
        if(criteriaMod < lMod){
            startPointOffset = M - lMod + criteriaMod;
        }else{
            startPointOffset = criteriaMod - lMod;
        }
        long leftMostPoint = L + startPointOffset;

        if(R < leftMostPoint){
            ansCnt = 0;
        }else if(R == leftMostPoint){
            ansCnt = 1;
        }else if(leftMostPoint < R){
            long distance = R - leftMostPoint;
            ansCnt = 1 + distance / M;
        }
        System.out.println(ansCnt);
        /*
        for (long i = L; i <= R; i++) {
            if (Math.floorMod(i, M) == criteriaMod) {
                ansCnt++;
                residualDistance = R - i;
                break;
            }
        }
        if(residualDistance > 0){
            ansCnt += residualDistance / M;
        }




        System.out.println(ansCnt);

         */
    }

}
