package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main032 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        long[] targetArray = new long[N];
        for (int i = 0; i < N; i++) {
            targetArray[i] = scanner.nextLong();
        }
        long[] sortedArray = PrimitiveMergeSorter.sort(targetArray);
        boolean isExist = binarySearch(sortedArray, X);
        String state;
        if(isExist){
            state = "Yes";
        }else {
            state = "No";
        }
        System.out.println(state);
    }
    private static boolean binarySearch(long[] list, long targetNum){
        if(list.length == 1){
            return list[0] == targetNum;
        }
        int median = list.length / 2;
        long medianNum = list[median];
        if(targetNum == medianNum){
            return true;
        }
        long[] nextList;
        if(targetNum < medianNum){
            nextList = new long[median];
            for (int i = 0; i < median; i++) {
                nextList[i] = list[i];
            }
        }else{
            nextList = new long[list.length - median];
            for (int i = 0; i < list.length - median ; i++) {
                nextList[i] = list[i + median];
            }

        }
        return binarySearch(nextList, targetNum);
    }
    public class PrimitiveMergeSorter {


        public static long[]  sort(long[]  inputList) {
            return mergeSort(inputList);
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
}
