package baekjoon.tier.silver.five.단어정렬;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        arr = new String[num];
        for(int i = 0; i<num; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (a1, a2)->{
            if(a1.length() == a2.length()){
                int index = 0;
                while(index < a1.length()){
                    if(a1.charAt(index) != a2.charAt(index)) return a1.charAt(index) - a2.charAt(index);
                    index++;
                }
                return -1;
            }
            return a1.length() - a2.length();
        });

        String previous ="";
        for(String s : arr){
            if(!s.equals(previous))bw.write(s+"\n");
            previous = s;
        }
        bw.flush();
    }

    static String[] arr;
}
