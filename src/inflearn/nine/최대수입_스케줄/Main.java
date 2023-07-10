package inflearn.nine.최대수입_스케줄;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for(int i = 0; i< num; i++){
            int pay = sc.nextInt();
            int day = sc.nextInt();
            if(day > lastDay) lastDay = day;

            List<Integer> list = map.getOrDefault(day, new ArrayList<>());
            list.add(pay);
            map.put(day, list);
        }
        System.out.println(solution());
    }

    /**
     6
     50 2
     20 1
     40 2
     60 3
     30 3
     30 1
     */
    static int num;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int lastDay = 0;
    public static int solution(){
        int result = 0;

        PriorityQueue<Integer> rest = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = lastDay; i>0; i--){
            rest.addAll(map.getOrDefault(i, new ArrayList<>()));
            if(!rest.isEmpty()){
                result += rest.poll();
            }
        }

        return result;
    }
}
