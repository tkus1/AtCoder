package src.main.java.ABC327;

import java.util.*;

public class D {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[M];
        int[] B = new int[M];
        HashMap<Integer,Node> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            A[i] = scanner.nextInt() - 1;
        }
        for (int i = 0; i < M; i++) {
            B[i] = scanner.nextInt() - 1;
        }
        for (int i = 0; i < M; i++) {
            if(A[i] == B[i]){
                System.out.println("No");
                return;
            }
            if(!graph.containsKey(A[i])){
                graph.put(A[i],new Node(A[i]));
            }
            if(!graph.containsKey(B[i])){
                graph.put(B[i],new Node(B[i]));
            }
            graph.get(A[i]).addIncidentNode(graph.get(B[i]));
            graph.get(B[i]).addIncidentNode(graph.get(A[i]));

        }
        if(isBipartiteGraph(graph)){
            for (Node node : graph.values()) {
                if (!node.visit) {
                    System.out.println("unvisited node");
                }
            }
            System.out.println("Yes");
            return;
        }
        System.out.println("No");

    }
    public static boolean isBipartiteGraph(HashMap<Integer,Node> graph){
        Queue<Node> queue = new LinkedList<>();

        for(Node targetNode: graph.values()){
            if(targetNode.visit){
                continue;
            }
            if(!dfs(targetNode,0)){
                return false;
            }
        }
        return true;
    }
    public static boolean dfs(Node node, int color){
        node.visit();
        node.setColor(color);
        for (Node incidentNode: node.getIncidentNodes()) {
            if(incidentNode.visit && incidentNode.getColor() == node.getColor()){
                return false;
            }
            if(!incidentNode.visit){
                if (!dfs(incidentNode,1 - node.getColor())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Node{
        private int id;
        private int color;
        private boolean visit = false;
        private HashSet<Node> incidentNodes = new HashSet<>();
        public Node(int id){
            this.id = id;
            this.color = -1;
        }
        public void addIncidentNode(Node node){
            incidentNodes.add(node);
        }
        public HashSet<Node> getIncidentNodes(){
            return incidentNodes;
        }
        public void setColor(int color){
            this.color = color;
        }
        public int getColor(){
            return color;
        }
        public void visit(){
            visit = true;
        }
    }

}
