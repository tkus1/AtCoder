package src.main.java.ABC324;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String T = sc.next();
        int[] laterSubstrCnt = new int[T.length()+1];
        int[] sumLaterSubstrCnt = new int[T.length()+1];
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = sc.next();
        }
        for (int i = 0; i < N; i++) {
            String reverseS = new StringBuilder(S[i]).reverse().toString();
            String reverseT = new StringBuilder(T).reverse().toString();
            laterSubstrCnt[matchCnt(reverseS,reverseT)] += 1;
        }
        sumLaterSubstrCnt[T.length()] = laterSubstrCnt[T.length()];
        for (int i = T.length()-1; i >=0; i--) {
            sumLaterSubstrCnt[i] = sumLaterSubstrCnt[i+1] + laterSubstrCnt[i];
        }
        long ans = 0;
        for (int i = 0; i < N; i++) {
            int matchCnt = matchCnt(S[i],T);
            int reverseMatchCnt = matchCnt(new StringBuilder(S[i]).reverse().toString(),new StringBuilder(T).reverse().toString());
            ans += sumLaterSubstrCnt[T.length() - matchCnt];

        }
        System.out.println(ans);

    }
    public static int matchCnt(String S, String T){
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {

            if(S.charAt(i) == T.charAt(cnt)){
                cnt++;
            }
            if(cnt == T.length()){
                break;
            }
        }
        return cnt;
    }
}
