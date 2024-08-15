package previous.baekjoon.class_.class2.나이순_정렬;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Member[] arr = new Member[num];
        for(int i = 0; i< num; i++){
            String[] s = br.readLine().split(" ");
            arr[i] = new Member(i,Integer.parseInt(s[0]),s[1]);
        }
        Arrays.sort(arr);
        for(Member m : arr){
            bw.write(m.toString());
        }
        bw.flush();
    }

    static class Member implements Comparable<Member>{
        int num;
        int age;
        String name;

        Member(int num, int age, String name){
            this.num = num;
            this.age = age;
            this.name = name;
        }

        public int compareTo(Member other){
            return other.age == this.age? this.num - other.num : this.age - other.age;
        }

        public String toString(){
            return age + " " + name + "\n";
        }
    }

}
