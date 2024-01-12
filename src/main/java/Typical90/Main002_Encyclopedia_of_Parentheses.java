package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main002_Encyclopedia_of_Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if(N % 2 == 1){
            return;
        }
        ArrayList<String> ansList = new ArrayList<>();
        List<List<Integer>> P = Permutations.generateCombinations(N);
        for(List<Integer> p : P){
            boolean isOk = true;
            char[] pChar = new char[N];
            Arrays.fill(pChar, '(');
            for(int i = 0; i < N/2; i++){
                pChar[p.get(i)-1] = ')';
            }
            int rightParenthesesCnt = 0;
            for(int i = 0; i < N; i++){
                if(pChar[i] == '('){
                    rightParenthesesCnt++;
                }else{
                    rightParenthesesCnt--;
                }
                if(rightParenthesesCnt < 0){
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                StringBuilder ansStr = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    ansStr.append(pChar[i]);
                }
                ansStr.append("\n");
                ansList.add(ansStr.toString());
            }
        }
        ansList.sort(String::compareTo);
        for(String ans : ansList){
            System.out.print(ans);
        }
    }

    public class Permutations {
        public static List<List<Integer>> generateCombinations(int N) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> currentCombination = new ArrayList<>();

            generateCombinationsHelper(N, 1, N / 2, currentCombination, result);

            return result;
        }
        public static void generateCombinationsHelper(int N, int start, int remaining, List<Integer> currentCombination, List<List<Integer>> result) {
            if (remaining == 0) {
                // N/2個の数字が選ばれた場合、組み合わせを結果に追加
                result.add(new ArrayList<>(currentCombination));
                return;
            }

            for (int i = start; i <= N; i++) {
                currentCombination.add(i);
                generateCombinationsHelper(N, i + 1, remaining - 1, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1); // バックトラック
            }
        }
    }
}
