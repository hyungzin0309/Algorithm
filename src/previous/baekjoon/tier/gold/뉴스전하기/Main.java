package previous.baekjoon.tier.gold.뉴스전하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    static Map<Integer, Node> nodes = new HashMap<>();
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int parent = Integer.parseInt(st.nextToken());
            Node node = new Node(i);
            nodes.put(i, node);
            if(parent != -1){
                nodes.get(parent).addChild(node);
            }
        }

        System.out.println(maxTime(0));
    }

    static int maxTime(int nodeNum){
        Node currentNode = nodes.get(nodeNum);
        if(currentNode.children.isEmpty()) return 0;

        List<Integer> times = new ArrayList<>();
        for(Node child : currentNode.children){
            times.add(maxTime(child.num));
        }
        Collections.sort(times, Collections.reverseOrder());
        int maxTime = 0;
        for(int i = 0; i< times.size(); i++){
            maxTime = Math.max(maxTime, times.get(i) + i + 1);
        }
        return maxTime;
    }

    static class Node{

        int num;
        List<Node> children = new ArrayList<>();

        public Node(int num){
            this.num = num;
        }

        public void addChild(Node c){
            children.add(c);
        }
    }
}
