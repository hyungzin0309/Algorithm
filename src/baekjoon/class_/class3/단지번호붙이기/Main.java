package baekjoon.class_.class3.단지번호붙이기;

import java.io.*;
import java.util.*;

public class Main {

    static int num;
    static int[][] map;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        map = new int[num][num];
        for(int i = 0; i<num; i++){
            String s = br.readLine();
            for(int j = 0; j< num; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for(int i = 0; i<num; i++){
            for(int j = 0; j<num; j++){
                if(map[i][j] == 1) {
                    buildingNum = 0;
                    sol(i,j);
                    result.add(buildingNum);
                }
            }
        }
        Collections.sort(result);
        bw.write(result.size()+"\n");
        for(int n : result){
            bw.write(n+"\n");
        }
        bw.flush();
    }

    static int buildingNum;

    static void sol(int x, int y){
        map[x][y] = 0;
        buildingNum++;
        if(0<x && map[x-1][y]==1) sol(x-1,y);
        if(0<y && map[x][y-1]==1) sol(x,y-1);
        if(x<num-1 && map[x+1][y]==1) sol(x+1,y);
        if(y<num-1 && map[x][y+1]==1) sol(x,y+1);
    }
}
