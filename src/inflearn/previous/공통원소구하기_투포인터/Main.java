package inflearn.previous.공통원소구하기_투포인터;

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int arr1[] = new int[num1];
        for(int i = 0; i<num1; i++){
            arr1[i] = sc.nextInt();
        }
        int num2 = sc.nextInt();
        int arr2[] = new int[num2];
        for(int i = 0; i<num2; i++){
            arr2[i] = sc.nextInt();
        }

        solution(arr1, arr2 , num1 , num2);
    }

    public static void solution(int[] arr1, int[] arr2, int length1, int length2){
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int aIndex = 0;
        int bIndex = 0;

        while(aIndex < length1 && bIndex < length2){
            if(arr1[aIndex] == arr2[bIndex]){
                result.add(arr1[aIndex]);
                aIndex++;
                bIndex++;
            }
            else if(arr1[aIndex] <arr2[bIndex]){
                aIndex++;
            }else{
                bIndex++;
            }
        }

        for(Integer num : result){
            System.out.print(num + " ");
        }
    }

}
