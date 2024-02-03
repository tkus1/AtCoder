package src.main.java.ABC319;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if(N % i == 0) {
                list.add(i);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            if(i == 0){
                sb.append(list.get(0));
                continue;
            }
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if(i % (N/list.get(j)) == 0){
                    sb.append(list.get(j));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                sb.append("-");
            }
        }
        System.out.println(sb.toString());
    }
}
