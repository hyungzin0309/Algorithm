package previous.programmers.level2.광물캐기;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] picks = {1, 3, 2}; // 다이아, 철, 돌
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals){
        int result = 0;

        Map<Item, Integer> items = new HashMap<>();
        items.put(Item.DIA, picks[0]);
        items.put(Item.IRON, picks[1]);
        items.put(Item.STONE, picks[2]);

        Map<Integer, Integer> sectionLevels = new HashMap<>();
        Map<Integer, Item> sectionItem = new HashMap<>();

        for(int i = 0; i<minerals.length; i++){
            int section = i / 5;
            int level;
            switch (minerals[i]){
                case "diamond" : level = 25; break;
                case "iron" : level = 5; break;
                case "stone" : level = 1; break;
                default: throw new RuntimeException("유효하지 않은 광물");
            }
            sectionLevels.put(section, sectionLevels.getOrDefault(section, 0) + level);
        }

        List<Section> sectionList = new ArrayList<>();
        sectionLevels.forEach((key, val) -> sectionList.add(new Section(key,val)));
        Collections.sort(sectionList);

        Item[] itemsSorted = new Item[minerals.length/5 + 1];
        for(int i = 0; i<sectionList.size(); i++){
            Item item = null;
            if(items.get(Item.DIA) !=0){
                item = Item.DIA;
                items.put(Item.DIA, items.get(Item.DIA)-1);
            }else if(items.get(Item.IRON) !=0){
                item = Item.IRON;
                items.put(Item.IRON, items.get(Item.IRON)-1);
            }else if (items.get(Item.STONE) !=0){
                item = Item.STONE;
                items.put(Item.STONE, items.get(Item.STONE)-1);
            }
            itemsSorted[i] = item;
        }

        for(int i = 0; i< minerals.length; i++){
            Item item = itemsSorted[i/5];
            if(item == null) return result;
            result += item.getTiredNum(minerals[i]);
        }

        return result;
    }

    public static class Section implements Comparable{
        int sectionIndex;
        int sectionLevel;
        public Section(int index, int level){
            this.sectionIndex = index;
            this.sectionLevel = level;
        }

        @Override
        public int compareTo(Object o) {
            Section other = (Section) o;
            if (this.sectionLevel < other.sectionLevel) {
                return -1;
            } else if (this.sectionLevel > other.sectionLevel) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public enum Item{
        DIA{
            @Override
            public int getTiredNum(String mineral){
                return 1;
            }
        }, IRON{
            @Override
            public int getTiredNum(String mineral){
                switch (mineral){
                    case "diamond" : return 5;
                    default : return 1;
                }
            }
        }, STONE{
            @Override
            public int getTiredNum(String mineral){
                switch (mineral) {
                    case "diamond":
                        return 25;
                    case "iron":
                        return 5;
                    default:
                        return 1;
                }
            }
        };

        public abstract int getTiredNum(String mineral);
    }
}
