package previous.inflearn.nine.빈회의실;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        arr = new int[num][2];
        for(int i = 0; i<num; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(solution());
    }

    static int num;
    static int[][] arr;


    /**
     5
     1 4
     2 3
     3 5
     4 6
     5 7
     */
    private static int solution(){
        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
        int result = 0;
        int lastEnd = 0;

        for(int[] meeting : arr){
            int start = meeting[0];
            int end = meeting[1];

            if(start >= lastEnd){
                result++;
                lastEnd = end;
            }else if(end < lastEnd){
                lastEnd = end;
            }
        }

        return result;
    }
}
