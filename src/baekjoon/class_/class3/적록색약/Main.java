package baekjoon.class_.class3.적록색약;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int num;
    static char[][] arr;
    static char[][] arr2;
    static int result1 = 0;
    static int result2 = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        arr = new char[num][num];
        arr2 = new char[num][num];
        for (int i = 0; i < num; i++) {
            String line = br.readLine();
            for (int j = 0; j < num; j++) {
                char c = line.charAt(j);
                arr[i][j] = c;
                arr2[i][j] = c == 'G' ? 'R' : c;
            }
        }
        sol();
        bw.write(result1 + " " + result2);
        bw.flush();
    }

    static void sol(){
        for(int i = 0; i< num; i++){
            for(int j = 0; j<num; j++){
                if(arr[i][j] != 'A') {
                    char current = arr[i][j];
                    result1++;
                    arr[i][j] = 'A';
                    dfs(i,j,current,arr);
                }
                if(arr2[i][j] != 'A') {
                    char current = arr2[i][j];
                    result2++;
                    arr2[i][j] = 'A';
                    dfs(i,j,current,arr2);
                }
            }
        }
    }

    static void dfs(int i, int j, char current, char[][] arr){
        if(i > 0 && arr[i-1][j] == current){
            arr[i-1][j] = 'A';
            dfs(i-1, j, current, arr);
        }
        if(j > 0 && arr[i][j-1] == current){
            arr[i][j-1] = 'A';
            dfs(i, j-1, current, arr);
        }
        if(i < num-1 && arr[i+1][j] == current){
            arr[i+1][j] = 'A';
            dfs(i+1, j, current, arr);
        }
        if(j < num-1 && arr[i][j+1] == current){
            arr[i][j+1] = 'A';
            dfs(i, j+1, current, arr);
        }
    }

}
