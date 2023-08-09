package baekjoon.tier.silver.four.보물;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        a = new int[num];
        b = new int[num];
        bSorted = new int[num];
        String[] aString = br.readLine().split(" ");
        String[] bString = br.readLine().split(" ");
        for(int i = 0; i<num; i++){
            a[i] = Integer.parseInt(aString[i]);
            b[i] = Integer.parseInt(bString[i]);
            bSorted[i] = Integer.parseInt(bString[i]);
        }
        sol();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    /**
5
1 1 1 6 0
2 7 8 3 1
     */
    static int num;
    static int[] a;
    static int[] b;
    static int[] bSorted;
    static int result = 0;

    public static void sol(){
        Arrays.sort(a);
        Arrays.sort(bSorted);
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for(int i = 0; i<num; i++){
            Queue<Integer> orders = map.getOrDefault(bSorted[i], new LinkedList<>());
            orders.add(i);
            map.put(bSorted[i], orders);
        }

        for(int i = 0; i< num; i++){
            int order = map.get(b[i]).poll();
            result += a[num-order-1] * b[i];
        }

    }

}
