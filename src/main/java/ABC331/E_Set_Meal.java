package src.main.java.ABC331;

import java.util.*;

public class E_Set_Meal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int L = scanner.nextInt();
        ArrayList<Value> a = new ArrayList<>();
        ArrayList<Value> b = new ArrayList<>();
        int[] c = new int[L];
        int[] d = new int[L];

        for (int i = 0; i < N; i++) {
            a.add(new Value(scanner.nextInt(),i));
        }
        for (int i = 0; i < M; i++) {
            b.add(new Value(scanner.nextInt(),i));
        }
        for (int i = 0; i < L; i++) {
            c[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }
        HashMap<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            Pair pair = new Pair(c[i]-1, d[i]-1);
            map.put(pair,1);
        }
        a.sort(new ValueComparator());
        b.sort(new ValueComparator());
        int maxPx = 0;
        int jMin = 0;
        for (int i = N-1; i >= 0; i--) {
            for (int j = M-1; j >= jMin ; j--) {
                if(map.get(new Pair(a.get(i).getIndex(),b.get(j).getIndex())) != null){
                    //System.out.println("combination A:" + (i+1) + " B:" + (j+1) + " is not available");
                    continue;
                }
                int thisValue = a.get(i).getValue() + b.get(j).getValue();
                if(maxPx < thisValue){
                    maxPx = thisValue;
                    jMin = j + 1;
                    //System.out.println("combination A:" + (i+1) + " B:" + (j+1) + " is used as maxPx");
                    //System.out.println("A:" + a.get(i).getValue() + " B:" + b.get(j).getValue() + " maxPx:" + maxPx);
                    break;
                }
            }
        }
        System.out.println(maxPx);


    }
    static class Pair {
        private final int i;
        private final int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
    public static class Value{
        private final int value;
        private final int index;
        public Value(int value, int index){
            this.value = value;
            this.index = index;
        }
        public int getValue(){
            return value;
        }
        public int getIndex(){
            return index;
        }
    }
    public static class ValueComparator implements Comparator<Value> {
        @Override
        public int compare(Value num1, Value num2) {
            return Integer.compare(num1.getValue(),num2.getValue());
        }
    }
}
