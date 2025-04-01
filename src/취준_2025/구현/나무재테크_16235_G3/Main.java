package 취준_2025.구현.나무재테크_16235_G3;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int m;
    public static int k;
    public static int[][] map;
    public static int[][] add;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        add = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
                add[i][j] = val;
            }
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }

        System.out.println(sol());
    }

    public static Queue<Tree> trees = new PriorityQueue<>();

    public static int sol(){
        for(int year = 0; year< k; year++){
            // 봄
            Queue<Tree> previous = trees;
            Queue<Tree> newQueue = new PriorityQueue<>();
            List<Tree> deadList = new ArrayList<>();
            while(!previous.isEmpty()){
                Tree tree = previous.poll();
                if(map[tree.x][tree.y] >= tree.age){
                    map[tree.x][tree.y] -= tree.age;
                    tree.aged();
                    newQueue.add(tree);
                }else{
                    deadList.add(tree);
                }
            }
            trees = newQueue;
            //여름
            for(Tree d : deadList){
                map[d.x][d.y] += d.age /2;
            }

            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            //가을
            newQueue = new PriorityQueue<>();
            for(Tree tree : trees){
                newQueue.add(tree);
                int age = tree.age;
                if(age % 5 ==0){
                    for(int k = 0; k<8; k++){
                        int nx = tree.x + dx[k];
                        int ny = tree.y + dy[k];
                        if(nx==tree.x&& ny==tree.y) continue;
                        if(nx>= n|| ny>=n || nx < 0 || ny < 0) continue;
                        newQueue.add(new Tree(nx,ny,1));
                    }
                }
            }
            trees = newQueue;
            //겨울
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    map[i][j] += add[i][j];
                }
            }
        }

        return trees.size();
    }

    public static String key(int x, int y){
        return "x"+x+"y"+y;
    }

    public static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;

        public void aged(){
            this.age += 1;
        }

        public Tree(int x,int y,int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree other){
            return this.age - other.age;
        }
    }
}
