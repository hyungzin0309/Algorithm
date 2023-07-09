package inflearn.nine.씨름선수;
import java.util.*;

public class Main {

    static int[][] arr;
    static int num;

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

    /**
     5
     172 67
     183 65
     180 70
     170 72
     181 60
     */
    private static int solution(){
        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
        Stack<Integer> weights = new Stack<>();

        for(int i = 0; i< num; i++){
            int weight = arr[i][1];
            while(weights.size() > 0 && weights.peek() < weight){
                weights.pop();
            }
            weights.push(weight);
        }

        return weights.size();
    }
}
