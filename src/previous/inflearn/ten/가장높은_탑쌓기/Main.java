package previous.inflearn.ten.가장높은_탑쌓기;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for(int i = 0; i< num; i++){
            int area = sc.nextInt();
            int length = sc.nextInt();
            int weight = sc.nextInt();
            bricks.add(new Brick(area,length,weight));
            summed.add(length);
        }
        solution();
        System.out.println(maxLen);
    }

    /**
     5
     25 3 4
     4 4 6
     9 2 3
     16 2 5
     1 5 2
     */
    static int num;
    static List<Brick> bricks = new ArrayList<>();
    static List<Integer> summed = new ArrayList<>();
    static int maxLen = 0;

    public static void solution(){
        Collections.sort(bricks);
        for(int i = 0; i<num; i++){
            Brick current = bricks.get(i);
            int previousMaxLen = 0;
            int j = 0;

            while(j < i){
                Brick previous = bricks.get(j);
                if(previous.area > current.area && previousMaxLen < summed.get(j)){
                    previousMaxLen = summed.get(j);
                }
               j++;
            }

            summed.set(i,previousMaxLen + current.length);
            if(maxLen < summed.get(i)) maxLen = summed.get(i);
        }
    }


    public static class Brick implements Comparable<Brick>{
        int area;
        int length;
        int weight;

        public Brick(int area, int length, int weight){
            this.area= area;
            this.length = length;
            this. weight = weight;
        }

        @Override
        public int compareTo(Brick other){
            return other.weight == this.weight ?
                    other.area - this.area : other.weight - this.weight;
        }

    }
}
