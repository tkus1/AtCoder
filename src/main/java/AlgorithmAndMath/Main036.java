package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main036 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        long radiusA = scanner.nextLong();
        long radiusB = scanner.nextLong();
        long hour = scanner.nextLong();
        long minute = scanner.nextLong();
        double thetaH =(( (double)hour + ((double)minute/60) )/ 12) * (2 * Math.PI);
        double thetaM =((double) minute / 60) * (2 * Math.PI);

        double AX = radiusA * Math.cos(thetaH);
        double AY = radiusA * Math.sin(thetaH);
        double BX = radiusB * Math.cos(thetaM);
        double BY = radiusB * Math.sin(thetaM);

        System.out.println(getDistance(AX,AY,BX,BY));

    }
    private static double getDistance (double AX, double AY, double BX, double BY){
        double diffX = AX - BX;
        double diffY = AY - BY;
        return (Math.sqrt((diffX * diffX) +(diffY * diffY)));
    }
}
