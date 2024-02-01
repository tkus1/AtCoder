package src.main.java.ABC322;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K  = sc.nextInt();
        int P = sc.nextInt();
        long[] cost = new long[N];
        int[][]value = new int[N][K];
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            for (int j = 0; j < K; j++) {
                value[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            a.add(0);
        }
        HashMap<ArrayList<Integer>,Long> map = new HashMap<>();
        map.put(new ArrayList<Integer>(a),0L);
        for (int i = 0; i < N; i++) {
            HashMap<ArrayList<Integer>,Long> newMap = new HashMap<>();
            for (ArrayList<Integer> key : map.keySet()) {
                ArrayList<Integer> newKey = new ArrayList<>();
                if(!newMap.containsKey(key)){
                    newMap.put(key,map.get(key));
                }else{
                    newMap.put(key,Math.min(map.get(key),newMap.get(key)));
                }

                long orgCost = map.get(key);
                for (int j = 0; j < K; j++) {
                    newKey.add(Math.min(key.get(j) + value[i][j],P));
                }
                if(!newMap.containsKey(newKey)){
                    newMap.put(newKey,cost[i]+orgCost);
                    continue;
                }
                newMap.put(newKey,Math.min(orgCost + cost[i], newMap.get(newKey)));
            }
            map = newMap;
        }
        ArrayList<Integer> target = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            target.add(P);
        }
        if(map.containsKey(target)){
            System.out.println(map.get(target));
        } else {
            System.out.println(-1);
        }
    }

}
