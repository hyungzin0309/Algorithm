package baekjoon.tier.gold.방번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int cost[];
    static int money;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        money = Integer.parseInt(br.readLine());

        int mod = 0;
        int cipherMaxNum = 0; // 최대 자리수가 가능한 숫자 (중 가장 큰 수)
        int cipherMax = 0; // 가능한 가장 큰 자릿수
        int secondCipherMaxNum = 0; // 최대 자리수가 가능한 숫자 (중 가장 큰 수)
        int secondCipherMax = 0; // 가능한 가장 큰 자릿수
        for(int i = 0; i< n; i++){
            int quotient = money / cost[i]; // 특정 수로만 구성했을 때 최대 자리수
            int tempMod = money % cost[i]; // 나머지
            if(cipherMax <= quotient && mod <= tempMod){
                mod = tempMod;
                secondCipherMax = cipherMax;
                secondCipherMaxNum = cipherMaxNum;
                cipherMax = quotient;
                cipherMaxNum = i;
            }
        }

        int possibleMaxNum = n-1; // 넣을 수 있는 수 중 가장 큰 수

        StringBuilder sb = new StringBuilder();

        if(cipherMaxNum != 0){
            for(int i = 1; i<=cipherMax; i++){
                while(true){
                    if(cost[possibleMaxNum] + (cipherMax - i) * cost[cipherMaxNum] <= money){
                        sb.append(possibleMaxNum);
                        money -= cost[possibleMaxNum];
                        break;
                    }else{
                        possibleMaxNum--;
                    }
                }
            }
        }else{
            while(true){
                mod += cost[0];
                cipherMax--;
                if(cipherMax == -1){
                    sb.append("0");
                    break;
                }if(cipherMax == secondCipherMax){
                    cipherMax = secondCipherMax;
                    cipherMaxNum = secondCipherMaxNum;
                    for(int i = 1; i<=cipherMax; i++){
                        while(true){
                            if(cost[possibleMaxNum] + (cipherMax - i) * cost[cipherMaxNum] <= money){
                                sb.append(possibleMaxNum);
                                money -= cost[possibleMaxNum];
                                break;
                            }else{
                                possibleMaxNum--;
                            }
                        }
                    }
                }
                int canBuy = 0;
                for(int i = 1; i<n; i++){
                    if(cost[i] <= mod) canBuy = i;
                }
                if(canBuy != 0){
                    sb.append(canBuy);
                    for(int i = 0; i<cipherMax; i++){
                        sb.append("0");
                    }
                    break;
                }
            }
        }


        if(sb.toString().startsWith("0")) System.out.println(Integer.parseInt(sb.toString()));
        else System.out.println(sb);
    }
}
