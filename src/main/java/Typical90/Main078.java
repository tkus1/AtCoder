package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.Scanner;

public class Main078 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Node[] nodes = new Node[N+1];
        for (int i = 1; i < N+1; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            nodes[A].addIncidentNode(nodes[B]);
            nodes[B].addIncidentNode(nodes[A]);
        }
        int ansCnt = 0;
        for (int i = 1; i < N+1; i++) {
            if(isTargetNodes(nodes[i])){
                ansCnt++;
            }
        }
        System.out.println(ansCnt);
    }
    public static boolean isTargetNodes(Node node){
        int index = node.getIndex();
        int cntNodeLessThanThisIndex = 0;
        for (Node incidentNode: node.getIncidentNodes()) {
            if(incidentNode.getIndex() < index){
                cntNodeLessThanThisIndex++;
            }
        }
        return cntNodeLessThanThisIndex == 1;
    }
    public static class Node{
        private final int index;
        private ArrayList<Node> incidentNodes;
        public Node(int index){
            this.index = index;
            this.incidentNodes = new ArrayList<>();
        }
        public int getIndex(){
            return this.index;
        }
        public void addIncidentNode(Node node){
            this.incidentNodes.add(node);
        }
        public ArrayList<Node> getIncidentNodes(){
            return this.incidentNodes;
        }
    }
}

