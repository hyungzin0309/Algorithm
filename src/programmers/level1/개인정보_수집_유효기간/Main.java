package programmers.level1.개인정보_수집_유효기간;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String today = "2020.12.01";
        String[] terms = new String[]{"Z 3", "D 12"};
        String[] privacies = new String[]{"2019.12.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    public static Integer[] solution(String todayString, String[] terms, String[] privacies){
        Policies policies = new Policies(terms);
        Day today = new Day(todayString);
        List<Privacy> privacyList = new ArrayList<>();

        for (String privacy : privacies) {
            Privacy privacy1 = new Privacy(privacy);
            privacyList.add(privacy1);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= privacyList.size(); i++){
            if(privacyList.get(i-1).isExpired(policies, today)) result.add(i);
        }
        return result.toArray(Integer[]::new);
    }

    public static class Privacy {
        Day savedDay;
        String policy;

        public Privacy(String privacyString){
            String[] s = privacyString.split(" ");
            savedDay = new Day(s[0]);
            policy = s[1];
        }

        public boolean isExpired(Policies policies, Day today){
            int term = policies.getTerm(policy); // 사생활 정보의 유효기간
            Day expiringDay = savedDay.addMonth(term);
            System.out.println("expiringDay : " + expiringDay);
            return today.isLaterThan(expiringDay) || today.equals(expiringDay);
        }

    }

    public static class Policies {
        Map<String, Integer> policies = new HashMap<>();

        public Policies(String[] arr){
            for(String policy : arr){
                String[] s= policy.split(" ");
                policies.put(s[0], Integer.parseInt(s[1]));
            }
        }

        public int getTerm(String policy){
            return policies.get(policy);
        }
    }

    public static class Day{
        int year;
        int month;
        int day;

        public Day(String dayString){
            String[] data = dayString.split("\\.");
            year = Integer.parseInt(data[0]);
            month = Integer.parseInt(data[1]);
            day = Integer.parseInt(data[2]);
        }

        public Day addMonth(int month){
            this.month += month;
            System.out.println("added month : "+ this.month);
            if(this.month > 12){
                if(this.month % 12 == 0){
                    year += (this.month / 12)-1;
                    this.month = 12;
                }else {
                    year += (this.month / 12);
                    this.month %= 12;
                }
            }
            return this;
        }

        @Override
        public String toString(){
            return year + "." + month + "." + day;
        }

        public boolean isLaterThan(Day otherDay) {
            if(this.year > otherDay.year) return true;
            else if(this.year == otherDay.year && this.month > otherDay.month) return true;
            else if(this.year == otherDay.year && this.month == otherDay.month && this.day > otherDay.day) return true;
            else return false;
        }

        @Override
        public boolean equals(Object otherDay){
            Day other = (Day) otherDay;
            return this.year == other.year && this.month == other.month && this.day == other.day;
        }
    }

}
