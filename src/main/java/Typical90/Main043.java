package src.main.java.Typical90;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main043 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int rs = scanner.nextInt();
        int cs = scanner.nextInt();
        int rt = scanner.nextInt();
        int ct = scanner.nextInt();
        Node[][] maze = new Node[H+2][W+2];
        for (int i = 1; i <= H; i++) {
            String s = scanner.next();
            for (int j = 1; j <= W; j++) {
                maze[i][j] = new Node(i, j, s.charAt(j-1));
            }
        }
        for (int i = 0; i < H+2; i++) {
            maze[i][0] = new Node(i,0,'#');
            maze[i][W+1] = new Node(i ,W+1,'#');
        }
        for (int j = 0; j < W+2; j++) {
            maze[0][j] = new Node(0,j,'#');
            maze[H+1][j] = new Node(H+1, j,'#');
        }

        Helper.findShortestPath(maze, rs, cs, rt, ct);
        Node targetNode = maze[rt][ct];
        int ans = maze[rt][ct].getMinDist();
        System.out.println(ans);
        boolean showAll = false;
        if (showAll){
            for (int i = 1; i < 100; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(": ");
                for (int j = 0; j < W+2; j++) {
                    int dist = maze[i][j].getMinDist();
                    sb.append("|").append(j).append("|");
                    if (dist == Integer.MAX_VALUE) {
                        sb.append("##").append("( ) ");
                        continue;
                    }
                    if(dist < 10){
                        sb.append(" ").append(dist).append("(").append(maze[i][j].getMinDistDirection()).append(")").append(" ");
                        continue;
                    }
                    sb.append(dist).append("(").append(maze[i][j].getMinDistDirection()).append(")").append(" ");
                }
                System.out.println(sb.toString());

            }
        }



    }
    public static class Helper{
        public static void findShortestPath(Node[][] maze, int rs, int cs, int rt, int ct){
            Node startNode = maze[rs][cs];
            startNode.setDistUp(0);
            startNode.setDistDown(0);
            startNode.setDistLeft(0);
            startNode.setDistRight(0);
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(startNode);
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(node.isVisited()){
                    continue;
                }
                node.visit();
                int r = node.getR();
                int c = node.getC();

                // go down
                int distDown = maze[r][c].getDistDown();
                Node lowerNode = maze[r+1][c];

                if(lowerNode.getType() == '.' && !lowerNode.isVisited()){
                    //if(lowerNode.getType() == '.'){
                    if(!lowerNode.isVisited()){
                        queue.add(lowerNode);
                    }
                    int currentDistDown = lowerNode.getDistDown();
                    int currentDistUp = lowerNode.getDistUp();
                    int currentDistRight = lowerNode.getDistRight();
                    int currentDistLeft = lowerNode.getDistLeft();

                    lowerNode.setDistDown  (Math.min(distDown,     lowerNode.getDistDown()));
                    lowerNode.setDistUp    (Math.min(distDown + 1, lowerNode.getDistUp()));
                    lowerNode.setDistRight (Math.min(distDown + 1, lowerNode.getDistRight()));
                    lowerNode.setDistLeft  (Math.min(distDown + 1, lowerNode.getDistLeft()));
                    int i = 2;
                    while(maze[r+i][c].getType() == '.'){
                        maze[r+i][c].setDistDown(Math.min(distDown, maze[r+i][c].getDistDown()));

                        i++;
                    }

                }

                // go up
                int distUp = maze[r][c].getDistUp();
                Node upperNode = maze[r-1][c];
                if(upperNode.getType() == '.' && !upperNode.isVisited()){
                    //if(upperNode.getType() == '.'){
                    if(!upperNode.isVisited()){
                        queue.add(upperNode);
                    }
                    upperNode.setDistDown  (Math.min(distUp + 1, upperNode.getDistDown()));
                    upperNode.setDistUp    (Math.min(distUp,     upperNode.getDistUp()));
                    upperNode.setDistRight (Math.min(distUp + 1, upperNode.getDistRight()));
                    upperNode.setDistLeft  (Math.min(distUp + 1, upperNode.getDistLeft()));
                    int i = 2;
                    while(maze[r-i][c].getType() == '.'){
                        maze[r-i][c].setDistUp(Math.min(distUp, maze[r-i][c].getDistUp()));
                        i++;
                    }
                }
                // go right
                int distRight = maze[r][c].getDistRight();
                Node rightNode = maze[r][c+1];
                if(rightNode.getType() == '.' && !rightNode.isVisited()){

                    //if(rightNode.getType() == '.'){
                    if(!rightNode.isVisited()){
                        queue.add(rightNode);
                    }
                    rightNode.setDistDown  (Math.min(distRight + 1, rightNode.getDistDown()));
                    rightNode.setDistUp    (Math.min(distRight + 1, rightNode.getDistUp()));
                    rightNode.setDistRight (Math.min(distRight,     rightNode.getDistRight()));
                    rightNode.setDistLeft  (Math.min(distRight + 1, rightNode.getDistLeft()));
                    int i = 2;
                    while(maze[r][c+i].getType() == '.'){
                        maze[r][c+i].setDistRight(Math.min(distRight, maze[r][c+i].getDistRight()));
                        i++;
                    }

                }
                // go left
                int distLeft = maze[r][c].getDistLeft();
                Node leftNode = maze[r][c-1];

                if(leftNode.getType() == '.' && !leftNode.isVisited()){
                    //if(leftNode.getType() == '.'){
                    if(!leftNode.isVisited()){
                        queue.add(leftNode);
                    }
                    leftNode.setDistDown  (Math.min(distLeft + 1, leftNode.getDistDown()));
                    leftNode.setDistUp    (Math.min(distLeft + 1, leftNode.getDistUp()));
                    leftNode.setDistRight (Math.min(distLeft + 1, leftNode.getDistRight()));
                    leftNode.setDistLeft  (Math.min(distLeft,     leftNode.getDistLeft()));
                    int i = 2;
                    while(maze[r][c-i].getType() == '.'){
                        maze[r][c-i].setDistLeft(Math.min(distLeft, maze[r][c-i].getDistLeft()));
                        i++;
                    }
                }


            }


        }
    }
    public static class Node implements Comparable<Node>{
        private int distUp = Integer.MAX_VALUE;
        private int distDown = Integer.MAX_VALUE;
        private int distLeft = Integer.MAX_VALUE;
        private int distRight = Integer.MAX_VALUE;

        private final int r;
        private final int c;

        private boolean isVisited = false;
        private final char type;
        public Node(int r, int c, char type){
            this.r = r;
            this.c = c;
            this.type = type;
        }
        public int getMinDist(){
            return Math.min(Math.min(this.distDown, this.distUp), Math.min(this.distLeft, this.distRight));
        }
        public String getMinDistDirection(){
            int minDist = getMinDist();
            if(minDist == this.distDown){
                return "↓";
            }
            if(minDist == this.distUp){
                return "↑";
            }
            if(minDist == this.distLeft){
                return "←";
            }
            if(minDist == this.distRight){
                return "→";
            }
            return "error";
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getMinDist(), o.getMinDist());
        }
        public int getC() {
            return c;
        }
        public int getR() {
            return r;
        }

        public int getDistDown() {
            return distDown;
        }

        public int getDistLeft() {
            return distLeft;
        }

        public int getDistRight() {
            return distRight;
        }

        public int getDistUp() {
            return distUp;
        }

        public void setDistDown(int distDown) {
            this.distDown = distDown;
        }

        public void setDistLeft(int distLeft) {
            this.distLeft = distLeft;
        }

        public void setDistRight(int distRight) {
            this.distRight = distRight;
        }

        public void setDistUp(int distUp) {
            this.distUp = distUp;
        }

        public void visit(){
            this.isVisited = true;
        }
        public boolean isVisited(){
            return this.isVisited;
        }
        public void resetVisited(){
            this.isVisited = false;
        }
        public char getType(){
            return this.type;
        }

    }
}
