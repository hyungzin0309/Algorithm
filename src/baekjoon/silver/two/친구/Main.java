package baekjoon.silver.two.친구;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        map = new char[num][num];
        for(int i = 0; i< num; i++){
            String line = br.readLine();
            for(int j = 0; j< num; j++){
                map[i][j] = line.charAt(j);
            }
        }
        relation = new int[num];
        for(int i = 0; i<num; i++){
            relation[i] = i;
        }
        sol();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static int num;
    static int[] relation;
    static char[][] map;
    static int result = 0;

    static void sol(){
       for(int k = 0; k<num; k++){
           int temp = 0;
           for(int i = 0; i<num; i++){
               for(int j = 0; j<num; j++){
                   if(map[k][i] == 'Y' || (map[k][j]=='Y' && map[i][j]=='Y' && i != k)){
                       temp++;
                       break;
                   }
               }
           }
           result = Math.max(temp,result);
       }
    }
}
