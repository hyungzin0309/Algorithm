package programmers.PCCP.제1회;
import java.util.*;

class Solution2 {

    public int result = 0;
    public int step;
    public int[][] arr;
    public int studentNum;

    public int solution(int[][] ability) {
        step = ability[0].length;
        arr = ability;
        studentNum = ability.length;

        for(int i = 0; i< studentNum; i++){
            Map<Integer,Integer> previous = new HashMap<>();
            previous.put(i,1);
            dfs(previous, ability[i][0]);
        }

        return result;
    }

    public void dfs(Map<Integer,Integer> previous, int sum){
        if(previous.size() == step){
            result = Math.max(result, sum);
        }else{
            for(int i = 0; i< studentNum; i++){
                if(previous.getOrDefault(i,0)==0){
                    int ability = arr[i][previous.size()];
                    sum += ability;
                    previous.put(i,1);
                    dfs(previous, sum);
                    previous.remove(i);
                    sum -= ability;
                }
            }
        }
    }
}