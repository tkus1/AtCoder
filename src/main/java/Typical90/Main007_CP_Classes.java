package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main007_CP_Classes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextInt());
        }
        A.sort((a,b)->a-b);
        int maxA = A.get(A.size()-1);
        int minA = A.get(0);
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int B = scanner.nextInt();
            if(B >= maxA){
                System.out.println(B - maxA);
                continue;
            }
            if(B <= minA){
                System.out.println(minA - B);
                continue;
            }
            int nearest = Helper.binarySearch(A, B);
            System.out.println(Math.abs(A.get(nearest) - B));
        }
    }
    public static class Helper{
        public static int binarySearch(ArrayList<Integer> A, int target){
            int left = 0;
            int right = A.size()-1;
            while(left <= right){
                if(left == right){
                    return left;
                }
                if(right - left == 1){
                    int distanceFromLeft = target - A.get(left);
                    int distanceFromRight = A.get(right) - target;
                    if(distanceFromLeft < distanceFromRight){
                        return left;
                    }else{
                        return right;
                    }
                }
                int midLeft = (left + right) / 2;
                int midRight = (left + right) / 2 + 1;
                int distanceFromMidLeft = target - A.get(midLeft);
                int distanceFromMidRight = A.get(midRight) - target;
                if(distanceFromMidLeft < distanceFromMidRight){
                    right = midLeft;
                }else{
                    left = midRight;
                }
            }
            return -1;
        }
    }
}
