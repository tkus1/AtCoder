package src.main.java.Typical90;

import java.util.HashMap;
import java.util.Scanner;

public class Main027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String userNames = scanner.next();
            if(map.get(userNames) == null) {
                map.put(userNames, 1);
                System.out.println(i);
            }else {
                map.put(userNames, map.get(userNames) + 1);
            }
        }
    }
}
