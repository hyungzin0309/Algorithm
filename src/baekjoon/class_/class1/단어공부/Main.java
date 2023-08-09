package baekjoon.class_.class1.단어공부;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toUpperCase().toCharArray()){
            int num = map.getOrDefault(c, 0);
            map.put(c, ++num);
        }
        int max = 0;
        char result = ' ';
        for(char key : map.keySet()){
            if(max == map.get(key)){
                result = '?';
            }else if(max < map.get(key)){
                max = map.get(key);
                result = key;
            }
        }
        bw.write(result);
        bw.flush();
    }
}
