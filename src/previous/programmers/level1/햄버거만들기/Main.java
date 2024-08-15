package previous.programmers.level1.햄버거만들기;
import java.util.*;
public class Main {


    // 1, 2, 3 -> 빵, 야채, 고기
    // 빵 - 야채 - 고기 - 빵
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.print(solution(arr));
    }

    public static int solution(int[] arr){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int a : arr){
            if(a == 1
                && stack.size() >= 3
                && stack.get(stack.size()-1) == 3
                && stack.get(stack.size()-2) == 2
                && stack.get(stack.size()-3) == 1){
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
            }else{
                stack.push(a);
            }
        }

        return answer;
    }
}
