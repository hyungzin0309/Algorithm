package inflearn.ten.계단오르기;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stairs = sc.nextInt();
        solution();
    }

    static int stairs;
    static int result = 0;
    public static void solution(){
        dfs(1);
        dfs(2);
        System.out.println(result);
    }

    public static void dfs(int num){
        if(num < stairs){
            dfs(num+1);
            dfs(num+2);
        }else if(num == stairs){
            result++;
        }
    }

}
