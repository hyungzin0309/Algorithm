package previous.inflearn.nine.결혼식;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for(int i = 0; i<num; i++){
            in.add(sc.nextInt());
            out.add(sc.nextInt());
        }
        System.out.println(solution());
    }


    /**
     5
     14 18
     12 15
     15 20
     20 30
     5 14
     */
    static int num;
    static PriorityQueue<Integer> in = new PriorityQueue<>();
    static PriorityQueue<Integer> out = new PriorityQueue<>();

    public static int solution(){
        int result = 0;
        int current = 0;

        while(!(in.isEmpty() && out.isEmpty())){

            if(in.isEmpty() || out.peek() <=in.peek()){
                out.poll();
                current --;
            }else if(out.isEmpty() || in.peek() < out.peek()){
                in.poll();
                current ++;
            }

            if(current > result) result = current;

        }

        return result;
    }
}










