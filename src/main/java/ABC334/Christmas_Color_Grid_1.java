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
        Helper.setIncidentVertices(graph, H, W);
        Helper.categorizeConnectionGroup(graph, H, W);
        int groupCnt = Helper.getCategorizedConnectionGroupCnt(graph, H, W);
        for (int i = 0; i < H ; i++) {
            for (int j = 0; j < W; j++) {
                if(graph[i][j].getSymbol() == '.'){
                    patternCnt++;
                    Set<Integer> uniqueGroupNums = new HashSet<>();
                    if(i > 0){
                        if(graph[i-1][j].getSymbol() == '#'){
                            uniqueGroupNums.add(graph[i-1][j].getGroupNum());
                        }
                    }
                    if(i < H-1){
                        if(graph[i+1][j].getSymbol() == '#'){
                            uniqueGroupNums.add(graph[i+1][j].getGroupNum());
                        }
                    }
                    if(j > 0){
                        if(graph[i][j-1].getSymbol() == '#'){
                            uniqueGroupNums.add(graph[i][j-1].getGroupNum());
                        }
                    }
                    if(j < W-1){
                        if(graph[i][j+1].getSymbol() == '#'){
                            uniqueGroupNums.add(graph[i][j+1].getGroupNum());
                        }
                    }
                    int reductionCnt = uniqueGroupNums.size() - 1;
                    int reducedGroupCnt = groupCnt - reductionCnt;
                    sumConnectionGroup += reducedGroupCnt;
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
        public static int categorizeConnectionGroup(Vertex[][] graph, int H, int W) {
            int groupCnt = 0;
            Set<Vertex> seenElements = new HashSet<>();
            Queue<Vertex> todoQueue = new LinkedList<>();
            int groupCategory = 0;
            while(true){
                outerLoop:
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if(graph[i][j].symbol == '#' && !graph[i][j].seen){
                            todoQueue.add(graph[i][j]);
                            groupCnt++;
                            groupCategory++;
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
                    targetVertex.setGroupNum(groupCategory);
                    if(targetVertex.incidentVertices != null){
                        for(Vertex incidentVertex : targetVertex.getIncidentVertices()){
                            if(incidentVertex.isSeen()){
                                continue;
                            }

                            todoQueue.add(incidentVertex);
                        }
                    }
                }
            }
            return groupCnt;
        }
        static int getCategorizedConnectionGroupCnt(Vertex[][] graph, int H, int W){
            int groupCnt = 0;
            for (int i = 0; i < H;  i++){
                for (int j = 0; j < W; j++) {
                    if (graph[i][j].groupNum > groupCnt) {
                        groupCnt = graph[i][j].groupNum;
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
        private ArrayList<Vertex> incidentVertices;
        private int groupNum;
        public Vertex(char symbol, int row, int col){
            this.symbol = symbol;
            seen = false;
            incidentVertices = new ArrayList<>();

        }

        public char getSymbol(){
            return symbol;
        }
        public void setSymbol(char symbol){
            this.symbol = symbol;
        }
        public void setGroupNum(int groupNum){
            this.groupNum = groupNum;
        }
        public int getGroupNum(){
            return groupNum;
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
