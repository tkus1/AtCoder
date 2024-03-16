package src.main.java.ABC343;

import java.util.HashMap;
import java.util.Scanner;
public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, N);
        long[] scores = new long[N];
        for (int i = 0; i < T; i++) {
            int player = scanner.nextInt();
            long addPoint = scanner.nextLong();
            long prevScore = scores[player-1];
            long newScore = prevScore + addPoint;
            scores[player-1] = newScore;
            int numOfPlayerOnPrevScore = map.get(prevScore);
            int numOfPlayerOnNewScore = map.getOrDefault(newScore, 0);
            map.put(prevScore, numOfPlayerOnPrevScore - 1);
            if (map.get(prevScore)==0) map.remove(prevScore);
            map.put(newScore, numOfPlayerOnNewScore + 1);
            System.out.println(map.keySet().size());
        }
    }
}
