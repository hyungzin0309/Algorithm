package 취준_2025.구현.스타트링크_타워_1089_G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int[][][] map = new int[10][5][3];
    public static int[][][] input = new int[10][5][3];
    public static String nums =
            "###...#.###.###.#.#.###.###.###.###.###" +
            "#.#...#...#...#.#.#.#...#.....#.#.#.#.#" +
            "#.#...#.###.###.###.###.###...#.###.###" +
            "#.#...#.#.....#...#...#.#.#...#.#.#...#" +
            "###...#.###.###...#.###.###...#.###.###";
    public static double totalSum = 0;
    public static double totalNum = 1;
    public static boolean notNum = false;
    public static double[][] candidates;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        input = new int[n][5][3];

        StringBuilder inputStringBuilder = new StringBuilder();
        for(int i = 0; i< 5; i++){
            inputStringBuilder.append(br.readLine());
        }

        String inputString = inputStringBuilder.toString();

        // 입력값 초기화
        int gap = n * 3 + (n-1);
        for(int i = 0; i<n; i++){
            int start = i*4;
            for(int j = 0; j<5; j++){
                for(int k = 0; k<3; k++){
                    input[i][j][k] = inputString.charAt(start + k + j*gap) == '#' ? 1:0;
                }
            }
        }

        // 모든 숫자 정보 초기화
        for(int i = 0; i<10; i++){
            int start = i*4;
            for(int j = 0; j<5; j++){
                for(int k = 0; k<3; k++){
                    map[i][j][k] = nums.charAt(start + k + j*39) == '#' ? 1:0;
                }
            }
        }

        candidates = new double[n][2];

        for(int i = 0; i<n; i++){
            double sum = 0;
            int count = 0;
            boolean isUsed = false;
            for(int j = 0; j<10; j++){
                boolean isNum = isNum(i, j);
                if(isNum){
                    isUsed = true;
                    count++;
                    sum += j * Math.pow(10, n-1-i);
                }
                candidates[i][0] = count;
                candidates[i][1] = sum;
            }
            if(!isUsed){
                System.out.println(-1);
                return;
            }
        }

        for(int i = 0; i<n; i++){
            int situation = 1;
            for(int j = 0; j<n; j++){
                if(i != j){
                    situation *= candidates[j][0];
                }
            }
            totalNum *= candidates[i][0];
            totalSum += situation * candidates[i][1];
        }

        if(notNum) System.out.println(String.valueOf(-1));
        else System.out.println(totalSum / totalNum);
    }

    public static boolean isNum(int inputIndex, int numIndex){
        for(int i= 0; i<5; i++){
            for(int j = 0; j<3; j++){
                if(map[numIndex][i][j] == 0 && input[inputIndex][i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}
