package src.main.java.ABC332;

import java.util.Scanner;

public class C_T_shirts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String S = scanner.next();
        int logoTcnt = 0;
        int availableLogoTcnt = 0;
        int availableMujiTcnt = M;
        for (int i = 0; i < N; i++) {
            if(S.charAt(i) == '0'){
                availableMujiTcnt = M;
                availableLogoTcnt = logoTcnt;
                continue;
            }
            if(S.charAt(i) == '1'){
                if(availableMujiTcnt > 0){
                    availableMujiTcnt--;
                    continue;
                }
                if(availableLogoTcnt > 0){
                    availableLogoTcnt--;
                    continue;
                }
                logoTcnt++;
                continue;
            }
            if(S.charAt(i) == '2'){
                if(availableLogoTcnt > 0){
                    availableLogoTcnt--;
                    continue;
                }
                logoTcnt++;
            }
        }
        System.out.println(logoTcnt);
    }

}
