package inflearn.nine.친구인가_unionFind;
import java.util.*;
public class Main {

    static int[] students;
    static int num;
    static int coupleNum;

    /**
     9 7
     1 2
     2 3
     3 4
     1 5
     6 7
     7 8
     8 9
     3 8
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        coupleNum = sc.nextInt();
        students = new int[num+1];
        for(int i = 0; i<num+1; i++){
            students[i] = i;
        }
        for(int i = 0; i< coupleNum; i++){
            union(sc.nextInt(), sc.nextInt());
        }

        System.out.println(find(sc.nextInt()) == find(sc.nextInt()) ? "YES" : "NO");
    }

    public static void union(int s1, int s2){
        int group1 = find(s1);
        int group2 = find(s2);
        students[group1] = group2;
    }

    public static int find(int s1){
        if(students[s1] == s1) return s1;
        else return students[s1] = find(students[s1]);
    }
}
