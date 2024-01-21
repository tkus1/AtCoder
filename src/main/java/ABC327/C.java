package src.main.java.ABC327;

import java.util.HashSet;
import java.util.Scanner;

public class C {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 9;
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            int[] subArrayCol = new int[N];
            int[] subArrayRow = new int[N];
            for (int j = 0; j < N; j++) {
                subArrayCol[j] = A[j][i];
                subArrayRow[j] = A[i][j];
            }
            if(!isContainAllNumber(subArrayCol) || !isContainAllNumber(subArrayRow)){
                System.out.println("No");
                return;
            }
        }
        for (int i = 0; i < N; i+=3) {
            for (int j = 0; j < N; j+=3) {
                int[] subArray = new int[N];
                int index = 0;
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        subArray[index] = A[k][l];
                        index++;
                    }
                }
                if(!isContainAllNumber(subArray)){
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
    public static boolean isContainAllNumber(int[] array){
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        if(set.size() == 9){
            return true;
        }
        return false;
    }
}
