package src.main.java.ABC332;

import java.util.*;

public class D_Swapping_Puzzle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] A = new int[H][W];
        int[][] B = new int[H][W];
        ArrayList<Integer>[] ACol = new ArrayList[W];
        ArrayList<Integer>[] BCol = new ArrayList[W];
        ArrayList<Integer>[] ARow = new ArrayList[H];
        ArrayList<Integer>[] BRow = new ArrayList[H];

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

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(ACol[j] == null){
                    ACol[j] = new ArrayList<Integer>();
                }
                if(ARow[i] == null){
                    ARow[i] = new ArrayList<Integer>();
                }
                ARow[i].add(A[i][j]);
                ACol[j].add(A[i][j]);
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(BCol[j] == null){
                    BCol[j] = new ArrayList<Integer>();
                }
                if(BRow[i] == null){
                    BRow[i] = new ArrayList<Integer>();
                }
                BRow[i].add(B[i][j]);
                BCol[j].add(B[i][j]);
            }
        }
        for (int i = 0; i < H; i++) {
            Collections.sort(ARow[i]);
            Collections.sort(BRow[i]);
        }
        for (int j = 0; j < W; j++) {
            Collections.sort(ACol[j]);
            Collections.sort(BCol[j]);
        }
        Set<ArrayList<Integer>> rowSetA = new HashSet<>(List.of(ACol));
        Set<ArrayList<Integer>> rowSetB = new HashSet<>(List.of(BCol));
        boolean isMatchRows = rowSetA.equals(rowSetB);


        Set<ArrayList<Integer>> colSetA = new HashSet<>(List.of(ACol));
        Set<ArrayList<Integer>> colSetB = new HashSet<>(List.of(BCol));
        boolean isMatchCols = colSetA.equals(colSetB);

        if(!isMatchRows || !isMatchCols) {
            System.out.println("-1");
            return;
        }
        ArrayList<Integer> targetARow = ARow[0];
        ArrayList<Integer> targetACol = ACol[0];
        int matchedBRowNum = 0;

        for (int i = 0; i < H; i++) {
            if(targetARow.equals(BRow[i])){
                matchedBRowNum = i;
                break;
            }
        }

        ArrayList<Integer> orderRow = new ArrayList<>();
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < W; j++) {
                if(A[0][i] == B[matchedBRowNum][j] && !orderRow.contains(j)){
                    orderRow.add(j);
                }
            }
        }
        int[][] Bnew = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int thisOrder = orderRow.get(j);
                Bnew[i][thisOrder] = B[i][j];
            }
        }


        ArrayList<Integer>[] BColNew = new ArrayList[W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(BColNew[j] == null){
                    BColNew[j] = new ArrayList<Integer>();
                }
                BColNew[j].add(Bnew[i][j]);
            }
        }
        for (int j = 0; j < W; j++) {
            Collections.sort(BColNew[j]);
        }
        int matchedBColNum = 0;
        int operationCntRow = Helper.bubbleSortCnt(orderRow);
        for (int i = 0; i < W; i++) {
            if(targetACol.equals(BColNew[i])){
                matchedBColNum = i;
                break;
            }
        }
        ArrayList<Integer> orderCol = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < H; j++) {
                if(A[i][0] == Bnew[j][matchedBColNum] && !orderCol.contains(j)){
                    orderCol.add(j);
                }
            }

        }
        int operationCntCol = Helper.bubbleSortCnt(orderCol);
        int operationCnt = operationCntRow + operationCntCol;
        System.out.println(operationCnt);
    }
    public static class Helper{
        static int bubbleSortCnt(ArrayList<Integer>list){
            int cnt = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = list.size()-1; j > i; j--) {
                    if(list.get(j-1) > list.get(j)){
                        Collections.swap(list, j-1, j);
                        cnt++;
                    }
                }
            }
            return cnt;

        }
    }
}
