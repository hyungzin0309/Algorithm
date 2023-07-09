package inflearn.eight.섬나라아일랜드;
import java.util.*;


public class BFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        guide = new int[num][num];
        for(int i = 0; i<num; i++){
            for(int j = 0; j<num; j++){
                guide[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        for(int i = 0; i<num; i++){
            for(int j = 0; j<num; j++){
                if(guide[i][j] == 1){
                    guide[i][j] = 0;
                    result++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(result);
    }

    /**
     7
     1 1 0 0 0 1 0
     0 1 1 0 1 1 0
     0 1 0 0 0 0 0
     0 0 0 1 0 1 1
     1 1 0 1 1 0 0
     1 0 0 0 1 0 0
     1 0 1 0 1 0 0
     */

    static int num;
    static int[][] guide;
    static int[] direction = {-1, 0, 1};
    public static void bfs(int xxx, int yyy){

            Deque<int[]> que = new ArrayDeque<>();
            que.add(new int[]{xxx,yyy});

            while(!que.isEmpty()){
                int len = que.size();

                for(int i = 0; i<len; i++){
                    int[] target = que.poll();
                    int yTarget = target[0];
                    int xTarget = target[1];
                    for(int j = 0; j< 3; j++){
                        int dy = direction[j];
                        for(int k = 0; k<3; k++){
                            int dx = direction[k];

                            int y = yTarget+dy;
                            int x = xTarget+dx;

                            if(!(x == 0 && y == 0) && (0 <= y && y < num) && (x>=0 && x< num) && guide[y][x]==1){
                                guide[y][x] = 0;
                                que.add(new int[]{y, x});
                            }

                        }
                    }

                }

            }
    }

}








