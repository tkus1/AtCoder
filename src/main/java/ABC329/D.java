package src.main.java.ABC329;

import java.util.HashMap;
import java.util.Scanner;

public class D {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[]A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCnt = 0;
        int maxPerson = 0;
        for (int i = 0; i < M; i++) {
            if(map.containsKey(A[i])){
                map.put(A[i], map.get(A[i])+1);
            }else{
                map.put(A[i], 1);
            }
            if(i==0){
                maxCnt = 1;
                maxPerson = A[i];
            }else{
                if(map.get(A[i]) > maxCnt){
                    maxCnt = map.get(A[i]);
                    maxPerson = A[i];
                } else if (map.get(A[i]) == maxCnt){
                    maxPerson = Math.min(maxPerson, A[i]);
                }
            }
            System.out.println(maxPerson);
        }
    }
}
