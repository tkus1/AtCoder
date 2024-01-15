package src.main.java.Typical90;

import java.util.HashMap;
import java.util.Scanner;
public class Main044 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int A = scanner.nextInt();
            map.put(i, A);
        }
        int indexOffset = N;
        for (int i = 0; i < Q; i++) {
            int T = scanner.nextInt();
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            if (T == 1) {
                int indexOfX1 = Math.floorMod(x1 + indexOffset,N);
                if (indexOfX1 == 0) {
                    indexOfX1 = N;
                }
                int indexOfX2 = Math.floorMod(x2 + indexOffset,N);
                if (indexOfX2 == 0) {
                    indexOfX2 = N;
                }
                int valueOfX1 = map.get(indexOfX1);
                int valueOfX2 = map.get(indexOfX2);
                map.put(indexOfX1, valueOfX2);
                map.put(indexOfX2, valueOfX1);
                continue;
            }
            if (T == 2) {
                indexOffset -= 1;
                continue;
            } else {
                int index = Math.floorMod(x1 + indexOffset,N);
                if (index == 0) {
                    index = N;
                }
                System.out.println(map.get(index));
            }
        }
    }
}
