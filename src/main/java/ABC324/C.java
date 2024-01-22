package src.main.java.ABC324;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String T = sc.next();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String S = sc.next();
            if(Math.abs(S.length() - T.length()) > 1){
                continue;
            }
            if(S.length() == T.length()){
                if(isMatch(S,T)){
                    ans.add(i);
                }
                continue;
            }
            String longerStr;
            String shorterStr;
            if(S.length() > T.length()){
                longerStr = S;
                shorterStr = T;
            }else{
                longerStr = T;
                shorterStr = S;
            }
            if(isMatchLongShort(longerStr,shorterStr)){
                ans.add(i);
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }

    }
    public static boolean isMatch(String S, String T){
        int diffCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) != T.charAt(i)){
                diffCount++;
            }
        }
        if(diffCount <= 1){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isMatchLongShort(String longerStr, String shorterStr){
        int diffCount = 0;
        int longerStrOffset = 0;
        for (int i = 0; i < shorterStr.length(); i++) {
            if(longerStr.charAt(i + longerStrOffset) != shorterStr.charAt(i)){
                diffCount++;
                if(longerStrOffset < 1){
                    longerStrOffset++;
                    i--;
                }
            }
        }
        if(diffCount <= 1){
            return true;
        }else {
            return false;
        }
    }
}
