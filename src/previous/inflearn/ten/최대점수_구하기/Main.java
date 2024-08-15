//package previous.inflearn.ten.최대점수_구하기;
//import java.util.*;
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        num = sc.nextInt();
//        questions = new int[num][2];
//        timeLimit = sc.nextInt();
//        for(int i = 0; i< num; i++){
//            questions[i][0] = sc.nextInt();
//            questions[i][1] = sc.nextInt();
//        }
//        solution();
//        System.out.println(max);
//    }
//
//    /**
//     5 20
//     10 5
//     25 12
//     15 8
//     6 3
//     7 4
//     */
//
//    static int num;
//    static int timeLimit;
//    static int[][] questions; // 점수, 시간
//    static int max = 0;
//    public static void solution(){
//        dfs(0,0, 0);
//    }
//
//    public static void dfs(int index, int time, int score){
//        if(index == num || time > timeLimit) {
//            if(score > max) max = score;
//            return;
//        }
//
//        int[] q = questions[index];
//        dfs(index+1, time+q[1], score + q[0]);
//        dfs(index+1, time, score);
//    }
//}

package previous.inflearn.ten.최대점수_구하기;
        import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        questions = new int[num][2];
        timeLimit = sc.nextInt();
        for(int i = 0; i< num; i++){
            questions[i][0] = sc.nextInt();
            questions[i][1] = sc.nextInt();
        }
        solution();
        System.out.println(max);
    }

    /**
     5 20
     10 5
     25 12
     15 8
     6 3
     7 4
     */

    static int num;
    static int timeLimit;
    static int[][] questions; // 점수, 시간
    static int max = 0;
    public static void solution(){
        dfs(0,0, 0);
    }

    public static void dfs(int index, int time, int score){
        int[] q = questions[index];
        if(time + q[1] < timeLimit){
            int summedScore = score + q[0];
            max = Math.max(summedScore, max);
            if(index+1 < num){
                dfs(index+1, time+q[1], summedScore);
            }
        }
        if(index+1 < num){
            dfs(index+1, time, score);
        }
    }
}

