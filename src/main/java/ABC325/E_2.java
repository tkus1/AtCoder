package src.main.java.ABC325;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E_2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
    public static class Node{
        int id;
        private boolean visited;
        private long distance = Long.MAX_VALUE;
        Node(int id, int value){
            this.id = id;
        }
        public void visit(){
            this.visited = true;
        }
        public boolean isVisited(){
            return this.visited;
        }
        public void setDistance(long distance){
            this.distance = distance;
        }
        public long getDistance(){
            return this.distance;
        }

    }
    public static void dijkstra(Node[] nodes, int start){
        nodes[start].setDistance(0);
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.getDistance(), o2.getDistance());
            }
        });
        queue.add(nodes[start]);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            node.visit();
            for (Node nextNode: nodes) {
                if(node == nextNode) continue;

                if(!nextNode.isVisited()){
                    long distance = node.getDistance() + node.getDistance();
                    if(distance < nextNode.getDistance()){
                        nextNode.setDistance(distance);
                        queue.add(nextNode);
                    }
                }
            }
        }
    }
}
