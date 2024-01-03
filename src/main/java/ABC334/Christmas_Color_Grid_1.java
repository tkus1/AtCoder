package src.main.java.ABC334;

import java.util.*;
public class Christmas_Color_Grid_1 {
    public static void main(String[] args) {
        final long MOD_NUM = 998244353;
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        Vertex[][] graph = new Vertex[H][W];
        for (int i = 0; i < H ; i++) {
            String thisLine = scanner.next();
            for (int j = 0; j < W; j++) {
                graph[i][j] = new Vertex(thisLine.charAt(j), i, j);
            }
        }
        int patternCnt = 0;
        int sumConnectionGroup = 0;
        for (int i = 0; i < H ; i++) {
            for (int j = 0; j < W; j++) {
                if(graph[i][j].getSymbol() == '.'){
                    patternCnt++;
                    graph[i][j].setSymbol('#');
                    Helper.setIncidentVertices(graph, H, W);
                    sumConnectionGroup += Helper.countConnectionGroup(graph, H, W);
                    graph[i][j].setSymbol('.');
                    Helper.resetAllVertices(graph, H, W);
                }

            }
        }

        int gcd = Helper.gcd(patternCnt, sumConnectionGroup);
        patternCnt /= gcd;
        sumConnectionGroup /= gcd;
        long inverseQ = Helper.modInverse(patternCnt, MOD_NUM);

        long ans = ((long) sumConnectionGroup * inverseQ % MOD_NUM);
        System.out.println(ans);
    }
    public static class Helper{
        public static int countConnectionGroup(Vertex[][] graph, int H, int W) {
            int groupCnt = 0;
            Set<Vertex> seenElements = new HashSet<>();
            Queue<Vertex> todoQueue = new LinkedList<>();

            while(true){
                outerLoop:
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if(graph[i][j].symbol == '#' && !graph[i][j].seen){
                            todoQueue.add(graph[i][j]);
                            groupCnt++;
                            break outerLoop;
                        }
                    }
                }
                if(todoQueue.isEmpty()){
                    break;
                }
                while(!todoQueue.isEmpty()){
                    Vertex targetVertex = todoQueue.poll();
                    if(targetVertex.isSeen()){
                        continue;
                    }
                    targetVertex.seen();
                    if(targetVertex.incidentVertices != null){
                        for(Vertex incidentVertex : targetVertex.getIncidentVertices()){
                            if(incidentVertex.isSeen()){
                                continue;
                            }
                            //if(todoQueue.contains(incidentVertex)){
                            //    continue;
                            //}
                            todoQueue.add(incidentVertex);
                        }
                    }
                }
            }
            return groupCnt;
        }
        public static void setIncidentVertices(Vertex[][] graph, int H, int W){
            for (int i = 0; i < H-1; i++) {
                for (int j = 0; j < W; j++) {
                    if(graph[i][j].getSymbol() == '#' && graph[i+1][j].getSymbol() == '#'){
                        graph[i][j].addIncidentVertex(graph[i+1][j]);
                        graph[i+1][j].addIncidentVertex(graph[i][j]);
                    }
                }
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W-1; j++) {
                    if(graph[i][j].getSymbol() == '#' && graph[i][j+1].getSymbol() == '#'){
                        graph[i][j].addIncidentVertex(graph[i][j+1]);
                        graph[i][j+1].addIncidentVertex(graph[i][j]);
                    }
                }
            }
        }
        public static void resetAllVertices(Vertex[][] graph, int H, int W){
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    graph[i][j].resetIncidentVertices();
                    graph[i][j].resetSeen();
                }
            }
        }
        public static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
        public static long modInverse(long a, long m) {
            long m0 = m;
            long y = 0, x = 1;

            while (a > 1) {
                long q = a / m;
                long t = m;

                m = a % m;
                a = t;
                t = y;

                y = x - q * y;
                x = t;
            }

            return (x + m0) % m0;
        }
    }
    public static class Vertex{
        private char symbol;
        private boolean seen;
        private final int col;
        private final int row;
        private ArrayList<Vertex> incidentVertices;
        public Vertex(char symbol, int row, int col){
            this.symbol = symbol;
            this.col = col;
            this.row = row;
            seen = false;
            incidentVertices = new ArrayList<>();
        }
        public int getCol(){
            return col;
        }
        public int getRow() {
            return row;
        }

        public char getSymbol(){
            return symbol;
        }
        public void setSymbol(char symbol){
            this.symbol = symbol;
        }

        public boolean isSeen() {
            return seen;
        }
        public void seen(){
            seen = true;
        }
        public void addIncidentVertex(Vertex incidentVertex){
            incidentVertices.add(incidentVertex);
        }
        public ArrayList<Vertex> getIncidentVertices(){
            return incidentVertices;
        }
        public void resetIncidentVertices(){
            incidentVertices = new ArrayList<>();
        }
        public void resetSeen(){
            seen = false;
        }
    }
}
