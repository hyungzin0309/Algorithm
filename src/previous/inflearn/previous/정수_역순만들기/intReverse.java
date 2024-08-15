package previous.inflearn.previous.정수_역순만들기;

import java.util.Scanner;

public class intReverse{

    // 정수 뒤집기
    public static int getReverse(int num){
        int result = 0;
        while(num > 0){
            result *= 10;
            result += (num % 10);
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(solution(num,sc));
    }

    public static String solution(int count, Scanner sc) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<count; i++){
            int num = sc.nextInt();
            int reverse = getReverse(num);
            if(isPrime(reverse))result.append(reverse + " ");
        }
        return result.toString();
    }

    private static boolean isPrime(int reverse) {
        if(reverse == 1)return false;
        boolean isPrime = true;
        for(int i = 2; i<reverse/2+1; i++){
            if(reverse % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;

    }

}
