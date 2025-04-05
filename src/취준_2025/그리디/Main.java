package 취준_2025.그리디;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int target;
    public static int packagePrice = Integer.MAX_VALUE;
    public static int numPrice = Integer.MAX_VALUE;
    public static int total = 0;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        int brandNum = Integer.parseInt(st.nextToken());
        for(int i = 0; i< brandNum; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            packagePrice = Math.min(packagePrice, p);
            numPrice = Math.min(numPrice, n);
        }
        if(target >= 6){
            if(numPrice * 6 > packagePrice){
                total += packagePrice * (target / 6);
            }else{
                total += numPrice * (target - (target % 6));
            }
        }

        int can1 = (target % 6) * numPrice;

        total += Math.min(can1, packagePrice);

        System.out.println(String.valueOf(total));
    }
}
