package src.main.java.ABC325;

import java.util.HashSet;
import java.util.Scanner;

public class C {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        Node[][] A = new Node[H+2][W+2];
        for (int i = 0; i < H+2; i++) {
            A[i][0] = new Node(i, 0, '.');
            A[i][W+1] = new Node(i, W+1, '.');
        }
        for (int j = 0; j < W+2; j++) {
            A[0][j] = new Node(0, j, '.');
            A[H+1][j] = new Node(H+1, j, '.');
        }
        for (int i = 1; i <= H; i++) {
            String str = scanner.next();
            for (int j = 1; j <= W; j++) {
                A[i][j] = new Node(i, j, str.charAt(j-1));
            }
        }
        for (int i = 1; i < H+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(A[i][j].symbol == '#') {
                    if(A[i+1][j].symbol == '#'){
                        A[i][j].addIncidentNode(A[i+1][j]);
                        A[i+1][j].addIncidentNode(A[i][j]);
                    }
                    if(A[i-1][j+1].symbol == '#'){
                        A[i][j].addIncidentNode(A[i-1][j+1]);
                        A[i-1][j+1].addIncidentNode(A[i][j]);
                    }
                    if(A[i][j+1].symbol == '#'){
                        A[i][j].addIncidentNode(A[i][j+1]);
                        A[i][j+1].addIncidentNode(A[i][j]);
                    }
                    if(A[i+1][j+1].symbol == '#'){
                        A[i][j].addIncidentNode(A[i+1][j+1]);
                        A[i+1][j+1].addIncidentNode(A[i][j]);
                    }


                }
            }
        }
        int ans = countGroup(A);
        System.out.println(ans);

    }
    public static class Node {
        HashSet<Node> incidentNodes = new HashSet<>();
        int x;
        int y;
        char symbol;
        Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.symbol = c;
        }
        boolean visited = false;
        public void addIncidentNode(Node node) {
            incidentNodes.add(node);
        }
        public void visit() {
            visited = true;
        }

    }
    public static int countGroup(Node[][] A) {
        int count = 0;
        int H = A.length;
        int W = A[0].length;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (A[i][j].symbol != '#') {
                    continue;
                }
                if (A[i][j].visited) {
                    continue;
                }
                dfs(A, A[i][j]);
                count++;
            }
        }
        return count;
    }
    public static void dfs(Node[][] A, Node node) {
        node.visit();
        for (Node incidentNode : node.incidentNodes) {
            if (incidentNode.visited) {
                continue;
            }
            dfs(A, incidentNode);
        }
    }

}
