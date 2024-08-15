package previous.baekjoon.tier.silver.four.수열정렬;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        sorted = new int[num];
        origin = new int[num];
        b = new int[num];
        int idx = 0;
        for(String n : br.readLine().split(" ")){
            origin[idx] = Integer.parseInt(n);
            sorted[idx++] = Integer.parseInt(n);
        }

        sol();
        for(int i = 0; i<num; i++){
            bw.write(b[i]+" ");
        }
        bw.flush();
    }

    static int num;
    static int[] origin;
    static int[] sorted;
    static int[] b;

    public static void sol(){
        Arrays.sort(sorted);

        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for(int index = 0; index< num; index++){
            int currentNum = sorted[index];
            Queue<Integer> queue = map.getOrDefault(currentNum, new LinkedList<>());
            queue.add(index);
            map.put(currentNum, queue);
        }

        for(int i = 0; i< num; i++){
            int temp = map.get(origin[i]).poll();
            System.out.println(temp);
            b[i] = temp;
        }
    }

/**

3
2 3 1

 */

}
