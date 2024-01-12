package src.main.java.Typical90;

import java.util.*;

public class Main012_Red_Painting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        Node[][] nodes = new Node[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                nodes[i][j] = new Node('w', (i - 1) * W + j);
            }
        }

        int Q = scanner.nextInt();
        UnionFind uf = new UnionFind(H * W + 1);
        StringBuilder ansStr = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                Node targetNode = nodes[r][c];
                targetNode.setColor('r');
                ArrayList<Node> incidentNodes = new ArrayList<>();
                if(r>1){
                    incidentNodes.add(nodes[r-1][c]);
                }
                if(r<H){
                    incidentNodes.add(nodes[r+1][c]);
                }
                if(c>1){
                    incidentNodes.add(nodes[r][c-1]);
                }
                if(c<W){
                    incidentNodes.add(nodes[r][c+1]);
                }
                if(incidentNodes.isEmpty()) {
                    continue;
                }
                for (Node incidentNode : incidentNodes) {
                    if (incidentNode.getColor() == 'r') {
                        uf.union(targetNode.getIndex(), incidentNode.getIndex());
                    }
                }
            } else {
                int ra = scanner.nextInt();
                int ca = scanner.nextInt();
                int rb = scanner.nextInt();
                int cb = scanner.nextInt();
                if (nodes[ra][ca].getColor() == 'w' || nodes[rb][cb].getColor() == 'w' || !uf.connected(nodes[ra][ca].getIndex(), nodes[rb][cb].getIndex())) {
                    ansStr.append("No").append("\n");
                } else {
                    ansStr.append("Yes").append("\n");
                }
            }
        }
        System.out.println(ansStr);
    }

    public static class Node {
        char color;
        int index;
        ArrayList<Node> incidentNodes;

        public Node(char color, int index) {
            this.color = color;
            this.index = index;
            this.incidentNodes = new ArrayList<>();
        }

        public void setColor(char color) {
            this.color = color;
        }

        public char getColor() {
            return color;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
