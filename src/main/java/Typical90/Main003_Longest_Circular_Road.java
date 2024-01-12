package src.main.java.Typical90;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main003_Longest_Circular_Road {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < N-1; i++) {
            int A = scanner.nextInt()-1;
            int B = scanner.nextInt()-1;
            nodes[A].addIncidentNode(nodes[B]);
            nodes[B].addIncidentNode(nodes[A]);
        }
        Node w = Helper.getFarthestNode(nodes, nodes[0]);
        Node v = Helper.getFarthestNode(nodes, w);
        System.out.println(v.getDistance()+1);
    }
    public static class Node{
        private final int id;
        ArrayList<Node> incidentNodes = new ArrayList<>();
        private int distance = Integer.MAX_VALUE;
        private boolean isVisited = false;
        Node parent;
        Node(int id){
            this.id = id;
        }
        void addIncidentNode(Node node){
            incidentNodes.add(node);
        }
        void setDistance(int distance){
            this.distance = distance;
        }
        int getId(){
            return id;
        }
        int getDistance(){
            return distance;
        }
        void resetDistance(){
            distance = Integer.MAX_VALUE;
        }
        public void resetIsVisited(){
            isVisited = false;
        }
        public void visited(){
            isVisited = true;
        }

    }
    public static class Helper{
        public static void dfs(Node[] graph, Node startNode){
            for (Node node : graph) {
                node.resetDistance();
                node.resetIsVisited();
            }
            startNode.setDistance(0);
            Queue<Node> queue = new LinkedList<>();
            queue.add(startNode);
            while(!queue.isEmpty()){
                Node node = queue.poll();
                node.visited();
                for(Node incidentNode : node.incidentNodes){
                    if(incidentNode.isVisited){
                        continue;
                    }
                    incidentNode.setDistance(Math.min(node.getDistance()+1, incidentNode.getDistance()));
                    queue.add(incidentNode);
                }
            }

        }
        public static Node getFarthestNode(Node[] graph, Node startNode) {
            dfs(graph, startNode);
            int maxDistance = 0;
            Node farthestNode = null;
            for (Node node : graph) {
                if (maxDistance < node.getDistance()) {
                    maxDistance = node.getDistance();
                    farthestNode = node;
                }
            }
            return farthestNode;
        }
    }
}
