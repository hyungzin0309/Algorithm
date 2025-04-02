package 취준_2025.구현.이차원배열과연산_17140_G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int targetN;
    public static int targetM;
    public static int targetNum;
    public static int[][] map;
    public static int n;
    public static int m;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        targetN = Integer.parseInt(st.nextToken())-1;
        targetM = Integer.parseInt(st.nextToken())-1;
        targetNum = Integer.parseInt(st.nextToken());
        map = new int[100][100];
        n = 3;
        m = 3;

        for(int i = 0; i< 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(sol());
    }

    public static int sol(){
        int seconds = 0;
        while(map[targetN][targetM] != targetNum){
            if(seconds >= 100) return -1;
            int[][] newMap = new int[100][100];
            if(n >= m){
                int newM = 0;
                //행 데이터 정렬
                for(int i =0; i<n; i++){
                    Map<Integer, Integer> group = new HashMap<>();
                    for(int j = 0; j<m; j++){
                        int val = map[i][j];
                        if(val != 0){
                            int num = group.getOrDefault(val, 0);
                            group.put(val, num+1);
                        }
                    }
                    Queue<Data> queue = new PriorityQueue<>();
                    for(int key : group.keySet()){
                        int val = key;
                        int num = group.get(key);
                        queue.add(new Data(val, num));
                    }
                    int length = queue.size(); // 원래 데이터 개수
                    while(!queue.isEmpty()){
                        int valIndex = (length - queue.size()) * 2;
                        int numIndex = valIndex + 1;
                        if(valIndex >= 100) break;
                        Data data = queue.poll();
                        newMap[i][valIndex] = data.val;
                        newMap[i][numIndex] = data.num;
                    }
                    newM = Math.max(newM, group.keySet().size() * 2);
                    newM = Math.min(100, newM);
                }
                m = newM;
                map = newMap;
            }else{
                //열 데이터 정렬
                int newN = 0;
                for(int j =0; j<m; j++){
                    Map<Integer, Integer> group = new HashMap<>();
                    for(int i = 0; i<n; i++){
                        int val = map[i][j];
                        if(val != 0){
                            int num = group.getOrDefault(val, 0);
                            group.put(val, num+1);
                        }
                    }
                    Queue<Data> queue = new PriorityQueue<>();
                    for(int key : group.keySet()){
                        int val = key;
                        int num = group.get(key);
                        queue.add(new Data(val, num));
                    }
                    int length = queue.size(); // 원래 데이터 개수
                    while(!queue.isEmpty()){
                        int valIndex = (length - queue.size()) * 2;
                        int numIndex = valIndex + 1;
                        if(valIndex >= 100) break;
                        Data data = queue.poll();
                        newMap[valIndex][j] = data.val;
                        newMap[numIndex][j] = data.num;
                    }
                    newN = Math.max(newN, group.keySet().size() * 2);
                    newN = Math.min(100, newN);
                }
                n = newN;
                map = newMap;
            }
            seconds++;
        }
        return seconds;
    }

    public static class Data implements Comparable<Data>{
        int val;
        int num;

        public Data(int val, int num){
            this.val = val;
            this.num = num;
        }

        @Override
        public int compareTo(Data other){
            if(other.num == this.num) return this.val - other.val;
            return this.num - other.num;
        }
    }
}
