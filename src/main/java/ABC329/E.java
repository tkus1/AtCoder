package src.main.java.ABC329;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class E {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String S = scanner.next();
        String T = scanner.next();
        char firstCharOfT = T.charAt(0);
        char lastCharOfT = T.charAt(T.length()-1);
        ArrayList <Character> middleCharsOfT = new ArrayList<>();
        for (int i = 1; i < T.length()-1; i++) {
            middleCharsOfT.add(T.charAt(i));
        }
        HashMap <Character, Integer> charIndexDict = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            if (charIndexDict.containsKey(T.charAt(i))){
                continue;
            }
            charIndexDict.put(T.charAt(i), i);

        }
        char firstChar = S.charAt(0);
        char lastChar = S.charAt(S.length()-1);
        if(firstChar != firstCharOfT || lastChar != lastCharOfT){
            System.out.println("No");
            return;
        }

        for (int i = 0; i < N-1; i++) {
            char thisChar = S.charAt(i);
            char nextChar = S.charAt(i+1);
            if(thisChar == firstCharOfT || middleCharsOfT.contains(thisChar)){
                int index = charIndexDict.get(thisChar);
                if(nextChar != firstCharOfT){
                    if(M == 1){
                        System.out.println("No");
                        return;
                    }
                    if(nextChar != T.charAt(index+1)){
                        System.out.println("No");
                        return;
                    }
                }
            }

        }
        System.out.println("Yes");
    }

}
