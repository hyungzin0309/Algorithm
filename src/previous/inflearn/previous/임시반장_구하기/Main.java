package previous.inflearn.previous.임시반장_구하기;
import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(solution(num,sc));
    }

    public static int solution(int num, Scanner sc){
        int[][] nums = new int[num][5];
        for(int i = 0; i<num; i++){
            for(int j = 0; j<5; j++){
                nums[i][j] = sc.nextInt();
            }
        }

        int student = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < num; i++){
            int count = 0;
            for(int j = 0; j < num; j++){
                for(int k = 0; k<5; k++){
                    if(nums[i][k] == nums[j][k]){
                        count++;
                    }
                }
            }
            if(max < count){
                max = count;
                student = i+1;
            }
        }
        return student;
    }

}
