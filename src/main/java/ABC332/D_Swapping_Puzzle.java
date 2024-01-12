package src.main.java.ABC332;

import java.util.*;

public class D_Swapping_Puzzle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] A = new int[H][W];
        int[][] B = new int[H][W];

        //Aの読み込み
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W ; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        //Bの読み込み
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W ; j++) {
                B[i][j] = scanner.nextInt();
            }
        }
        int[] P = new int[H];
        for (int i = 0; i < H; i++) {
            P[i] = i;
        }
        List<int[]> permutationsP = Helper.generatePermutations(P);

        int[] Q = new int[W];
        for (int i = 0; i < W; i++) {
            Q[i] = i;
        }
        List<int[]> permutationsQ = Helper.generatePermutations(Q);
        int minOperationCnt = Integer.MAX_VALUE;
        int[] ansP;
        int[] ansQ;
        for (int[] permutationP : permutationsP) {
            for (int[] permutationQ : permutationsQ) {
                int[][] C = new int[H][W];
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        C[i][j] = A[permutationP[i]][permutationQ[j]];
                    }
                }
                if(Helper.equals(C, B)){
                    ansP = permutationP;
                    ansQ = permutationQ;
                    int inverseCntP;
                    int inverseCntQ;
                    inverseCntP = Helper.bubbleSortCnt(ansP);
                    inverseCntQ = Helper.bubbleSortCnt(ansQ);
                    int operationCnt = inverseCntP + inverseCntQ;
                    minOperationCnt = Math.min(operationCnt,minOperationCnt);
                }
            }
        }
        if(minOperationCnt == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(minOperationCnt);
    }
    public static class Helper{
        public static List<int[]> generatePermutations(int[] array) {
            List<int[]> result = new ArrayList<>();
            generatePermutationsHelper(array, 0, result);
            return result;
        }

        public static void generatePermutationsHelper(int[] array, int index, List<int[]> result) {
            if (index == array.length - 1) {
                result.add(Arrays.copyOf(array, array.length));
            } else {
                for (int i = index; i < array.length; i++) {
                    swap(array, index, i);
                    generatePermutationsHelper(array, index + 1, result);
                    swap(array, index, i);
                }
            }
        }

        private static void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        static int bubbleSortCnt(int[] list){
            int cnt = 0;
            for (int i = 0; i < list.length; i++) {
                for (int j = list.length-1; j > i; j--) {
                    if(list[j] < list[j-1]){
                        int tmp = list[j];
                        list[j] = list[j-1];
                        list[j-1] = tmp;
                        cnt++;
                    }
                }
            }
            return cnt;

        }
        static boolean equals(int[][] A, int[][] B){
            for (int i = 0; i < A.length; i++) {
                if(!Arrays.equals(A[i], B[i])){
                    return false;
                }
            }
            return true;
        }
    }
}
