package src.main.java.Typical90;

import java.util.*;

public class Main012_Red_Painting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        Node[][] nodes = new Node[H+1][W+1];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                nodes[i][j] = new Node('w');
            }
        }
        for (int i = 0; i <= H ; i++) {
            nodes[i][0] = new Node('w');
        }
        for (int j = 0; j <= W ; j++) {
            nodes[0][j] = new Node('w');
        }
        for (int i = 0; i < H+1; i++) {
            for (int j = 0; j < W+1; j++) {
                if(i<H){
                    nodes[i][j].addIncidentNode(nodes[i+1][j]);
                    nodes[i+1][j].addIncidentNode(nodes[i][j]);
                }
                if(j<W){
                    nodes[i][j].addIncidentNode(nodes[i][j+1]);
                    nodes[i][j+1].addIncidentNode(nodes[i][j]);
                }
            }
        }
        int Q = scanner.nextInt();
        int groupNo = 1;
        HashMap<Integer, ArrayList<Node>> groupMap = new HashMap<>();
        StringBuilder ansStr = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                Node targetNode = nodes[r][c];
                targetNode.setColor('r');
                ArrayList<Node> redNodeList = new ArrayList<>();
                for (Node incidentNode : targetNode.getIncidentNodes()) {
                    if (incidentNode.getColor() == 'r') {
                        redNodeList.add(incidentNode);
                    }
                }
                if (redNodeList.isEmpty()) {
                    targetNode.setGroupNo(groupNo);
                    ArrayList<Node> nodeList = new ArrayList<>();
                    nodeList.add(targetNode);
                    groupMap.put(groupNo, nodeList);
                    groupNo++;
                } else {
                    Node firstRedNode = redNodeList.remove(0);
                    int primaryGroupNo = firstRedNode.getGroupNo();
                    targetNode.setGroupNo(primaryGroupNo);
                    ArrayList<Node> primaryGroup = groupMap.get(primaryGroupNo);
                    primaryGroup.add(targetNode);
                    if(redNodeList.isEmpty()){
                        continue;
                    }
                    for (Node redNode : redNodeList) {
                        int groupNoToChange = redNode.getGroupNo();
                        if (groupNoToChange == primaryGroupNo) {
                            continue;
                        }
                        ArrayList<Node> nodesToChange = groupMap.get(groupNoToChange);

                        for (Node node : nodesToChange) {
                            node.setGroupNo(primaryGroupNo);
                            primaryGroup.add(node);
                        }
                        nodesToChange.clear();
                    }
                }
                continue;
            }
            int ra = scanner.nextInt();
            int ca = scanner.nextInt();
            int rb = scanner.nextInt();
            int cb = scanner.nextInt();
            Node firstNode = nodes[ra][ca];
            Node secondNode = nodes[rb][cb];
            if(firstNode.getColor() == 'w' || secondNode.getColor() == 'w'){
                ansStr.append("No").append("\n");
                //System.out.println("No");
                continue;
            }
            if (firstNode.getGroupNo() != secondNode.getGroupNo()) {
                ansStr.append("No").append("\n");
                //System.out.println("No");
                continue;
            }
            ansStr.append("Yes").append("\n");
            //System.out.println("Yes");
        }
        System.out.println(ansStr);
    }
    public static class Node{
        char color;
        int groupNo;
        ArrayList<Node> incidentNodes;

        public Node(char color){
            this.color = color;
            this.incidentNodes = new ArrayList<>();
            this.groupNo = -1;
        }
        public void addIncidentNode(Node node){
            incidentNodes.add(node);

        }

        public void setColor(char color){
            this.color = color;
        }
        public char getColor(){
            return color;
        }
        public ArrayList<Node> getIncidentNodes(){
            return incidentNodes;
        }
        public void setGroupNo(int groupNo){
            this.groupNo = groupNo;
        }
        public int getGroupNo(){
            return groupNo;
        }
    }

}
