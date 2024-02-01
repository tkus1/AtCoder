package src.main.java.ABC321;

import java.security.Key;
import java.util.ArrayList;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K  = sc.nextInt();

        if(K < 10){
            System.out.println(K);
            return;
        }
        int[] ans = new int[10];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = 0;
        }
        int cnt = -1;
        outerloop:
        for (int i = 0; i < 10; i++) {
            if(i==0){
                ans[0]= 10;
            }else{
                ans[0] = i;
            }
            for (int j = 0; j < ans[0]; j++) {
                if(j==0 && ans[0] == 10){
                    ans[1] = 10;
                }else{
                    ans[1] = j;
                }
                for (int k = 0; k < ans[1]; k++) {
                    if (k==0&& ans[1] == 10){
                        ans[2] = 10;
                    }else{
                        ans[2] = k;
                    }
                    for (int l = 0; l < ans[2]; l++) {
                        if(l==0&& ans[2] == 10){
                            ans[3] = 10;
                        }else{
                            ans[3] = l;
                        }
                        for (int m = 0; m < ans[3]; m++) {
                            if (m==0&& ans[3] == 10){
                                ans[4] = 10;
                            }else{
                                ans[4] = m;
                            }
                            for (int n = 0; n < ans[4]; n++) {
                                if (n==0&& ans[4] == 10){
                                    ans[5] = 10;
                                }else{
                                    ans[5] = n;
                                }
                                for (int o = 0; o < ans[5]; o++) {
                                    if (o==0&& ans[5] == 10){
                                        ans[6] = 10;
                                    }else{
                                        ans[6] = o;
                                    }
                                    for (int p = 0; p < ans[6]; p++) {
                                        if (p==0&& ans[6] == 10){
                                            ans[7] = 10;
                                        }else{
                                            ans[7] = p;
                                        }
                                        for (int q = 0; q < ans[7]; q++) {
                                            if (q==0&& ans[7] == 10){
                                                ans[8] = 10;
                                            }else{
                                                ans[8] = q;
                                            }
                                            for (int r = 0; r < ans[8]; r++) {
                                                ans[9] = r;

                                                cnt ++;
                                                if(cnt == K){
                                                    break outerloop;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if(ans[i] == 10){
                sb.append(0);
                continue;
            }
            sb.append(ans[i]);
        }

        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                i--;
            }else {
                break;
            }
        }
        System.out.println(sb);


    }
}
