package previous.programmers.PCCP.제1회;
import java.util.*;

class Solution {
    public String solution(String input_string) {
        Map<Character,Integer> map = new HashMap<>();
        char previous = 'A';
        List<Character> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : input_string.toCharArray()){
            if(previous != c){
                previous = c;
                map.put(c, map.getOrDefault(c, 0)+1);
            }
        }

        for(char c : map.keySet()){
            if(map.get(c) > 1) result.add(c);
        }
        Collections.sort(result);
        for(char c : result){
            sb.append(c);
        }
        if(result.isEmpty()) sb.append("N");
        return sb.toString();
    }
}