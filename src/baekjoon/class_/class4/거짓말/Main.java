package baekjoon.class_.class4.거짓말;

import java.io.*;
import java.util.*;

public class Main {

    static int personNum;
    static int partyNum;
    static Map<Integer,List<Integer>> parties = new HashMap<>();
    static int[] group;
    static int cannotLiePerson = 0;

    public static void main(String[] args) throws Exception{
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        personNum = Integer.parseInt(s[0]);
        group = new int[personNum + 1];
        for(int i = 1; i<=personNum; i++){
            group[i] = i;
        }
        partyNum = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        if(!s1[0].equals("0") )cannotLiePerson = Integer.parseInt(s1[1]);
        for(int i = 2; i <= Integer.parseInt(s1[0]); i++){
            union(Integer.parseInt(s1[i]),Integer.parseInt(s1[i-1]));
        }
        for(int i = 0; i< partyNum; i++){
            String[] p = br.readLine().split(" ");
            List<Integer> persons = new ArrayList<>();
            for(int k = 1; k<=Integer.parseInt(p[0]); k++){
                int num1 = Integer.parseInt(p[k]);
                int num2 = Integer.parseInt(p[k-1]);
                persons.add(num1);
                if(k != 1) union(num1, num2);
            }
            parties.put(i,persons);
        }

        for(int party : parties.keySet()){
            boolean canLie = true;
            List<Integer> persons = parties.get(party);
            for(int pnum : persons){
                if(find(cannotLiePerson) == find(pnum)) {
                    canLie = false;
                    break;
                }
            }
            if(canLie) result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    static int find(int pnum){
        if(pnum == group[pnum]) return pnum;
        return group[pnum] = find(group[pnum]);
    }

    static void union(int p1, int p2){
        int group1 = find(p1);
        int group2 = find(p2);
        if(group1 != group2) group[group1] = group2;
    }
}
