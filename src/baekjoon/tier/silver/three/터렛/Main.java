package baekjoon.tier.silver.three.터렛;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cases = Integer.parseInt(br.readLine());

        for(int i = 0; i < cases; i++){
            bw.write(String.valueOf(sol(br.readLine().split(" ")))+"\n");
        }

        bw.flush();
    }

    static int cases;

/**
5
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
0 0 7 4 3 1
0 0 6 4 3 1
*/
    static int sol(String[] pointString){
        int[] p = new int[6];
        for(int i = 0; i<6; i++){
            p[i] = Integer.parseInt(pointString[i]);
        }

        Circle c1 = new Circle(p[0], p[1], p[2]);
        Circle c2 = new Circle(p[3], p[4], p[5]);
        return c1.getPointsWithOther(c2);
    }

    static class Circle{
        int x;
        int y;
        int r;

        public Circle(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public int getPointsWithOther(Circle other){
            if(isSamePoint(other)){
                if(other.r ==this.r) {
                    return -1;
                }else {
                    return 0;
                }
            }

            int distanceX = Math.abs(other.x - this.x);
            int distanceY = Math.abs(other.y - this.y);
            Double distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));

            int rSum = this.r + other.r;
            int rMinus = Math.abs(this.r - other.r);

            if(rSum < distance || distance < rMinus){
                return 0;
            }else if(rSum == distance || distance == rMinus){
                return 1;
            }else{
                return 2;
            }
        }

        private boolean isSamePoint(Circle other){
            return other.x == this.x && other.y == this.y;
        }

    }

}
