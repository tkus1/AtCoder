package src.test.java;

import org.junit.jupiter.api.Test;
import src.main.java.AlgorithmAndMath.Main044;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main044Test {

    @Test
    public void testShortestPath() {
        // テストケース1
        String input1 = "5 4\n1 2\n2 3\n3 4\n4 5";
        assertEquals("0\n1\n2\n3\n-1\n", runMain044(input1));

        // テストケース2
        String input2 = "4 3\n1 2\n2 3\n3 4";
        assertEquals("0\n1\n2\n-1\n", runMain044(input2));

        // 他のテストケースも同様に追加
    }

    // Main044を実行して結果を取得するヘルパーメソッド
    private String runMain044(String input) {
        // 入力を標準入力からリダイレクト
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // 標準出力をキャプチャ
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Main044を実行
        Main044.main(new String[]{});

        // 標準出力を文字列として取得
        return out.toString();
    }
}
