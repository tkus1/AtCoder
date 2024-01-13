package src.main.java.Typical90;
import java.util.*;

public class Main032 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    A[i][j] = scanner.nextInt();
            }
        }
        int M = scanner.nextInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            set.add(x + " " + y);
            set.add(y + " " + x);
        }
        List<int[]> permutations = Permutation.generatePermutations(N);
        int minSum = Integer.MAX_VALUE;
        for(int[] permutation : permutations){
            boolean isOk = true;
            for (int i = 0; i < N - 1; i++) {
                if(set.contains(permutation[i] + " " + permutation[i + 1])){
                    isOk = false;
                    break;
                }
            }
            if(isOk) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += A[permutation[i]][i];
                }
                minSum = Math.min(minSum, sum);
            }
        }
        if(minSum == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(minSum);
        }
    }
    public static class Permutation {

        private static List<int[]> generatePermutations(int N) {
            List<int[]> result = new ArrayList<>();
            int[] A = new int[N];
            for (int i = 0; i <N; i++) {
                A[i] = i;
            }
            permute(A, 0, A.length - 1, result);
            return result;
        }

        private static void permute(int[] A, int left, int right, List<int[]> result) {
            if (left == right) {
                result.add(Arrays.copyOf(A, A.length));
            } else {
                for (int i = left; i <= right; i++) {
                    swap(A, left, i);
                    permute(A, left + 1, right, result);
                    swap(A, left, i);  // バックトラック
                }
            }
        }

        private static void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
