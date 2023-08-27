package baekjoon.class_.class2.프린터큐;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for(int i = 0; i<cases; i++){
            bw.write(sol()+"\n");
        }
        bw.flush();
    }

    static int sol() throws Exception{
        String[] s = br.readLine().split(" ");
        String[] nums = br.readLine().split(" ");
        int num = Integer.parseInt(s[0]);
        int targetIndex = Integer.parseInt(s[1]);
        Map<Integer, Integer> map = new HashMap<>();
        Queue<File> queue = new LinkedList<>();
        for(int i = 0; i< num; i++){
            boolean isTarget = i == targetIndex;
            int important = Integer.parseInt(nums[i]);
            File file = new File(important, isTarget);
            map.put(important, map.getOrDefault(important,0)+1); // 중요도 별 남아있는 개수
            queue.add(file);
        }

        int result = 0;
        while(true){
            File current = queue.poll();
            if(current.important == findMostImportant(map)){
                result++;
                map.put(current.important,map.get(current.important)-1);
                if(current.isTarget) break;
            }
            else queue.add(current);
        }

        return result;
    }

    static int findMostImportant(Map<Integer, Integer> map){
        for(int i = 9; i>0; i--){
            if(map.getOrDefault(i, 0 ) != 0) return i;
        }
        return 1;
    }

    static class File{
        int important;
        boolean isTarget;

        File(int important, boolean isTarget){
            this.important = important;
            this.isTarget = isTarget;
        }
    }
}
