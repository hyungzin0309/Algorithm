package inflearn.seven.부분집합모두구하기_DFS;

public class Main {

    static int num;
    static boolean isUsed[];

    public static void main(String[] args) {
        num = 3;
        isUsed = new boolean[num+1];
        dfs(1);
    }

    public static void dfs(int current){
        if(current == num+1){
            print();
        }else{
            isUsed[current] = true; // 사용
            dfs(current+1);
            isUsed[current] = false; // 사용하지 않음
            dfs(current+1);
        }
    }

    public static void print(){
        for(int i = 1; i<isUsed.length; i++){
            if(isUsed[i]) System.out.print(i+" ");
        }
        System.out.println();
    }

}
