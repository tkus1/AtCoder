package src.main.java.AlgorithmAndMath;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Main046 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCnt = scanner.nextInt();
        int colCnt = scanner.nextInt();
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();
        Coordinate[][] table = new Coordinate[rowCnt + 1][colCnt + 1];
        for(int i = 1; i < rowCnt + 1; i++){
            String string = scanner.next();
            for (int j = 1; j < colCnt + 1; j++) {
                table[i][j] = new Coordinate(i, j, string.charAt(j - 1));
            }
        }
        Queue<Coordinate> todo = new LinkedList<>();
        Coordinate startPoint = table[startX][startY];
        startPoint.setDistance(0);
        todo.add(startPoint);
        while(!todo.isEmpty()){
            Coordinate point = todo.poll();
            Coordinate[] targetPoints = new Coordinate[4];
            targetPoints[0] = table[point.getX()-1][point.getY()];
            targetPoints[1] = table[point.getX()+1][point.getY()];
            targetPoints[2] = table[point.getX()][point.getY()-1];
            targetPoints[3] = table[point.getX()][point.getY()+1];
            for(Coordinate targetPoint : targetPoints){
                if(targetPoint.getSeen()){
                    continue;
                }
                //if(Objects.equals(table[targetPoint.getX()][targetPoint.getY()], ".")){
                if(table[targetPoint.getX()][targetPoint.getY()].getSymbol() == '.'){
                    targetPoint.setDistance(Math.min(point.getDistance()+1,targetPoint.getDistance()));
                    if(!todo.contains(targetPoint)){
                        todo.add(targetPoint);
                    }
                }
            }
            point.seen();
        }
        System.out.println(table[endX][endY].getDistance());
    }
    private static class Coordinate{
        final int x;
        final int y;
        int distance;
        private boolean seen;
        private char symbol;
        public Coordinate(int x, int y, char symbol){
            this.x = x;
            this.y = y;
            this.symbol = symbol;
            this.seen = false;
            this.distance = Integer.MAX_VALUE;
        }


        public int getX() {
            return x;
        }
        public int getY(){
            return y;
        }

        public char getSymbol() {
            return symbol;
        }

        public boolean getSeen(){
            return seen;
        }
        public void seen(){
            this.seen = true;
        }
        public int getDistance(){
            return distance;
        }
        public void setDistance(int distance){
            this.distance = distance;
        }

    }
}
