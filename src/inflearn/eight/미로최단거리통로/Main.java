package inflearn.eight.미로최단거리통로;
import java.util.*;
public class Main {


    /*
    0 0 0 0 0 0 0
    0 1 1 1 1 1 0
    0 0 0 1 0 0 0
    1 1 0 1 0 1 1
    1 1 0 1 0 0 0
    1 0 0 0 1 0 0
    1 0 1 0 0 0 0
     */

    static int[][] maze = new int[7][7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.print(bfs());
    }

    public static int bfs(){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0,0});

        int level = 1;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                Integer[] point = queue.poll();
                int y = point[0];
                int x = point[1];
                if(y-1 >= 0 && maze[y-1][x] != 1){
                    queue.add(new Integer[]{y-1,x});
                    maze[y-1][x] = 1;
                }
                if(x-1 >= 0 && maze[y][x-1] != 1){
                    queue.add(new Integer[]{y,x-1});
                    maze[y][x-1] = 1;
                }
                if(y+1 < 7 && maze[y+1][x] != 1){
                    if(y+1 == 6 && x == 6) return level;
                    queue.add(new Integer[]{y+1,x});
                    maze[y+1][x] = 1;
                }
                if(x+1 < 7 && maze[y][x+1] != 1){
                    if(y == 6 && x+1 == 6) return level;
                    queue.add(new Integer[]{y,x+1});
                    maze[y][x+1] = 1;
                }
            }
            level++;
        }

        return -1;
    }


}
