package baekjoon.tier.gold.조각_움직이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int num = 0;
    static char[][] map = new char[5][5];
    static Map<String, Boolean> visited = new HashMap<>();
    static int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<5; i++){
            String line = br.readLine();
            for(int j = 0; j<5; j++){
                char c = line.charAt(j);
                map[i][j] = c;
                if(c == '*') num++;
            }
        }
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<char[][]> queue = new LinkedList<>();
        queue.add(map);
        int level = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i< length; i++){
                char[][] cur = queue.poll();
                if(isGoal(cur)) return level;
                for(int a = 0;a<5; a++){
                    for(int b = 0; b<5; b++){
                        if(cur[a][b] == '*'){
                            for(int k = 0; k<4; k++){
                                int ta = a + move[k][0];
                                int tb = b + move[k][1];
                                if(ta>= 0 && tb>=0 && ta<5 && tb<5 && cur[ta][tb] != '*'){
                                    char[][] moved = deepClone(cur);
                                    moved[ta][tb] = '*';
                                    moved[a][b] = '.';
                                    String movedString = arrToString(moved);
                                    if(!visited.getOrDefault(movedString, false)){
                                        queue.add(moved);
                                        visited.put(movedString, true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }

    static char[][] deepClone(char[][] arr){
        char[][] newOne = new char[5][5];
        for(int i = 0; i< 5; i++){
            for(int j = 0; j<5; j++){
                newOne[i][j] = arr[i][j];
            }
        }
        return newOne;
    }

    static boolean isGoal(char[][] arr){
        for(int i = 0; i< 5; i++){
            for(int j = 0; j<5; j++){
                if(arr[i][j] == '*'){
                    return check(arr, i, j);
                }
            }
        }
        return false;
    }

    static int[][] checkVisited = new int[5][5];

    static boolean check(char[][] arr, int x, int y){
        checkVisited = new int[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int result = 1;
        checkVisited[x][y] = 1;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i<length; i++){
                int[] cur = queue.poll();
                for(int j = 0; j<4; j++){
                    int a = cur[0] + move[j][0];
                    int b = cur[1] + move[j][1];
                    if(a>= 0 && b>=0 && a<5 && b<5 && checkVisited[a][b] == 0 && arr[a][b] == '*'){
                        result++;
                        checkVisited[a][b] = 1;
                        queue.add(new int[]{a,b});
                    }
                }
            }
        }
        return result == num;
    }

    static String arrToString(char[][] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< 5; i++){
            for(char a : arr[i]){
                sb.append(a);
            }
        }
        return sb.toString();
    }
}
