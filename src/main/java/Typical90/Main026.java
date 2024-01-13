package src.main.java.Typical90;

import java.util.*;

public class Main026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i));
        }
        for (int i = 0; i < N - 1; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            nodes.get(A - 1).addIncidentNode(nodes.get(B - 1));
            nodes.get(B - 1).addIncidentNode(nodes.get(A - 1));
        }
        Node firstNode = nodes.get(0);
        firstNode.setColor('W');
        Helper.dfs(firstNode);
        int whiteCnt = 0;
        int blackCnt = 0;
        for(Node node : nodes){
            if(node.getColor() == 'W'){
                whiteCnt++;
            }else{
                blackCnt++;
            }
        }
        char dominantColor = whiteCnt > blackCnt ? 'W' : 'B';
        StringBuilder ansStr = new StringBuilder();
        int nodeCnt = 0;
        for(Node node : nodes){
            if(node.getColor() == dominantColor){
                nodeCnt++;
                ansStr.append(node.getIndex() + 1).append(" ");
            }
            if (nodeCnt == N / 2) {
                break;
            }
        }
        System.out.println(ansStr);
    }
    public static class Helper{
        public static void dfs(Node node){
            node.visit();
            char thisColoruri = node.getColor();
            for (Node incidentNode : node.getIncidentNodes()) {
                if(!incidentNode.isVisited()){
                    if(thisColoruri == 'W'){
                        incidentNode.setColor('B');
                    }else{
                        incidentNode.setColor('W');
                    }
                    dfs(incidentNode);
                }
            }
        }
    }
    public static class Node{
        private final int index;
        private char coloruri;
        private boolean isUsed;
        private boolean isVisited;
        ArrayList<Node> incidentNodes;
        public Node(int index){
            this.index = index;
            this.isVisited = false;
            this.incidentNodes = new ArrayList<>();
            this.isUsed = false;
        }
        public void setColor(char color){
            this.coloruri = color;
        }
        public char getColor(){
            return this.coloruri;
        }
        public void use(){
            this.isUsed = true;
        }
        public boolean isUsed(){
            return this.isUsed;
        }

        public void addIncidentNode(Node node){
            this.incidentNodes.add(node);
        }
        public int getIndex(){
            return this.index;
        }
        public void visit(){
            this.isVisited = true;
        }
        public void resetVisit(){
            this.isVisited = false;
        }
        public boolean isVisited(){
            return this.isVisited;
        }
        public ArrayList<Node> getIncidentNodes(){
            return this.incidentNodes;
        }

    }
}
