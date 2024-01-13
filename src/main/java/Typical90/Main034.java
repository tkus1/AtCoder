package src.main.java.Typical90;

import java.util.*;

public class Main034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[N];
        int startPoint = 0;
        int longestSubArray = 0;
        for (int endPoint = 0; endPoint < N; endPoint++) {
            if (map.get(A[endPoint]) == null) {
                map.put(A[endPoint], 1);
            } else {
                map.put(A[endPoint], map.get(A[endPoint]) + 1);
            }
            if(map.size() <= K){
                longestSubArray = Math.max(longestSubArray, endPoint - startPoint + 1);
            }
            if(map.size() > K){
                while (map.size() > K) {
                    map.put(A[startPoint], map.get(A[startPoint]) - 1);
                    if (map.get(A[startPoint]) == 0) {
                        map.remove(A[startPoint]);
                    }
                    startPoint++;
                }
            }
        }
        System.out.println(longestSubArray);
    }

}
