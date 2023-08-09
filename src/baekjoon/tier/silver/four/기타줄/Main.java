package baekjoon.tier.silver.four.기타줄;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String l1 = br.readLine();
        need = Integer.parseInt(l1.split(" ")[0]);
        brands = Integer.parseInt(l1.split(" ")[1]);
        sixNumMax = (need/6);

        for(int i = 0; i< brands; i++){
            String line = br.readLine();
            int six = Integer.parseInt(line.split(" ")[0]);
            int one = Integer.parseInt(line.split(" ")[1]);

            sixPriceMin =Integer.min(six, sixPriceMin);
            onePriceMin =Integer.min(one, onePriceMin);
        }

        for(int i = 0; i <= sixNumMax; i++){
            result = Integer.min(result, (i * sixPriceMin) + ((need - (i * 6)))*onePriceMin);
        }

        result = Integer.min(result, ((sixNumMax+1) * sixPriceMin));

        bw.write(String.valueOf(result));
        bw.flush();
    }

    /**
10 3
20 8
40 7
60 4
     */

    static int need;
    static int brands;
    static int sixPriceMin = Integer.MAX_VALUE;
    static int onePriceMin = Integer.MAX_VALUE;
    static int sixNumMax;
    static int result = Integer.MAX_VALUE;

}
