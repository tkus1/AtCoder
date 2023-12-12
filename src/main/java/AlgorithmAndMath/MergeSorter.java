package src.main.java.AlgorithmAndMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MergeSorter implements Sorter {

    @Override
    public ArrayList<Long> sort(ArrayList<Long> inputList) {
        return mergeSort(inputList);

    }



    private ArrayList<Long> mergeSort(ArrayList<Long> inputList){
        if (inputList.size() >= 2){
            long listLength = inputList.size();
            ArrayList<Long> firstHalfList = new ArrayList<Long>();
            ArrayList<Long> secondHalfList = new ArrayList<Long>();
            for (int i = 0; i < (int)Math.floor((double) listLength /2); i++) {
                firstHalfList.add(inputList.get(0));
                inputList.remove(0);
            }
            for(Long num : inputList){
                secondHalfList.add(num);
            }
            return merge(mergeSort(firstHalfList), mergeSort(secondHalfList));
        }else{
            ArrayList<Long> list = new ArrayList<>();
            list.add(inputList.get(0));
            return list;
        }
    }
    private ArrayList<Long> merge(ArrayList<Long> listA, ArrayList<Long> listB){
        int listLengthA = listA.size();
        int listLengthB = listB.size();
        ArrayList<Long> mergedList = new ArrayList<>();
        for (int i = 0; i < listLengthA + listLengthB; i++) {
            if(listA.isEmpty()){
                for(long num : listB){
                    mergedList.add(num);
                }
                break;
            }
            if(listB.size() == 0){
                for(long num : listA){
                    mergedList.add(num);
                }
                break;
            }
            if(listA.get(0) < listB.get(0)){
                mergedList.add(listA.get(0));
                listA.remove(0);
            } else{
                mergedList.add(listB.get(0));
                listB.remove(0);
            }
        }
        return mergedList;
    }
    public static void main (String[] args){

        ArrayList<Long> inputList = new ArrayList<>();
        int listLength = 300000;
        for (int i = 0; i < listLength; i++) {
            Random random = new Random();
            inputList.add(random.nextLong((long) Math.pow(10,9)));
        }
        System.out.println(inputList.size());
        MergeSorter mergeSorter = new MergeSorter();
        ArrayList<Long> sortedList = mergeSorter.sort(inputList);
        Collections.sort(inputList);
        StringBuilder stringBuilder = new StringBuilder();
        for (Long num : sortedList){
            stringBuilder.append(num).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n");

        System.out.println(stringBuilder);
    }

}


