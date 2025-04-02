package 취준_2025.브루트포스.괄호추가하기_16637_G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int result = Integer.MIN_VALUE;
    public static String string;
    public static int length;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        length = Integer.parseInt(br.readLine());
        string = br.readLine();

        int first = Integer.parseInt(String.valueOf(string.charAt(0)));
        sol(first, 0);
        System.out.println(result);
    }

    public static void sol(int num, int index) {
        if (index == length - 1) {
            result = Math.max(result, num);
            return;
        }

        // 앞이랑 그냥 계산
        {
            int current = Integer.parseInt(String.valueOf(string.charAt(index + 2)));
            int caled = cal(num, string.charAt(index + 1), current);
            sol(caled, index + 2);
        }

        // 뒤랑 먼저 계산
        if (index + 4 < length) {

            int a = Integer.parseInt(String.valueOf(string.charAt(index + 2)));
            int b = Integer.parseInt(String.valueOf(string.charAt(index + 4)));
            char c = string.charAt(index + 3);
            int reverseCaled = cal(a, c, b);

            int caled = cal(num, string.charAt(index + 1), reverseCaled);
            sol(caled, index + 4);
        }

    }

    public static int cal(int a, char c, int b) {
        int result;
        switch (c) {
            case '+' : result = a + b; break;
            case '-' :  result = a - b; break;
            default : result = a * b;
        }
        return result;
    }
}
