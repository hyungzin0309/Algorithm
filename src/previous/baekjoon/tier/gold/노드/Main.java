package previous.baekjoon.tier.gold.노드;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int delete;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            int parent = Integer.parseInt(st.nextToken());
            List<Integer> children = map.getOrDefault(parent, new ArrayList<>());
            children.add(i);
            map.put(parent, children);
        }
        delete = Integer.parseInt(br.readLine());
        deleteChildren(delete);
        sol(-1);
        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void deleteChildren(int parent){
        for(int child : map.getOrDefault(parent, new ArrayList<>())){
            deleteChildren(child);
        }
        map.remove(parent);
    }

    public static void sol(int node){
        List<Integer> children = map.getOrDefault(node, new ArrayList<>());
        if(children.isEmpty() || (children.size()==1 && children.get(0) == delete)){
            if(node != -1){
                result++;
            }
        }else{
            for(int child : map.get(node)){
                if(child != delete){
                    sol(child);
                }
            }
        }
    }
}
