package inflearn.previous.compareble_인터페이스;

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Coordinate> coordinates = new ArrayList<>();
        for(int i = 0; i< n; i++){
            coordinates.add(new Coordinate(sc.nextInt(),sc.nextInt()));
        }
        solution(n, coordinates);
    }

    public static void solution(int n, List<Coordinate> coordinates){
        coordinates.sort(Comparator.naturalOrder());
        for(int i = 0; i<n; i++){
            System.out.println(coordinates.get(i).toString());
        }
    }

    public static class Coordinate implements Comparable<Coordinate>{
        int x;
        int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        @Override
        public int compareTo(Coordinate other) {
            if(this.getX() < other.getX()) return -1; // -1 : 자신이 other보다 작다 (앞 순서)
            if(this.getX() == other.getX() && this.getY() < other.getY()) return -1;
            if(this.getX() == other.getX() && this.getY() == other.getY()) return 0; // 같다
            return 1; // 자신이 other보다 크다 (뒷 순서)
        }

        public String toString(){
            return x + " " + y;
        }
    }

}
