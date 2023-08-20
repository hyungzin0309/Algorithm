package baekjoon.class_.class2.마인크래프트;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int y;
    static int x;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int inven;

    static Integer[] heightListAsc;

    static int resultSecond = Integer.MAX_VALUE;
    static int resultHeight;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        y = Integer.parseInt(s[0]);
        x = Integer.parseInt(s[1]);
        inven = Integer.parseInt(s[2]);
        for(int i = 0; i<y; i++){
            String line[] = br.readLine().split(" ");
            for(int j = 0; j<x; j++){
                int height = Integer.parseInt(line[j]);
                map.put(height, map.getOrDefault(height, 0)+1);
            }
        }
        heightListAsc = map.keySet().toArray(new Integer[0]);
        Arrays.sort(heightListAsc);
        sol();
        bw.write(resultSecond + " " + resultHeight);
        bw.flush();
    }

    static void sol(){
        for(int i = 0; i<=256; i++){
            sol(i);
        }
    }

    static void sol(int targetHeight){
        int result = 0;
        int inventory = inven;
        for(int height = heightListAsc[heightListAsc.length-1]; heightListAsc[0]<=height; height--){
            if(targetHeight < height){
                int gap = height - targetHeight;
                int k = map.getOrDefault(height,0);
                result += gap * k * 2;
                inventory += k * gap;
            }else if(height < targetHeight){
                int k = map.getOrDefault(height,0);
                int gap = targetHeight - height;
                if(inventory < k*gap) return;
                inventory -= k*gap;
                result += gap * k;
            }
        }

        if(result < resultSecond){
            resultSecond = result;
            resultHeight = targetHeight;
        }else if(result == resultSecond){
            resultHeight = Math.max(resultHeight, targetHeight);
        }
    }
}
