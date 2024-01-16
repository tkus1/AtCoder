package src.main.java.ABC329;

import java.util.HashMap;
import java.util.Scanner;

public class C {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String S = scanner.next();
        int startIndex = 0;
        int endIndex = 0;
        HashMap<Character,Integer> charCnt = new HashMap<>();
        char prevChar = S.charAt(0);
        while(endIndex < N){
            char nextChar = S.charAt(endIndex);

            if(nextChar == prevChar){
                endIndex++;
                if(endIndex == N){
                    int length = endIndex - startIndex;
                    if(charCnt.containsKey(prevChar)){
                        charCnt.put(prevChar, Math.max(charCnt.get(prevChar) , length));
                    }else{
                        charCnt.put(prevChar, length);
                    }
                }
                continue;
            }
            int length = endIndex - startIndex;
            if(charCnt.containsKey(prevChar)){
                charCnt.put(prevChar, Math.max(charCnt.get(prevChar) , length));
            }else{
                charCnt.put(prevChar, length);
            }
            startIndex = endIndex;
            prevChar = nextChar;
        }
        int ans = 0;
        for (Character character : charCnt.keySet()) {
            ans += charCnt.get(character);
        }
        System.out.println(ans);
    }
}
