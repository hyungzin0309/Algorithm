package programmers.level1.바탕화면정리;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        String[] wallPaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(Arrays.toString(solution(wallPaper)));;
    }

    public static int[] solution(String[] wallPaper){
        Integer top = null;
        Integer bottom = null;
        Integer left = null;
        Integer right = null;

        for(int i = 0; i < wallPaper.length; i++){
            String row = wallPaper[i];

            if(row.contains("#")) {
                if (top == null) top = i;
                bottom = i + 1;

                if(left == null || row.indexOf("#") < left) left = row.indexOf("#");
                if(right == null || row.lastIndexOf("#") +1 > right) right = row.lastIndexOf("#") + 1;
            }

        }

        return new int[]{top, left, bottom, right};
    }
}
