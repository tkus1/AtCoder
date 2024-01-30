package src.main.java.library;

public class RepeatedPower {
    public static void main(String[] str){
        System.out.println(repeatedPower(3, 6));
    }
    public static long repeatedPower(long a, long n){
        long res = 1;
        while(n > 0){
            if((n & 1) == 1){
                res *= a;
            }
            a *= a;
            n >>= 1;
        }
        return res;
    }
}
