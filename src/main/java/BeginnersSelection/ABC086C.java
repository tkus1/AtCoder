package src.main.java.BeginnersSelection;

import java.util.Scanner;

public class ABC086C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] t = new int[N+1];
        int[] x = new int[N+1];
        int[] y = new int[N+1];
        t[0] = 0;
        x[0] = 0;
        y[0] = 0;
        for (int i = 1; i <= N; i++) {
            t[i] = scanner.nextInt();
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        boolean canArrive = true;
        for (int i = 0; i < N; i++) {
            int distance = Helper.getDistance(x[i],y[i],x[i+1],y[i+1]);
            int period = t[i+1] - t[i];
            if(distance > period){
                canArrive = false;
                break;
            }
            if(Math.floorMod(distance - period, 2) == 1){
                canArrive = false;
                break;
            }

        }

        String state = "Yes";
        if(!canArrive){
            state = "No";
        }
        System.out.println(state);

    }
    public static class Helper{
        public static int getDistance(int x1, int y1, int x2, int y2){
            return Math.abs(x1-x2) +Math.abs(y1 - y2);
        }
    }

}
