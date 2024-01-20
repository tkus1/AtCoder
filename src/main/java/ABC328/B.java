package src.main.java.ABC328;

import java.util.Scanner;

public class B {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = scanner.nextInt();
        }
        int month;
        int day;

        int ans = 0;
        for (int i = 0; i < N; i++) {
            month = i+1;
            for (int j = 0; j < D[i]; j++) {
                boolean flag = true;
                day = j+1;
                StringBuilder sb = new StringBuilder();
                sb.append(month).append(day);
                for (int k = 0; k < sb.length()-1; k++) {
                  if(sb.charAt(k) != sb.charAt(k+1)){
                      flag = false;
                      break;
                  }
                }
                if(flag){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
