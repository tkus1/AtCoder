package src.main.java.AlgorithmAndMath;

import java.util.*;

public class Main044 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        HashMap<Integer, Vertex> vertexHashMap = new HashMap<Integer, Vertex>();

        for (int i = 0; i < M; i++) {
            int firstEndpointNum = scanner.nextInt();
            int secondEndpointNum = scanner.nextInt();
            Vertex firstEndpoint;
            if (vertexHashMap.get(firstEndpointNum) == null) {
                firstEndpoint = new Vertex(firstEndpointNum);
                vertexHashMap.put(firstEndpointNum,firstEndpoint);
            } else {
                firstEndpoint = vertexHashMap.get(firstEndpointNum);
            }
            Vertex secondEndpoint;
            if (vertexHashMap.get(secondEndpointNum) == null) {
                secondEndpoint = new Vertex(secondEndpointNum);
                vertexHashMap.put(secondEndpointNum,secondEndpoint);
            } else {
                secondEndpoint = vertexHashMap.get(secondEndpointNum);
            }
            firstEndpoint.addIncidentVertex(secondEndpoint);
            secondEndpoint.addIncidentVertex(firstEndpoint);
        }
        Vertex startPoint = vertexHashMap.get(1);
        startPoint.seen();
        startPoint.setDistance(0);
        ArrayList<Vertex> vertexQueue = new ArrayList<>();
        for(int vertexNum : vertexHashMap.keySet()){
            vertexQueue.add(vertexHashMap.get(vertexNum));
        }
        Comparator<Vertex> comparator = Comparator.comparing(Vertex::getDistance);
        while(!vertexQueue.isEmpty()){
            Collections.sort(vertexQueue, comparator);
            Vertex vertex = vertexQueue.remove(0);
            vertex.seen();
            if(vertex.getDistance()==Integer.MAX_VALUE){
                vertex.setDistance(-1);
                continue;
            }
            for(Vertex incidentVertex : vertex.getIncidentVertices()){
                incidentVertex.setDistance(Math.min(incidentVertex.getDistance(), vertex.getDistance()+1));
            }
        }
        StringBuilder answerString = new StringBuilder();
        for(int vertexNum : vertexHashMap.keySet()){
            Vertex vertex = vertexHashMap.get(vertexNum);
            int distance =  vertex.getDistance();
            if(distance == -Integer.MAX_VALUE){
                distance = -1;
            }
            answerString.append(distance).append("\n");

        }
        System.out.println(answerString);

    }

    public static class Vertex{
        private final int name;
        private int distance = Integer.MAX_VALUE;
        private boolean seen = false;
        private ArrayList<Vertex> incidentVertices;
        public Vertex(int name){
            this.name = name;
            incidentVertices = new ArrayList<>();
        }
        public void addIncidentVertex(Vertex vertex){
            incidentVertices.add(vertex);
        }
        public int getName(){
            return name;
        }
        public ArrayList<Vertex> getIncidentVertices(){
            return incidentVertices;
        }
        public void setDistance(int distance){
            this.distance = distance;
        }
        public int getDistance(){
            return distance;
        }
        public void seen(){
            seen = true;
        }
        public boolean isSeen(){
            return seen;
        }
    }
}
