package baekjoon.tier.gold.제곱ㄴㄴ수;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //1000000000000 1000001000000

    static Long min;
    static Long max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        int[] isMultiNum = new int[(int)(max - min + 1)];
        int lastPrime = (int)Math.sqrt(max);
        for(int i = 2; i <= lastPrime; i++){
            long square = i * 1L * i;
            long start = ((min + square -1) / square) * square;
            long startIndex = (start - min);
            for(long j = startIndex; j< isMultiNum.length; j += square){
                isMultiNum[(int)j] = 1;
            }
        }

        int result = 0;
        for(int i = 0; i<isMultiNum.length; i++){
            if(isMultiNum[i] == 0) result++;
        }
        System.out.println(result);
    }


//
//        public static void main(String[] args) throws Exception {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//            long min = Long.parseLong(st.nextToken());
//            long max = Long.parseLong(st.nextToken());
//
//            boolean[] isSquareFree = new boolean[(int) (max - min + 1)];
//            for (long i = 2; i * i <= max; i++) {
//                long square = i * i;
//                long start = ((min + square - 1) / square) * square;
//                for (long j = start; j <= max; j += square) {
//                    if (j >= min) isSquareFree[(int) (j - min)] = true;
//                }
//            }
//
//            int count = 0;
//            for (boolean b : isSquareFree) if (!b) count++;
//            System.out.println(count);
//        }
//

}
