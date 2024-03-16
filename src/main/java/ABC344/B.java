package src.main.java.ABC344;
import java.util.ArrayList;
import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            Integer nextInt = scanner.nextInt();
            list.add(nextInt);
            if(nextInt == 0) break;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(list.size()-1-i));
        }
    }
}
