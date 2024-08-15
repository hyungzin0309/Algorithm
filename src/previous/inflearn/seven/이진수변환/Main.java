package previous.inflearn.seven.이진수변환;

public class Main {

    public static void main(String[] args) {
        print(4);
    }

    public static void print(int num){
        if(num / 2 == 0){
            System.out.print(1);
            return;
        }
        print(num/2);
        System.out.print(num % 2);
    }
}
