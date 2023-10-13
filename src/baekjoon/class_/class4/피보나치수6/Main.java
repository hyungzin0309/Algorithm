package baekjoon.class_.class4.피보나치수6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1000000007;

    public static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    C[i][j] %= MOD;
                }
            }
        }
        return C;
    }

    public static long[][] pow(long[][] A, long n) {
        long[][] result = new long[][] {{1, 0}, {0, 1}}; // 단위 행렬
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, A);
            }
            A = multiply(A, A);
            n /= 2;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] A = {{1, 1}, {1, 0}};

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long[][] result = pow(A, n - 1);
        System.out.println(result[0][0]);
    }
}
