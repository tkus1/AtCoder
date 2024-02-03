package src.main.java.ABC319;

import java.util.ArrayList;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> grid = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            grid.add(sc.nextInt());
        }
        int cnt = 0;
        ArrayList<ArrayList<Integer>> permutations = getPermutations();
        for (ArrayList<Integer> permutation : permutations){
            ArrayList<Integer> col1 = new ArrayList<>();
            ArrayList<Integer> col2 = new ArrayList<>();
            ArrayList<Integer> col3 = new ArrayList<>();
            ArrayList<Integer> row1 = new ArrayList<>();
            ArrayList<Integer> row2 = new ArrayList<>();
            ArrayList<Integer> row3 = new ArrayList<>();
            ArrayList<Integer> diag1 = new ArrayList<>();
            ArrayList<Integer> diag2 = new ArrayList<>();
            for(int i : permutation){
                if(i <= 3){
                    row1.add(grid.get(i-1));
                } else if(i <= 6){
                    row2.add(grid.get(i-1));
                } else {
                    row3.add(grid.get(i-1));
                }
                if(i % 3 == 1){
                    col1.add(grid.get(i-1));
                } else if(i % 3 == 2){
                    col2.add(grid.get(i-1));
                } else {
                    col3.add(grid.get(i-1));
                }
                if(i==1 || i==5 || i==9){
                    diag1.add(grid.get(i-1));
                }
                if(i==3 || i==5 || i==7){
                    diag2.add(grid.get(i-1));
                }
            }
            if(check(col1) && check(col2) && check(col3) && check(row1) && check(row2) && check(row3) && check(diag1) && check(diag2)){
                cnt++;
            }
        }
        double ans = (double) cnt / 362880;
        System.out.println(ans);
    }
    public static ArrayList<ArrayList<Integer>> getPermutations() {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        ArrayList<Integer> permutation = new ArrayList<>();
        permutationsHelper(permutation, permutations);
        return permutations;
    }

    public static void permutationsHelper(ArrayList<Integer> permutation, ArrayList<ArrayList<Integer>> permutations) {
        if (permutation.size() == 9) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (permutation.contains(i)) {
                continue;
            }
            permutation.add(i);
            permutationsHelper(permutation, permutations);
            permutation.remove(permutation.size() - 1);
        }
    }
    public static boolean check(ArrayList<Integer> list){
        if(list.get(0)!= list.get(1)){
            return true;
        }
        if(list.get(1)== list.get(2)){
            return true;
        }
        return false;
    }
}
