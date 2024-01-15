package src.main.java.Typical90;

import java.util.HashMap;
import java.util.Scanner;

public class Main061 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int indexOffset = 100000;
        int startIndex = indexOffset;
        int endIndex = indexOffset;
        for (int i = 0; i < K; i++) {
            int t = scanner.nextInt();
            int x = scanner.nextInt();
            if (t == 1) {
                map.put(startIndex, x);
                startIndex -= 1;
            } else if (t == 2) {
                map.put(endIndex + 1, x);
                endIndex += 1;
            } else {
                int index = startIndex + x;
                System.out.println(map.get(index));
            }
        }
    }
}
