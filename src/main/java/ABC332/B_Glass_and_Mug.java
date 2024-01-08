package src.main.java.ABC332;

import java.util.Scanner;

public class B_Glass_and_Mug {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int G = scanner.nextInt();
        int M = scanner.nextInt();
        Cup glass = new Cup(G,0);
        Cup mug = new Cup(M,0);
        for (int i = 0; i < K; i++) {
            if(glass.getCurrentAmount() == glass.getCapacity()) {
                glass.setCurrentAmount(0);
                continue;
            }
            if(mug.getCurrentAmount() == 0){
                mug.setCurrentAmount(mug.getCapacity());
                continue;
            }
            int pourAmt = Math.min(glass.getCapacity() - glass.getCurrentAmount(), mug.getCurrentAmount());
            mug.setCurrentAmount(mug.getCurrentAmount() - pourAmt);
            glass.setCurrentAmount(glass.getCurrentAmount() + pourAmt);
        }
        System.out.println(glass.getCurrentAmount() + " " + mug.getCurrentAmount());
    }
    public static class Cup {
        private final int capacity;
        private int currentAmount;

        public Cup(int capacity, int currentAmount) {
            this.capacity = capacity;
            this.currentAmount = currentAmount;
        }

        public int getCapacity() {
            return capacity;
        }

        public int getCurrentAmount() {
            return currentAmount;
        }

        public void setCurrentAmount(int currentAmount) {
            this.currentAmount = currentAmount;
        }
    }
}
