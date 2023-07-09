package inflearn.eight.토마토;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    /**
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
     */
    static int todo;
    static int[][] tomatoes;
    static int width;
    static int height;
    static Deque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        width = Integer.parseInt(input[0]);
        height = Integer.parseInt(input[1]);
        tomatoes = new int[height][width];

        for(int i = 0; i<height; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j<width; j++) {
                int status = Integer.parseInt(input[j]);
                tomatoes[i][j] = status;
                if(status == 0) todo++;
                else if(status == 1) queue.add(new int[]{i,j});
            }
        }
        System.out.print(bfs());
    }

    public static int bfs(){
        if(todo == 0) return 0;
        int level = 1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                int[] point = queue.poll();
                int y = point[0];
                int x = point[1];

                if(y-1 >= 0 && tomatoes[y-1][x] == 0){
                    todo--;
                    if(todo==0) return level;
                    tomatoes[y-1][x] = 1;
                    queue.add(new int[]{y-1, x});
                }
                if(y+1 < height && tomatoes[y+1][x] == 0){
                    todo--;
                    if(todo==0) return level;
                    tomatoes[y+1][x] = 1;
                    queue.add(new int[]{y+1, x});
                }
                if(x-1 >= 0 && tomatoes[y][x-1] == 0){
                    todo--;
                    if(todo==0) return level;
                    tomatoes[y][x-1] = 1;
                    queue.add(new int[]{y, x-1});
                }
                if(x+1 < width && tomatoes[y][x+1] == 0){
                    todo--;
                    if(todo==0) return level;
                    tomatoes[y][x+1] = 1;
                    queue.add(new int[]{y, x+1});
                }
            }
            level++;
        }
        return -1;
    }
}
