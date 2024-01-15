package src.main.java.Typical90;

import java.util.Scanner;

public class Main067{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int K = scanner.nextInt();
        if(N.equals("0")){
            System.out.println(0);
            return;
        }
        String stringN;
        for (int i = 0; i < K; i++) {
            String base10 = convertBaseTo10(N,8);
            String base8 = convertBaseFrom10(base10, 9);
            N = base8.replaceAll("8", "5");
        }
        System.out.println(N);
    }
    public static String convertBaseFrom10(String num, int base){
        long numLong = Long.parseLong(num);
        StringBuilder sb = new StringBuilder();
        while(numLong > 0){
            sb.append(numLong % base);
            numLong /= base;
        }
        return sb.reverse().toString();
    }
    public static String convertBaseTo10(String num, int base){
        long ans = 0;
        long multiplier = 1;
        for (int i = 1; i <= num.length(); i++) {
            ans += Long.parseLong(num.substring(num.length() - i,num.length() - i+1)) * multiplier;
            multiplier *= base;
        }
        return String.valueOf(ans);
    }
}
