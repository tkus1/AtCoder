package src.main.java.ABC321;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N-1; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int minNum = list.remove(0);
        int maxNum = list.remove(list.size()-1);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        int dif = X - sum;
        int ans;
        if(dif <= minNum){
            ans = 0;
        }
        else if (dif <= maxNum){
            ans = dif;
        } else {
            ans = -1;
        }
        System.out.println(ans);
    }
}
