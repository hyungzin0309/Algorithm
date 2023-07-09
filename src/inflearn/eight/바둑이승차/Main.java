package inflearn.eight.바둑이승차;
import java.util.*;
public class Main {

    /**
     259 5
     81
     58
     42
     33
     61
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        num = sc.nextInt();
        dogs = new int[num];
        for(int i = 0; i< num; i++){
            dogs[i] = sc.nextInt();
        }
        dfs(0,0);
        System.out.print(Collections.max(list));
    }

    static int[] dogs;
    static int max;
    static int num;
    static List<Integer> list = new ArrayList<>();

    public static void dfs(int index, int weight){
        if(index == num){
            if(weight <= max) list.add(weight);
        }else{
            dfs(index+1, weight + dogs[index]);
            dfs(index+1, weight);
        }
    }

}
