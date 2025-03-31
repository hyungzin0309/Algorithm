# 다이나믹 프로그래밍(Dynamic Programming, DP)

## 1. 다이나믹 프로그래밍 개념
다이나믹 프로그래밍(DP)은 **중복되는 부분 문제(overlapping subproblems)** 를 해결하고, **최적 부분 구조(optimal substructure)** 를 가지는 문제를 효율적으로 푸는 기법이다.  
이 기법은 작은 문제의 해를 저장하여 반복 계산을 줄이는 **메모이제이션(memoization)** 또는 **바텀업(bottom-up) 방식**을 사용한다.

---

## 2. DP의 핵심 개념

### 1) 중복되는 부분 문제 (Overlapping Subproblems)
- 문제를 작은 하위 문제로 나눴을 때, 같은 하위 문제가 여러 번 반복되는 특성을 의미한다.
- 예시: 피보나치 수열을 재귀로 계산할 때 같은 피보나치 값을 여러 번 계산하는 문제 발생.

### 2) 최적 부분 구조 (Optimal Substructure)
- 큰 문제의 최적 해가 작은 문제의 최적 해로 구성되는 성질을 의미한다.
- 예시: 최단 경로 문제에서 부분 경로의 최단 경로가 전체 경로의 최단 경로를 구성.

---

## 3. 다이나믹 프로그래밍 접근 방식

### 1) 탑다운(Top-Down) 방식 (재귀 + 메모이제이션)
- 큰 문제를 작은 문제로 쪼개면서 재귀적으로 해결.
- 계산한 값을 저장하여 동일한 계산을 반복하지 않음.

### 2) 바텀업(Bottom-Up) 방식 (반복문)
- 작은 문제부터 차근차근 값을 구하면서 큰 문제를 해결.
- 일반적으로 **배열을 사용하여 값을 저장**하며, 재귀보다 **스택 오버플로우 위험이 적다.**

---

## 4. 예제 코드 (자바)

### 1) 피보나치 수열 (DP 적용 전)
아래와 같은 **일반적인 재귀 코드**는 중복 계산이 많아 비효율적이다.

```java
public class Fibonacci {
    
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // 55
    }
}
```

위 코드의 문제점:
- 중복 계산이 많아 **시간복잡도 O(2ⁿ)**
- n이 커질수록 연산량이 기하급수적으로 증가

---

### 2) 피보나치 수열 (Top-Down 방식: 메모이제이션)
재귀 호출 시 계산된 값을 저장하여 중복 계산을 방지한다.

```java
import java.util.*;

public class FibonacciMemo {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // 55
    }
}
```

**시간복잡도 O(n)** 으로 개선됨.

---

### 3) 피보나치 수열 (Bottom-Up 방식)
반복문을 이용하여 작은 문제부터 값을 저장하며 해결.

```java
public class FibonacciBottomUp {
    public static int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // 55
    }
}
```

공간을 최적화할 수도 있다.

```java
public class FibonacciOptimized {
    public static int fib(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // 55
    }
}
```

---

## 5. DP를 활용한 문제 예제

### 1) 0-1 배낭 문제 (Knapsack Problem)
물건마다 무게와 가치가 주어졌을 때, 배낭에 넣을 수 있는 **최대 가치**를 구하는 문제.

```java
public class Knapsack {
    
    public static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 5;
        System.out.println(knapsack(weights, values, W)); // 7
    }
}
```

---

### 2) 최장 공통 부분 수열 (LCS: Longest Common Subsequence)
두 문자열이 주어졌을 때, **가장 긴 공통 부분 문자열의 길이**를 구하는 문제.

```java
public class LCS {
    public static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcs("ABCBDAB", "BDCAB")); // 4
    }
}
```

---

## 6. 다이나믹 프로그래밍의 시간복잡도 분석
- **피보나치 수열 (일반 재귀)** → O(2ⁿ) (비효율적)
- **피보나치 수열 (메모이제이션, 바텀업)** → O(n)
- **0-1 배낭 문제** → O(nW) (n: 아이템 수, W: 배낭 용량)
- **최장 공통 부분 수열** → O(mn) (m, n: 문자열 길이)

---

## 7. 다이나믹 프로그래밍 문제를 푸는 팁
1. **문제를 작은 부분 문제로 나눌 수 있는가?**
2. **부분 문제의 답을 저장하면 중복 계산을 줄일 수 있는가?**
3. **재귀(Top-Down)와 반복문(Bottom-Up) 중 어느 것이 적합한가?**
4. **공간 최적화가 가능한가? (1차원 배열, 변수 사용 등)**

---

## 8. 정리
- DP는 **중복 계산을 줄이고, 최적 부분 구조를 활용**하는 알고리즘 기법.
- **메모이제이션(Top-Down)과 바텀업 방식**을 활용해 최적화.
- 다양한 최적화 문제(배낭 문제, LCS, LIS 등)에 활용 가능.