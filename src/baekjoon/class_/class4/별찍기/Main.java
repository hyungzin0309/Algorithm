package baekjoon.class_.class4.별찍기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int num;

    static char[][] stars;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());

        stars = new char[num][2 * num - 1];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2 * num - 1; j++) {
                stars[i][j] = ' ';
            }
        }

        drawStar(0, num - 1, num);

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2 * num - 1; j++) {
                bw.write(stars[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void drawStar(int x, int y, int num) {
        if (num == 3) {
            stars[x][y] = '*';
            stars[x + 1][y - 1] = stars[x + 1][y + 1] = '*';
            stars[x + 2][y - 2] = stars[x + 2][y - 1] = stars[x + 2][y] = stars[x + 2][y + 1] = stars[x + 2][y + 2] = '*';
            return;
        }

        num /= 2;
        drawStar(x, y, num);
        drawStar(x + num, y - num, num);
        drawStar(x + num, y + num, num);
    }

}
