package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main063 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] P = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W ; j++) {
                P[i][j] = scanner.nextInt();
            }
        }

        int maxValue = 0;
        int maxCnt = (int)Math.pow(2, H);

        for (int pattern = 1; pattern < maxCnt ; pattern++) {
            boolean[] flagList = new boolean[H];
            HashMap<Integer, Integer> maxCountMap = new HashMap<>();
            int devisor = maxCnt / 2;
            int index = H-1;
            int i_value = pattern;
            while(devisor > 0){
                if (i_value/devisor == 1){
                    flagList[index] = true;
                    i_value -= devisor;
                }else{
                    flagList[index] = false;
                }
                devisor /= 2;
                index -= 1;
            }
            for (int j = 0; j < W; j++) {
                HashSet<Integer> set = new HashSet<>();
                int cnt = 0;
                for (int i = 0; i < H; i++) {
                    if (flagList[i]) {
                        set.add(P[i][j]);
                        cnt++;
                    }
                }
                if (set.size() == 1) {
                    int value = set.iterator().next();
                    if(maxCountMap.containsKey(value)){
                        maxCountMap.put(value, maxCountMap.get(value) + cnt);
                    } else {
                        maxCountMap.put(value, cnt);
                    }
                }
            }
            int maxSameCnt = 0;
            for(int key: maxCountMap.keySet()){
                maxSameCnt = Math.max(maxCountMap.get(key), maxSameCnt);
            }
            maxValue = Math.max(maxValue, maxSameCnt);
        }
        System.out.println(maxValue);
    }
}

