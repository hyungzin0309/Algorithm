package inflearn.seven.송아지찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int max = 20000;
    static int[] visited = new int[max];

    static int[] moving = {-1, 1, 5};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(solution2(start, end));
    }

    public static int solution(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return visited[current];
            }

            for (int i = 0; i < 3; i++) {
                int next = current + moving[i];

                if (next < 0 || next > max) {
                    continue;
                }

                if (visited[next] == 0 || visited[next] > visited[current] + 1) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }

        return -1;
    }

    public static int solution2(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int level = 0;
        while(!queue.isEmpty()){

            int length = queue.size();
            for(int i = 0; i<length; i++){
                int index = queue.poll();

                for(int j = 0; j<3; j++){
                    int next = index + moving[j];
                    if(next == end) return ++level;
                    if(next > max || next < 1) continue;
                    if(visited[next] == 0) {
                        visited[next] = 1;
                        queue.add(next);
                    }
                }

            }


            level++;
        }

        return -1;
    }
}
