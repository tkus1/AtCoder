package src.main.java.AlgorithmAndMath;

import java.util.*;

public class Main047 {
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
        String ans = "Yes";
        Queue<Vertex> todoQueue = new LinkedList<>();
        while(true){
            for (Vertex startVertex : vertexHashMap.values()){
                if (!startVertex.isSeen()){
                    todoQueue.add(startVertex);
                    break;
                }
            }
            while(!todoQueue.isEmpty()){
                Vertex vertex = todoQueue.poll();
                if(vertex.getColor() == null){
                    vertex.setColor(true);
                };
                for(Vertex incidentVertex : vertex.getIncidentVertices()){
                    if(incidentVertex.getColor() == null){
                        incidentVertex.setColor(!vertex.getColor());
                        if(!todoQueue.contains(incidentVertex)){
                            todoQueue.add(incidentVertex);
                        }
                        continue;
                    }
                    if(incidentVertex.getColor() == vertex.getColor()){
                        ans = "No";
                        break;
                    }
                }
                vertex.seen();
            }
            boolean seeAll = true;
            for(Vertex vertex : vertexHashMap.values()){
                if(!vertex.seen){
                    seeAll = false;
                    break;
                }
            }
            if(seeAll){
                break;
            }

        }
        System.out.println(ans);
    }

    public static class Vertex{
        private final int name;
        private Boolean color = null;
        private int distance = Integer.MAX_VALUE;
        private boolean seen = false;
        private ArrayList<Vertex> incidentVertices;
        public Vertex(int name){
            this.name = name;
            incidentVertices = new ArrayList<>();
        }
        public Boolean getColor(){
            return color;
        }
        public void setColor(Boolean color){
            this.color = color;
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
