package src.main.java.ABC324;

import java.lang.reflect.Array;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();
        if(Objects.equals(S, "0")){
            System.out.println(1);
            return;
        }
        HashSet<Long> squares = new HashSet<>();

        long loopMax = (long)Math.sqrt(Math.pow(10, N));

        for (long i = 1; i <= loopMax; i++) {
            squares.add(i * i);
        }
        long ans = 0;
        for(long square : squares){
            StringBuilder squareStr = new StringBuilder(String.valueOf(square));
            if(squareStr.length() > S.length()){
                continue;
            }
            for (int i = 0; i < S.length(); i++) {
                boolean find = false;
                for (int j = 0; j < squareStr.length(); j++) {
                    if(S.charAt(i) == squareStr.charAt(j)){
                        squareStr.deleteCharAt(j);
                        find = true;
                        break;
                    }
                }
                if(!find && S.charAt(i) != '0'){
                    break;
                }
                if(i==S.length()-1 && squareStr.isEmpty()){
                    ans++;
                }

            }
        }
        System.out.println(ans);
    }
}
