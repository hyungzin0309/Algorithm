package programmers.level2.요격시스템;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        System.out.print(solution(arr));
    }

    public static int solution(int[][] arr){
        int answer = 0;
        Arrays.sort(arr, (o1, o2)->o1[1]-o2[1]);

        int last = 0;
        for(int[] target : arr){
            if(target[0] >= last) {
                answer++;
                last = target[1];
            }
        }

        return answer;
    }
}
