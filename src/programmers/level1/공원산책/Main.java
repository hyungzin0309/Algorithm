package programmers.level1.공원산책;

import java.util.Arrays;

public class Main {

    /**
     * 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다.
     * 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.
     *
     * ["방향 거리", "방향 거리" … ]
     * 예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
     *
     * 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
     * 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
     * 위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
     * 공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.
     *
     * image
     *
     * 공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때,
     * 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
     */

    public static void main(String[] args){
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }

    public static int[] solution(String[] park, String[] routes) {
        int widthLastIndex = park[0].length()-1;
        int heightLastIndex = park.length-1;
        int[] current = getCurrent(park);

        for(String route : routes){
            MoveInfo moveInfo = new MoveInfo(route);
            int[] target = getTarget(current, moveInfo); // 목표지점 좌표
            try{
                checkValidate(target, heightLastIndex, widthLastIndex, moveInfo, park, current);
                current = target;
            }catch(Exception e){
            }
            // 3. 없으면 현재 좌표 변경
        }
        return current;
    }

    private static void checkValidate(int[] target, int heightLastIndex, int widthLastIndex, MoveInfo moveInfo, String[] park, int[] current) {
        // 1. 길이가 넘는지 체크
        if(target[0] > heightLastIndex || target[1] > widthLastIndex) throw new RuntimeException("공간 넘어감");
        // 2. 중간에 장애물 있는지
        if(moveInfo.getDirection().equals(MoveInfo.Direction.X)){
            String row = String.valueOf(park[current[0]]);
            int c = current[1];
            int t = target[1];
            if(c < t){
                for(int i = c; i <= t; i++){
                    if(row.charAt(i)=='X') throw new RuntimeException("장애물 있음.");
                }
            }else{
                for(int i = t; i <= c; i++){
                    if(row.charAt(i)=='X') throw new RuntimeException("장애물 있음.");
                }
            }
        }else{
            int xIndex = current[1];
            int c = current[0];
            int t = target[0];
            if(c < t){
                for(int i = c; i <= t; i++){
                    if(park[i].charAt(xIndex) == 'X') throw new RuntimeException("장애물 있음.");
                }
            }else{
                for(int i = t; i <= c; i++){
                    if(park[i].charAt(xIndex) == 'X') throw new RuntimeException("장애물 있음.");
                }
            }
        }
    }

    public static int[] getCurrent(String[] park){
        for(int y = 0; y< park.length; y++){
            for(int x = 0; x<park[0].length(); x++){
                System.out.print(park[y].charAt(x));
                if(park[y].charAt(x) == 'S'){
                    return new int[]{y,x};
                }
            }
            System.out.println();
        }

        throw new RuntimeException("현재 위치 정보 없음.");
    }

    public static int[] getTarget(int[] current, MoveInfo moveInfo){
        int h = current[0];
        int w = current[1];
        return switch (moveInfo.getDirection()) {
            case Y -> new int[]{h + moveInfo.getMove(), w};
            case X -> new int[]{h, w + moveInfo.getMove()};
        };
    }

    public static class MoveInfo {

        private final Direction direction;
        private final int move;

        public MoveInfo(String route){
            String[] r = route.split(" ");
            switch (r[0]) {
                case "S" -> {this.direction = Direction.Y; this.move = Integer.parseInt(r[1]);}
                case "N" -> {this.direction = Direction.Y; this.move = -Integer.parseInt(r[1]);}
                case "E" -> {this.direction = Direction.X; this.move = Integer.parseInt(r[1]);}
                case "W" -> {this.direction = Direction.X; this.move = -Integer.parseInt(r[1]);}
                default -> throw new RuntimeException("올바르지 않은 방향");
            }
        }

        public enum Direction{
            Y,X;
        }

        public int getMove(){
            return move;
        }

        public Direction getDirection(){
            return direction;
        }
    }
}











