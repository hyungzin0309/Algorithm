package previous.inflearn.nine.친구인가_bfs;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        coupleNum = sc.nextInt();
        visited = new boolean[num];
        for(int i = 0; i<coupleNum; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            List<Integer> list1 = map.getOrDefault(num1, new ArrayList<>());
            list1.add(num2);
            List<Integer> list2 = map.getOrDefault(num2, new ArrayList<>());
            list2.add(num1);
            map.put(num1, list1);
            map.put(num2, list2);
        }
        question[0] = sc.nextInt();
        question[1] = sc.nextInt();
        System.out.println(solution());
    }

    /**
     9 7
     1 2
     2 3
     3 4
     1 5
     6 7
     7 8
     8 9
     3 8
     */

        static int num;
        static int coupleNum;
        static Map<Integer, List<Integer>> map = new HashMap<>();
        static int[] question = new int[2];
        static boolean[] visited;

        public static String solution(){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(question[0]);

            while(!queue.isEmpty()){
                int len = queue.size();
                for(int i = 0; i< len; i++){
                    int current = queue.poll();
                    if(current == question[1]) {
                        return "YES";
                    }
                    if(!visited[current]){
                        visited[current] = true;
                        queue.addAll(map.getOrDefault(current,new ArrayList<>()));
                    }
                }
            }

            return "NO";
    }
}