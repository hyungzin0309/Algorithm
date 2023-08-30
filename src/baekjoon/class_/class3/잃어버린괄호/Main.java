package baekjoon.class_.class3.잃어버린괄호;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("-");
        int result = 0;
        for(int i = 0; i< arr.length; i++){
            String s = arr[i];
            int temp = 0;
            for(String num : s.split("\\+")){
                temp += Integer.parseInt(num);
            }
            if(i == 0) result += temp;
            else result -= temp;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }


}
