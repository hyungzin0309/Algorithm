package previous.programmers.PCCP.제1회;

import java.util.*;

class Solution3 {

    public String[] solution(int[][] queries) {
        int cases = queries.length;
        String[] answer = new String[cases];
        for(int i = 0; i< cases; i++){
            answer[i] = sol(queries[i][0],queries[i][1]);
        }
        return answer;
    }

    public String sol(int n, int p){
        return dfs(n, p);
    }

    public String dfs(int generation, int num){
        if(generation == 1) return "Rr";
        int remainder = num%4;
        int next = remainder == 0? num/4 : (num + (4-remainder)) / 4;
        return cases(dfs(--generation, next)).get(remainder == 0 ? 3 : remainder-1);
    }

    public List<String> cases(String s){
        if(s.equals("RR")) return RR();
        else if(s.equals("Rr")) return Rr();
        else return rr();
    }

    public List<String> RR(){
        List<String> result = new ArrayList<>();
        result.add("RR");
        result.add("RR");
        result.add("RR");
        result.add("RR");
        return result;
    }

    public List<String> Rr(){
        List<String> result = new ArrayList<>();
        result.add("RR");
        result.add("Rr");
        result.add("Rr");
        result.add("rr");
        return result;
    }

    public List<String> rr(){
        List<String> result = new ArrayList<>();
        result.add("rr");
        result.add("rr");
        result.add("rr");
        result.add("rr");
        return result;
    }
}
