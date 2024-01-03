package src.main.java.AlgorithmAndMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main045 {
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
                vertexHashMap.put(firstEndpointNum, firstEndpoint);
            } else {
                firstEndpoint = vertexHashMap.get(firstEndpointNum);
            }
            Vertex secondEndpoint;
            if (vertexHashMap.get(secondEndpointNum) == null) {
                secondEndpoint = new Vertex(secondEndpointNum);
                vertexHashMap.put(secondEndpointNum, secondEndpoint);
            } else {
                secondEndpoint = vertexHashMap.get(secondEndpointNum);
            }
            firstEndpoint.addIncidentVertex(secondEndpoint);
            secondEndpoint.addIncidentVertex(firstEndpoint);
        }
        int resultCnt = 0;
        for(Object key : vertexHashMap.keySet()){
            Vertex vertex = vertexHashMap.get(key);
            int targetVertexCnt = 0;
            for (Vertex incidentVertex : vertex.getIncidentVertices()){
                if(incidentVertex.getName() < vertex.name){
                    targetVertexCnt++;
                }
            }
            if(targetVertexCnt == 1){
                resultCnt++;
            }
        }
        System.out.println(resultCnt);
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
