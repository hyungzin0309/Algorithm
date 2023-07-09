package programmers.level2.시소짝궁구하기;

import java.util.*;

public class Main {

    // 시소 거리 2, 3, 4
    // 100, 180, 360, 100, 270
    public static void main(String[] args) {
        int[] arr = new int[]{100,180,360,100,270};
        System.out.print(solution(arr));
    }
    public static Long solution(int[] weights) {
        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();

        Long result = 0L;
        for(int weight : weights) {
            double case1 = weight*1.0;
            double case2 = weight*2.0/3;
            double case3 = weight*1.0/2;
            double case4 = weight*3.0/4;
            result += map.getOrDefault(case1,0);
            result += map.getOrDefault(case2,0);
            result += map.getOrDefault(case3,0);
            result += map.getOrDefault(case4,0);
            map.put(weight*1.0, map.getOrDefault(weight*1.0,0)+1);
        }
        return result;
    }
}
