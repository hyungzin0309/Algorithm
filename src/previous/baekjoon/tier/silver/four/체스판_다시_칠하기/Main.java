package previous.baekjoon.tier.silver.four.체스판_다시_칠하기;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nums = br.readLine();
        height = Integer.parseInt(nums.split(" ")[0]);
        width = Integer.parseInt(nums.split(" ")[1]);
        board = new char[height][width];

        for(int i = 0; i < height; i++){
            String line = br.readLine();
            char[] chars = line.toCharArray();
            board[i] = chars;
        }

        sol();
        bw.write(String.valueOf(min));
        bw.flush();
    }

    static int width;
    static int height;
    static char[][] board;
    static int min = Integer.MAX_VALUE;

    /**
10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB
     */
    public static void sol(){
        for(int i = 0; i <= height-8; i++){
            for(int j = 0; j<=width-8; j++){
                check(i,j);
            }
        }
    }


    public static void check(int x, int y){
        char[] colors = {'B', 'W'};
        for(int i = 0; i < 2; i++){
            int count = 0;
            for(int j = x; j < x+8; j++){
                for(int k = y; k < y+8; k++){
                    if(board[j][k] != colors[(j+k)%2]) count++;
                }
            }
            colors = new char[]{'W', 'B'};
            min = Math.min(min, count);
        }
    }
}
