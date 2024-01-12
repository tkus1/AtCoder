package src.main.java.ABC331;

import java.util.*;

public class C_Sum_of_Numbers_Greater_Than_Me {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Number[] numberList = new Number[N];
        for (int i = 0; i < N; i++) {
            numberList[i] = new Number(scanner.nextInt(),i);
        }
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(numberList).subList(0, N));

        numbers.sort(new NumberComparator());
        for (int i = 1; i < N; i++) {
            numbers.get(i).setSum(numbers.get(i-1).getSum() + numbers.get(i-1).getValue());
            if(numbers.get(i).getValue() == numbers.get(i-1).getValue()){
                numbers.get(i).setSumAns(numbers.get(i-1).getSumAns());
                continue;
            }
            numbers.get(i).setSumAns(numbers.get(i-1).getSum() + numbers.get(i-1).getValue());
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            ans.append(" ").append(numberList[i].getSumAns());
        }
        ans.deleteCharAt(0);
        System.out.println(ans);
    }
    public static class Number{
        private int value;
        private int index;
        private long sum;
        private long sumAns;
        public Number(int value, int index){
            this.value = value;
            this.index = index;
            this.sum = 0;
            this.sumAns = 0;
        }
        public int getValue(){
            return value;
        }
        public void setSum(long sum){
            this.sum = sum;
        }
        public long getSum(){
            return sum;
        }
        public void setSumAns(long sumAns){
            this.sumAns = sumAns;
        }

        public long getSumAns() {
            return sumAns;
        }
    }
    public static class NumberComparator implements Comparator<Number> {
        @Override
        public int compare(Number num1, Number num2) {
            // valueの比較を行う
            return Integer.compare(num2.getValue(),num1.getValue());
        }
    }
}
