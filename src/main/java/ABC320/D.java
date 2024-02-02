package src.main.java.ABC320;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<Integer, Node> nodes = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            nodes.put(i, new Node());
        }

        nodes.get(1).setX(0);
        nodes.get(1).setY(0);

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            Edge forwardEdge = new Edge(nodes.get(A), nodes.get(B), x, y);
            Edge backwardEdge = new Edge(nodes.get(B), nodes.get(A), -x, -y);
        }

        dfs(nodes.get(1));

        for (int i = 1; i <= N; i++) {
            Node targetNode = nodes.get(i);
            int x = targetNode.getX();
            int y = targetNode.getY();

            if (x == Integer.MAX_VALUE || y == Integer.MAX_VALUE) {
                System.out.println("undecidable");
            } else {
                System.out.println(x + " " + y);
            }
        }

        sc.close(); // Scannerをクローズする
    }

    public static class Node {
        private int x = Integer.MAX_VALUE;
        private int y = Integer.MAX_VALUE;
        private boolean visited = false;
        private HashSet<Edge> incidentEdges = new HashSet<>();

        public Node() {
        }

        public void visit() {
            visited = true;
        }

        public boolean isVisited() {
            return visited;
        }

        public void addEdge(Edge edge) {
            incidentEdges.add(edge);
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getY() {
            return y;
        }
    }

    public static class Edge {
        private final Node start;
        private final Node end;
        private final int xDirection;
        private final int yDirection;

        public Edge(Node start, Node end, int xDirection, int yDirection) {
            start.addEdge(this);
            this.start = start;
            this.end = end;
            this.xDirection = xDirection;
            this.yDirection = yDirection;
        }

        public int getXDirection() {
            return xDirection;
        }

        public int getYDirection() {
            return yDirection;
        }

        public Node getStart() {
            return start;
        }

        public Node getEnd() {
            return end;
        }
    }

    public static void dfs(Node node) {
        node.visit();

        for (Edge edge : node.incidentEdges) {
            if (!edge.getEnd().isVisited()) {
                edge.getEnd().setX(edge.getXDirection() + node.getX());
                edge.getEnd().setY(edge.getYDirection() + node.getY());
                dfs(edge.getEnd());
            }
        }
    }
}
