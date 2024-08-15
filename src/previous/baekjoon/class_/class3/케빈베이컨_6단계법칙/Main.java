package previous.baekjoon.class_.class3.케빈베이컨_6단계법칙;

import java.io.*;
import java.util.*;

public class Main {

    static int num;
    static int lines;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static List<Result> resultList = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        num = Integer.parseInt(s[0]);
        lines = Integer.parseInt(s[1]);

        for(int i = 0; i< lines; i++){
            String[] t = br.readLine().split(" ");
            int p1 = Integer.parseInt(t[0]);
            int p2 = Integer.parseInt(t[1]);
            List<Integer> list1 = map.getOrDefault(p1, new ArrayList<>());
            list1.add(p2);
            map.put(p1, list1);
            List<Integer> list2 = map.getOrDefault(p2, new ArrayList<>());
            list2.add(p1);
            map.put(p2, list2);
        }

        for(int i = 1; i< num+1; i++){
            int result = 0;
            for(int j = 1; j<num+1; j++){
                if(i != j) result += bfs(i,j);
            }
            resultList.add(new Result(i, result));
        }

        Collections.sort(resultList);
        bw.write(String.valueOf(resultList.get(0).person));
        bw.flush();
    }

    static int bfs(int p1, int p2){
        int[] memory = new int[num+1];
        Queue<Integer> queue = new LinkedList<>(map.get(p1));
        int level = 1;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i<length; i++){
                int friend = queue.poll();
                if(friend == p2) return level;
                if(memory[friend] != 1){
                    memory[friend] = 1;
                    queue.addAll(map.get(friend));
                }
            }
            level++;
        }
        return -1;
    }

    static class Result implements Comparable<Result>{
        int person;
        int result;

        public Result(int p, int r){
            this.person = p;
            this.result = r;
        }

        public int compareTo(Result o){
            return this.result == o.result ? this.person - o.person : this.result - o.result;
        }
    }

}
