package baekjoon.class_.class3.회의실_배정;

import java.io.*;
import java.util.*;

public class Main {

    static int num;
    static Meeting[] meetings;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        meetings = new Meeting[num];
        for(int i = 0; i< num; i++){
            String[] s = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }
        Arrays.sort(meetings);
        int lastEnd = 0;
        int result = 0;
        for(int i = 0; i< num; i++){
            if(lastEnd <= meetings[i].start){
                result++;
                lastEnd = meetings[i].end;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }


    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        Meeting(int s, int e){
            start = s;
            end = e;
        }

        public int compareTo(Meeting o){
            return this.end == o.end ? this.start - o.start : this.end - o.end;
        }
    }
}
