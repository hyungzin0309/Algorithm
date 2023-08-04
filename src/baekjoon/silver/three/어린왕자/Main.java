package baekjoon.silver.three.어린왕자;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cases = Integer.parseInt(br.readLine());
        for(int i = 0; i< cases; i++){
            String[] line1 = br.readLine().split(" ");
            start = new int[]{Integer.parseInt(line1[0]), Integer.parseInt(line1[1])};
            end = new int[]{Integer.parseInt(line1[2]), Integer.parseInt(line1[3])};
            starNum = Integer.parseInt(br.readLine());
            stars = new Circle[starNum];
            for(int j = 0; j< starNum; j++){
                String[] s = br.readLine().split(" ");
                stars[j] = new Circle(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
            }
            bw.write(String.valueOf(sol())+"\n");
        }
        bw.flush();
    }

    static int cases;
    static int[] start;
    static int[] end;
    static int starNum;
    static Circle[] stars;

    static int sol(){
        int result = 0;
        for(Circle c : stars){
            boolean b1 = c.includePoint(start);
            boolean b2 = c.includePoint(end);
            if(b1 && !b2 || !b1 && b2) result++;
        }
        return result;
    }


    static class Circle{
        int x;
        int y;
        int r;

        public boolean includePoint(int[] point){
            return r < distance(point);
        }

        private Double distance(int[] point){
            return Math.sqrt(Math.pow(point[0]-x, 2) + Math.pow(point[1]-y, 2));
        }

        public Circle(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
