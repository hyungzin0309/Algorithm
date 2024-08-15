package previous.baekjoon.class_.class3.리모컨;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int target;
    static int targetLength;
    static int brokenNum;
    static List<String> numButton = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        target = Integer.parseInt(br.readLine());
        brokenNum = Integer.parseInt(br.readLine());
        for(int i = 0; i<10; i++){
            numButton.add(String.valueOf(i));
        }
        if(brokenNum != 0){
            String[] bs = br.readLine().split(" ");
            for(String s : bs){
                for(int i = 0; i<numButton.size(); i++){
                    if(numButton.get(i).equals(s)) {
                        numButton.remove(i);
                        continue;
                    }
                }
            }
        }

        min = Math.min(min, Math.abs(100-target));
        if(numButton.size() == 1 && numButton.get(0).equals("0")) min = Math.min(min, target+1);
        else if(numButton.size() != 0){
            targetLength = String.valueOf(target).length();

            // 한자리 아래 수 중 가장 큰 값
            if(2 <= targetLength){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<targetLength-1; i++){
                    sb.append(numButton.get(numButton.size()-1));
                }
                min = Math.min(min, target - Integer.parseInt(sb.toString()) + targetLength-1);
            }

            // 한자리 위인 수 중 가장 작은 값
            if(numButton.get(0).equals("0")){
                StringBuilder sb = new StringBuilder(numButton.get(1));
                for(int i = 0; i<targetLength; i++){
                    sb.append("0");
                }
                min = Math.min(min, Integer.parseInt(sb.toString()) - target + targetLength+1);
            }else{
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<targetLength+1; i++){
                    sb.append(numButton.get(0));
                }
                min = Math.min(min, Integer.parseInt(sb.toString()) - target + targetLength+1);
            }

            //같은 자리 수
            dfs(new StringBuilder());
        }
        bw.write(String.valueOf(min));
        bw.flush();
    }

    static void dfs(StringBuilder sb){
        if(sb.length() == targetLength){
            min = Math.min(min, Math.abs(Integer.parseInt(sb.toString()) - target) + targetLength);
            return;
        }

        for(String s : numButton){
            sb.append(s);
            dfs(sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
