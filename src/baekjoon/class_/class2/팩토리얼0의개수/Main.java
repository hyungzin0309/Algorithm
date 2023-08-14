package baekjoon.class_.class2.팩토리얼0의개수;

import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        if(num == 0) bw.write(String.valueOf(0));
        else {
            BigInteger result = BigInteger.valueOf(1);
            for(int i = 1; i<=num; i++){
                result = result.multiply(BigInteger.valueOf(i));
            }
            int zeroNum = 0;
            while(result.remainder(BigInteger.valueOf(10)).equals(BigInteger.ZERO)){
                result = result.divide(BigInteger.valueOf(10));
                zeroNum++;
            }
            bw.write(String.valueOf(zeroNum));
        }
        bw.flush();
    }
}
