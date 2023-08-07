package baekjoon.silver.two.수열의합;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        target = Integer.parseInt(line[0]);
        minLen = Integer.parseInt(line[1]);
        result = sol();
        for(int num : result){
            bw.write(String.valueOf(num+" "));
        }
        bw.flush();
    }

    static int target;
    static int minLen;
    static int maxLen = 100;
    static int[] result;

    static int[] sol(){
        for(int i = minLen; i<=maxLen; i++){
            if(i % 2 == 0){
                if(target % i != 0){
                    int start = (target / i) - ((i / 2) - 1);
                    int end = (target / i) + (i / 2);
                    if(start >= 0 && end >= 0 && sum(start, end) == target) return makeArr(start, end);
                }
            }
            else{
                if(target % i == 0){
                    int start = (target / i) - (i/2);
                    int end = (target / i) + (i/2);
                    if(start >= 0 && end >= 0 && sum(start, end) == target) return makeArr(start, end);
                }
            }
        }
        return new int[]{-1};
    }

    static int sum(int start, int end){
        int result = 0;
        for(int i = start; i <= end; i++){
            result += i;
        }
        return result;
    }

    static int[] makeArr(int start, int end){
        int[] result = new int[end - start + 1];
        for(int i = start; i <= end; i++){
            result[i - start] = i;
        }
        return result;
    }


}
