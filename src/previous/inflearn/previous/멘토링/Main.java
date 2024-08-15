package previous.inflearn.previous.멘토링;
import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int studentNum = sc.nextInt();
        int testNum = sc.nextInt();
        System.out.println(solution(studentNum,testNum,sc));
    }

    public static int solution(int studentNum, int testNum, Scanner sc){
        int result = 0;
        int[][] nums = new int[testNum][studentNum];
        for(int i = 0; i<testNum; i++){
            for(int j = 0; j<studentNum; j++){
                nums[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i<studentNum; i++){ // i번 학생이
            for(int j = 0; j<studentNum; j++){ // j번 학생에게
                boolean flag = true;
                for(int k = 0; k<testNum; k++){ // k번째 시험의 등수를 묻는다
                    int myOrder = -1; // 나의 등수
                    int versusOrder = -1; // 상대방 등수
                    for(int a = 0; a < studentNum; a++){
                        int student = nums[k][a];
                        if(student == i+1) myOrder = a;
                        if(student == j+1) versusOrder = a;
                    }
                    if(myOrder >= versusOrder) {
                        flag = false; break;
                    }
                }
                if(flag) result++;
            }
        }


        return result;
    }

}
