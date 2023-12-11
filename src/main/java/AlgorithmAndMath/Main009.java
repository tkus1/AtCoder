package src.main.java.AlgorithmAndMath;

import java.util.*;


public class Main009 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int targetSum = scanner.nextInt();
        LinkedList<Integer> intList = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++){
            intList.add(scanner.nextInt());
        }

        Boolean[][] table = new Boolean[intList.size()+1][targetSum+1];
        table[0][0] = true;
        for (int i = 1; i <= intList.size(); i++){
            table[i][0] = true;
        }
        for (int j = 1; j <= targetSum; j++){
            table[0][j] = false;
        }
        for (int rowNum = 1; rowNum <= intList.size(); rowNum++){
            for (int colNum = 1; colNum <= targetSum; colNum++){
                if(table[rowNum-1][colNum] == true){
                    table[rowNum][colNum] = true;
                    continue;
                }
                if(colNum>= intList.get(rowNum-1)) {
                    if (table[rowNum - 1][colNum - intList.get(rowNum - 1)] == true) {
                        table[rowNum][colNum] = true;
                        continue;
                    }
                }
                table[rowNum][colNum] = false;
            }
        }

        String state = "No";
        if(table[intList.size()][targetSum]){
            state = "Yes";
        }
        System.out.println(state);
    }

}

