package src.main.java.ABC319;

import java.util.HashMap;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        String s = sc.next();
        map.put("tourist", 3858);
        map.put("ksun48", 3679);
        map.put("Benq", 3658);
        map.put("Um_nik", 3648);
        map.put("apiad",3638 );
        map.put("Stonefeang",3630 );
        map.put("ecnerwala",3613 );
        map.put("mnbvmar",3555 );
        map.put("newbiedmy",3516 );
        map.put("semiexp", 3481);
        int ans = map.get(s);
        System.out.println(ans);

    }
}
