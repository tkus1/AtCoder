package src.main.java.ABC333;

import java.util.*;

public class D_Erase_Leaves {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < N-1; i++) {
            int firstNodeIndex = scanner.nextInt();
            int secondNodeIndex = scanner.nextInt();
            if(!nodes.containsKey(firstNodeIndex)){
                nodes.put(firstNodeIndex, new Node(firstNodeIndex));
            }
            if(!nodes.containsKey(secondNodeIndex)){
                nodes.put(secondNodeIndex, new Node(secondNodeIndex));
            }
            nodes.get(firstNodeIndex).addIncidentVertices(nodes.get(secondNodeIndex));
            nodes.get(secondNodeIndex).addIncidentVertices(nodes.get(firstNodeIndex));
        }
        Helper.dykstra(nodes, 1);
        ArrayList<Node> graph = new ArrayList<>(nodes.values());
        graph.sort(new distanceComparator());

        for (Node targetNode : graph) {
            if(targetNode.getParentNode()==null){
                continue;
            }
                Node parentNode = targetNode.getParentNode();
                parentNode.setNumOfChildNode(parentNode.getNumOfChildNode() + targetNode.getNumOfChildNode() + 1);
        }
        Node startNode = nodes.get(1);
        int minOperationCnt = 0;
        Node nodeWithMaxChildren = new Node(Integer.MAX_VALUE);
        if(startNode.getIncidentVertices().size() == 1){
            minOperationCnt = 0;
        }else {

            for(Node incidentNode: startNode.getIncidentVertices()){
                if(nodeWithMaxChildren.getIndex()==Integer.MAX_VALUE){
                    nodeWithMaxChildren = incidentNode;
                }else {
                    if(nodeWithMaxChildren.getNumOfChildNode() < incidentNode.getNumOfChildNode()){
                        nodeWithMaxChildren = incidentNode;
                    }
                }
            }
            for(Node incidentNode: startNode.getIncidentVertices()){
                if(incidentNode.equals(nodeWithMaxChildren)){
                    continue;
                }
                minOperationCnt += 1 + incidentNode.getNumOfChildNode();
            }

        }
        minOperationCnt+=1;
        System.out.println(minOperationCnt);
    }
    public static class distanceComparator implements Comparator<Node>{
        public int compare(Node node1, Node node2){
            return Integer.compare(node2.getDistance(), node1.getDistance());
        }
    }
    public static class Node{
        private int distance;
        private final int index;
        private int numOfChildNode;
        private Node parentNode;
        private boolean seen;
        private ArrayList<Node> incidentVertices = new ArrayList<>();
        private ArrayList<Node> childNodes = new ArrayList<>();
        public Node(int index){
            this.index = index;
            distance = Integer.MAX_VALUE;
            this.numOfChildNode = 0;
            seen = false;
        }
        public void setParentNode(Node parentNode){
            this.parentNode = parentNode;
        }
        public Node getParentNode(){
            return parentNode;
        }
        public void addChildNode(Node childNode){
            childNodes.add(childNode);
        }
        public ArrayList<Node> getChildNodes(){
            return childNodes;
        }
        public void seen(){
            seen = true;
        }
        public boolean isSeen(){
            return seen;
        }
        public int getIndex() {
            return index;
        }

        public int getNumOfChildNode() {
            return numOfChildNode;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setNumOfChildNode(int numOfChildNode) {
            this.numOfChildNode = numOfChildNode;
        }
        public void addIncidentVertices(Node node){
            incidentVertices.add(node);
        }
        public ArrayList<Node> getIncidentVertices(){
            return incidentVertices;
        }
    }
    public static class Helper{
        public static void dykstra(HashMap<Integer, Node> nodes, int startNodeIndex){
            Node startNode = nodes.get(startNodeIndex);
            startNode.seen();
            startNode.setDistance(0);
            Queue<Node> todoQueue = new LinkedList<>(startNode.getIncidentVertices());
            for(Node incidentNode : startNode.getIncidentVertices()){
                startNode.addChildNode(incidentNode);
                incidentNode.setDistance(Math.min(incidentNode.getDistance(), startNode.getDistance() + 1));
                incidentNode.setParentNode(startNode);
                todoQueue.add(incidentNode);
            }

            while(!todoQueue.isEmpty()){
                Node targetNode = todoQueue.poll();
                targetNode.seen();
                for(Node incidentNode: targetNode.getIncidentVertices()){
                    if(incidentNode.isSeen()){
                        continue;
                    }
                    targetNode.addChildNode(incidentNode);
                    incidentNode.setDistance(Math.min(incidentNode.getDistance(), targetNode.getDistance() + 1));
                    incidentNode.setParentNode(targetNode);
                    todoQueue.add(incidentNode);
                }
            }
        }
    }
}
