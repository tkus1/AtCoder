package src.main.java.BeginnersSelection;

import java.util.Scanner;

public class ABC049C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        StringBuilder T = new StringBuilder();
        final String ERASER = "eraser";
        final String DREAMER = "dreamer";
        final String DREAM = "dream";
        final String ERASE = "erase";
        int index = S.length();

        boolean canConstruct = true;
        while(index > 0){
            String decide_er_word = S.substring(index - 2, index);
            if(decide_er_word.equals("er")){
                String decide_eraser = S.substring(index - 6, index);
                if(decide_eraser.equals(ERASER)){
                    index = index -6;
                    continue;
                }
                String decide_dreamer = S.substring(index - 7, index);
                if(decide_dreamer.equals(DREAMER)){
                    index = index - 7;
                    continue;
                }
            }
            String lastFiveChars = S.substring(index - 5, index);
            if(lastFiveChars.equals(ERASE) || lastFiveChars.equals(DREAM)){
                index = index - 5;
                continue;
            }
            canConstruct = false;
            break;
        }
        String state = "YES";
        if(!canConstruct){
            state = "NO";
        }
        System.out.println(state);
    }
}
