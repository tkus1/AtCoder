package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.Scanner;

public class Main072 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        Node[][] nodes = new Node[H+2][W+2];
        for (int i = 1; i <= H; i++) {
            String line = scanner.next();
            for (int j = 1; j < W+1; j++) {
                nodes[i][j] = new Node(line.charAt(j-1),i,j);
            }
        }
        for (int i = 0; i < H+2; i++) {
            nodes[i][0] = new Node('#',i,0);
            nodes[i][W+1] = new Node('#',i,W+1);
        }
        for (int j = 0; j < W+2; j++) {
            nodes[0][j] = new Node('#',0,j);
            nodes[H+1][j] = new Node('#',H+1,j);
        }

        for (int i = 0; i < H+1; i++) {
            for (int j = 0; j < W+1; j++) {
                nodes[i][j].addIncidentNode(nodes[i+1][j]);
                nodes[i+1][j].addIncidentNode(nodes[i][j]);
                nodes[i][j].addIncidentNode(nodes[i][j+1]);
                nodes[i][j+1].addIncidentNode(nodes[i][j]);
            }
        }
        int maxDistance = -1;
        for (int i = 1; i < H+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(nodes[i][j].getSymbol() == '#'){
                    continue;
                }
                nodes[i][j].setStart();
                maxDistance = Math.max(maxDistance, backtrack(nodes[i][j], 0));
                nodes[i][j].resetStart();
            }
        }
        if(maxDistance <= 3){
            maxDistance = -1;
        }
        System.out.println(maxDistance);
    }

    public static class Node{
        private final char symbol;
        private final int row;
        private final int col;
        private boolean isStart = false;
        private boolean isVisited = false;
        ArrayList<Node> incidentNodes = new ArrayList<>();
        
        public Node(char symbol, int row, int col){
            this.symbol = symbol;
            this.row = row;
            this.col = col;
        }
        public char getSymbol(){
            return this.symbol;
        }
        public ArrayList<Node> getIncidentNodes(){
            return this.incidentNodes;
        }
        public void addIncidentNode(Node node){
            this.incidentNodes.add(node);
        }
        
        public void visit(){
            this.isVisited = true;
        }
        public boolean isVisited(){
            return this.isVisited;
        }
        public void reset(){
            this.isVisited = false;
        }
        public boolean isStart(){
            return this.isStart;
        }
        public void setStart(){
            this.isStart = true;
        }
        public void resetStart(){
            this.isStart = false;
        }
    }
    public static int backtrack(Node node, int distance){
        if(node.isVisited()&& !node.isStart()){
            return -1;
        }
        if(node.getSymbol() == '#'){
            return -1;
        }
        if(node.isStart() && distance > 0){
            return distance;
        }
        node.visit();
        int maxDistance = -1;
        for(Node incidentNode: node.getIncidentNodes()){
            if(incidentNode.isVisited() && !incidentNode.isStart()){
                continue;
            }
            if(incidentNode.getSymbol() == '#'){
                continue;
            }
            maxDistance = Math.max(maxDistance, backtrack(incidentNode, distance + 1));
        }
        node.reset();
        return maxDistance;
    }

}
