package src.main.java.ABC329;

import java.util.HashSet;
import java.util.Scanner;

public class F {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        HashSet<Integer>[] boxes = new HashSet[N+1];
        for (int i = 1; i < N+1; i++) {
            boxes[i] = new HashSet<>();
            boxes[i].add(scanner.nextInt());
        }
        for (int i = 0; i < Q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if(boxes[b].isEmpty()){
                boxes[b] = boxes[a];
            } else{
                if(boxes[b].size() > boxes[a].size()){
                    boxes[b].addAll(boxes[a]);
                } else {
                    boxes[a].addAll(boxes[b]);
                    boxes[b] = boxes[a];
                }
            }
            boxes[a] = new HashSet<>();
            System.out.println(boxes[b].size());
        }
    }
}
