package src.main.java.AlgorithmAndMath;
import java.util.LinkedList;
import java.util.Scanner;

public class Main011 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        LinkedList<Integer> primeNumberList = new LinkedList<>();
        for(int i = 2; i <= N; i++){
            if(primeNumberList.isEmpty()) {
                primeNumberList.add(i);
                continue;
            }
            Boolean isPrime = true;
            for(int primeNumber: primeNumberList){
                if(Math.floorMod(i, primeNumber) == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeNumberList.add(i);
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        for(Integer prime : primeNumberList){
            stringBuilder.append(prime).append(" ");
        }
        stringBuilder.delete(stringBuilder.length(),stringBuilder.length());
        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString());
    }

}

