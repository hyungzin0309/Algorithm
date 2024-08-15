package previous.baekjoon.tier.silver.two.유기농배추;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cases = Integer.parseInt(br.readLine());

        for(int i = 0; i < cases; i++){
            String[] line = br.readLine().split(" ");
            result = 0;
            width = Integer.parseInt(line[0]);
            height = Integer.parseInt(line[1]);
            cabbageNum = Integer.parseInt(line[2]);
            map = new int[height][width];
            for(int j = 0; j< cabbageNum; j++){
                String[] l = br.readLine().split(" ");
                int x = Integer.parseInt(l[0]);
                int y = Integer.parseInt(l[1]);
                map[y][x] = 1;
            }
            sol();
            bw.write(String.valueOf(result)+"\n");
        }
        bw.flush();
    }

    static int cases;
    static int width;
    static int height;
    static int cabbageNum;
    static int[][] map;
    static int result;

    static void sol(){
        for(int i = 0; i<height; i++){
            for(int j = 0; j< width; j++){
                if(map[i][j] == 1){
                    dfs(i, j);
                    result++;
                }
            }
        }
    }

    static void dfs(int y, int x){
        map[y][x] = 0;
        if(y != 0 && map[y-1][x] == 1) dfs(y-1, x);
        if(x != 0 && map[y][x-1] == 1) dfs(y, x-1);
        if(y != height-1 && map[y+1][x] == 1) dfs(y+1, x);
        if(x != width-1 && map[y][x+1] == 1) dfs(y, x+1);
    }

}
