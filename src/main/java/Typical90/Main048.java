package src.main.java.Typical90;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main048 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextInt());
            B.add(scanner.nextInt());
        }
        for(int i = 0; i < N; i++){
            C.add(B.get(i));
        }
        for (int i = 0; i < N; i++) {
            C.add(A.get(i) - B.get(i));
        }
        Collections.sort(C);
        long ans = 0;
        for(int i = 1; i <= K; i++) {
            ans += C.get(2*N-i);
        }
        System.out.println(ans);
    }
    public static class Value{
        int index;
        int value;
        boolean isUsed = false;
        public Value(int index, int value){
            this.index = index;
            this.value = value;
        }
        void use(){
            this.isUsed = true;
        }

    }
}
