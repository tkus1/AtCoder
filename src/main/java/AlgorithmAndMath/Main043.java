package src.main.java.AlgorithmAndMath;

import java.util.*;

public class Main043 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            int firstEndpoint = scanner.nextInt();
            int secondEndpoint = scanner.nextInt();
            if(graph.get(firstEndpoint) == null){
                ArrayList<Integer> incidentEdgeList = new ArrayList<>();
                incidentEdgeList.add(secondEndpoint);
                graph.put(firstEndpoint,incidentEdgeList);
            }else{
                graph.get(firstEndpoint).add(secondEndpoint);
            }

            if(graph.get(secondEndpoint) == null){
                ArrayList<Integer> incidentEdgeList = new ArrayList<>();
                incidentEdgeList.add(firstEndpoint);
                graph.put(secondEndpoint,incidentEdgeList);
            }else{
                graph.get(secondEndpoint).add(firstEndpoint);
            }

        }
        boolean[] seen = new boolean[N+1];
        for (int i = 1; i < N + 1; i++) {
            seen[i] = false;
        }
        Queue<Integer> todoQueue = new LinkedList<>();
        int firstVertex = graph.keySet().iterator().next();
        todoQueue.add(firstVertex);
        seen[firstVertex] = true;
        while (!todoQueue.isEmpty()){
            int vertex = (int)todoQueue.poll();
            for (int vertexNumber : graph.get(vertex)) {
                if (!seen[vertexNumber]) {
                    seen[vertexNumber] = true;
                    todoQueue.add(vertexNumber);
                }
            }
        }
        boolean isConnected = true;
        for (int i = 1; i < N + 1; i++) {
            if(!seen[i]){
                isConnected = false;
                break;
            }
        }
        String ans;
        if(isConnected){
            ans = "The graph is connected.";
        }else{
            ans = "The graph is not connected.";
        }
        System.out.println(ans);
    }
}
