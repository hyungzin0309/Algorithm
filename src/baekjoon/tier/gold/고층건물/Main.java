package baekjoon.tier.gold.고층건물;

import java.io.*;
import java.util.*;

public class Main {

    static int num;
    static int[] buildings;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        buildings = new int[num+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i<=num; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        sol();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void sol(){
        for(int i = 1; i<= num; i++){
            int seeable = left(i) + right(i);
            result = Math.max(result, seeable);
        }
    }

    static int left(int buildingNum){
        int result = 0;
        double previousMinSlope = Double.POSITIVE_INFINITY;
        for(int i = buildingNum -1; i>= 1; i--){
            double slope = getSlope(i, buildingNum);
            if(slope < previousMinSlope){
                result++;
                previousMinSlope = slope;
            }
        }
        return result;
    }

    static int right(int buildingNum){
        int result = 0;
        double previousMaxSlope = Double.NEGATIVE_INFINITY;
        for(int i = buildingNum+1; i<=num; i++){
            double slope = getSlope(buildingNum, i);
            if(slope > previousMaxSlope){
                result++;
                previousMaxSlope = slope;
            }
        }
        return result;
    }

    static double getSlope(int leftNum, int rightNum){
        double leftHeight = buildings[leftNum];
        double rightHeight = buildings[rightNum];
        double slope = (rightHeight - leftHeight)/(rightNum - leftNum);
        return slope;
    }

}
