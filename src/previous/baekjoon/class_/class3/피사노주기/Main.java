package previous.baekjoon.class_.class3.피사노주기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(reader.readLine());

        int a = 1;
        int b = 1;
        int count = 0;

        while(true) {
            System.out.println(count);
            int next = (a + b) % m;
            a = b;
            b = next;
            count ++;

            if (a == 1 && b == 1) {
                break;
            }
        }

        System.out.println(count);
    }
}
