package inflearn.ten.동전교환_냅색;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        types = new Integer[num];
        for(int i = 0; i<num; i++){
            types[i] = sc.nextInt();
        }
        target = sc.nextInt();
        step = new int[target+1];
        solution();
        System.out.println(step[target]);
    }

    /**
     3
     1 2 5
     15
     */
    static int num;
    static Integer[] types;
    static int[] step;
    static int target;
    public static void solution(){
        Arrays.sort(types, (a1, a2)->a2-a1);
        for(int i = 0; i<types.length; i++){
            int coin = types[i];
            step[coin] = 1;
            for(int j = coin+1; j<=target; j++){
                if(step[j - coin] != 0) {
                    step[j] = step[j] == 0 ?
                            step[j] = step[j - coin] + 1 : Math.min(step[j], step[j - coin] + 1);
                }
            }
        }
    }

}
