package baekjoon.class_.class2.좌표정렬;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Point[] arr = new Point[num];
        for(int i = 0; i< num; i++){
            String[] s = br.readLine().split(" ");
            arr[i] = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Arrays.sort(arr);
        for(int i = 0; i < num; i++){
            bw.write(arr[i].toString());
        }
        bw.flush();
    }

    static class Point implements Comparable{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object other) {
            Point o = (Point)other;
            return o.x == this.x ? this.y - o.y : this.x - o.x;
        }

        public String toString(){
            return x+" "+y+"\n";
        }
    }
}
