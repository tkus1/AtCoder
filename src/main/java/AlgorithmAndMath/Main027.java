package src.main.java.AlgorithmAndMath;

import java.util.ArrayList;
import java.util.Scanner;

public class Main027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Long> inputList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputList.add(scanner.nextLong());
        }
        long[] primitiveList = new long[inputList.size()];
        int i = 0;
        for(long num : inputList){
            primitiveList[i] = num;
            i++;
        }

        long[] sortedList = mergeSort(primitiveList);

        StringBuilder stringBuilder = new StringBuilder();
        for (long num : sortedList){
            stringBuilder.append(num).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n");

        System.out.println(stringBuilder);
    }

    private static long[] mergeSort(long[] inputList){
        if (inputList.length >= 2){
            int listLength = inputList.length;
            int firstHalfLength = listLength/2;
            int secondHalfLength = listLength - firstHalfLength;
            long[] firstHalfList = new long[firstHalfLength];
            long[] secondHalfList = new long[secondHalfLength];
            for (int i = 0; i < firstHalfLength; i++) {
                firstHalfList[i] = inputList[i];
            }
            for (int i = 0; i < listLength - firstHalfLength; i++) {
                secondHalfList[i] = inputList[i+firstHalfLength];
            }
            return merge(mergeSort(firstHalfList), mergeSort(secondHalfList));
        }else{
            return inputList;
        }
    }
    private static long[] merge(long[] listA, long[] listB){
        int listLengthA = listA.length;
        int listLengthB = listB.length;
        long[] mergedList = new long[listLengthA + listLengthB];
        int i_A = 0;
        int i_B = 0;
        while (i_A < listLengthA && i_B < listLengthB){
            if(listA[i_A] <= listB[i_B]){
                mergedList[i_A + i_B] = listA[i_A];
                i_A++;
            }else {
                mergedList[i_A + i_B] = listB[i_B];
                i_B++;
            }
        }
        if(i_A != listLengthA){
            for (int i = i_A; i < listLengthA; i++) {
                mergedList[i + i_B] = listA[i];
            }
        }
        if(i_B != listLengthB){
            for (int i = i_B; i < listLengthB; i++) {
                mergedList[i + i_A] = listB[i];
            }
        }
        return mergedList;
    }

}
