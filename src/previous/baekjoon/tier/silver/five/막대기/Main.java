package previous.baekjoon.tier.silver.five.막대기;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        sol2(num);
//        divide(num);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void sol2(int num){
        for(char c : Integer.toBinaryString(num).toCharArray()){
            if(c == '1') result ++;
        }
    }

    static int result = 0;

    public static void divide(int num){
        if(num == 1){
            result++;
        }else{
            if(num % 2 == 1) {
                result++;
            }
            divide(num/2);
        }
    }


}
