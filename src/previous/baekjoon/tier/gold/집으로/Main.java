package previous.baekjoon.tier.gold.집으로;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int x;
    static int y;
    static double jumpDistance;
    static double jumpSecond;
    static double diagonal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        jumpDistance = Double.parseDouble(st.nextToken());
        jumpSecond = Double.parseDouble(st.nextToken());
        diagonal = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        double result;

        if(jumpDistance < diagonal){
            double quotient = (int)(diagonal / jumpDistance);
            double onlyJump = jumpSecond * (quotient+1);
            double jumpAndWalk = jumpSecond * quotient + (diagonal - (jumpDistance * quotient));
            result = Math.min(onlyJump, jumpAndWalk);
            result = Math.min(result, diagonal);
        }else{
            double onlyJump = jumpSecond * 2;
            double jumpAndWalk = jumpSecond + (jumpDistance - diagonal);
            result = Math.min(onlyJump, jumpAndWalk);
            result = Math.min(result, diagonal);
        }

        System.out.println(result);

    }


}
