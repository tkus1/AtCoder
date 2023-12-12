package src.main.java.AlgorithmAndMath;

import java.util.ArrayList;
import java.util.Scanner;

public class Main026 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double expectation = 0;
        //ArrayList<ArrayList<Double>> table = new ArrayList<>();
        ArrayList<Double> previousArray = new ArrayList<>();
        previousArray.add(1.0);
        //table.add(firstLine);
        int i = 2;
        double epsilon = 10e-8;
        while(true){
            //ArrayList<Double> previousArray = table.getLast();
            ArrayList<Double> currentArray = new ArrayList<>();
            //handle k == 1
            currentArray.addLast(previousArray.getFirst() * (1/(double)N)) ;
            for(int k = 2;k < i; k++){
                currentArray.addLast(previousArray.get(k-2) * (((double)N - k + 1)/(double)N)
                                            +previousArray.get(k-1) * (k/(double)N));
            }
            //handle k == i
            currentArray.addLast(previousArray.get(i-2) * (((double)N - i + 1)/((double)N)) ) ;
            if (i >= N){
                expectation += (float) (currentArray.get((N-1)) * i);
                currentArray.set(N-1, (double) 0);
            }
            double probabilitySum = 0;
            for(double probability : currentArray){
                probabilitySum+= probability;
            }
            if (probabilitySum * i < epsilon){
                break;
            }
            //table.addLast(currentArray);
            previousArray = currentArray;
            i++;
        }
        System.out.println(expectation);
    }
}
