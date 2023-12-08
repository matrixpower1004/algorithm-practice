# 자료구조와 알고리즘 공부 오답 노트 및 공부 정리
# Do it! 알고리즘 코딩테스트
## Chapter 3 자료구조
### 백준 11720 숫자의 합 구하기
- https://www.acmicpc.net/problem/11720
- BufferedReader 사용법은 자주 사용하지 않으니 매번 헷갈린다. 메모해 두고 복습하자.
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```
- char 타입을 int 타입으로 변환하는 방법은 두 가지가 있다.
```java
// 1. Ascii code를 이용하는 방법
char c1 = '9';
int num = c1 - '0';

// 2. Character.getNumericValue()를 이용하여 처리하는 방법
char c1 = '9';
int num = Character.getNumericValue(c1);
```
### 백준 1546 평균
- https://www.acmicpc.net/problem/1546
- 주어진 공식대로 배열을 순회하면서 max 값보다 작으면 점수를 조작했는데, 식을 간소화 하면 이런 불필요한 로직을 줄일 수 있었다.    
- `(A / M * 100 + B / M * 100 + C / M * 100) / 3 = (A + B + C) * 100 / M /3`
### 백준 11659 구간 합 구하기 4
- https://www.acmicpc.net/problem/11659
- StringTokenizer 사용 시 불필요한 hasMoreTokens() 체크 로직은 빼자.
- 합배열 공식 : `S[i] = S[i - 1] + A[i]`
- 구간 합 공식 : `S[toIndex] - S[fromIndex - 1]`
### 백준 11660 구간 합 구하기 5
- https://www.acmicpc.net/problem/11660
- 처음 구간합을 구할 때 행의 합만 구하고 열의 합을 구할 아이디어를 떠올리지 못했다.
- 2차원 배열 index : `int[][] arr = new int[row][column]`
- 합배열 공식 : `D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]`
- X1, Y1, X2, Y2 구간 합을 구하는 공식 : `D[X2][Y2] - D[X1-1][y2] - D[X2][Y1-1] + D[X1-1][Y1-1]`

### 백준 10986 나머지 합
- https://www.acmicpc.net/problem/10986
- 처음에는 구간합 배열에 구간합을 구해서 저장을 했는데 굳이 그럴 필요가 없었다. 문제가 요구하는 것은 결국 %M 했을 때의 나머지가 0인(나누어 떨어지는 수의) 개수를 구하는 것이다. 따라서 나머지 배열에 구간합 % M을 한 나머지를 인덱스로 값을 증가시키면 되었다.
- 임의의 수 x1, x2 를 입력 받았을 때 `(x1 + x2) % M 은 ((x1 % M) + (x2 % M)) % M` 과 같다. 이게 핵심 아이디어였다.
- 처음에는 if를 사용하여 나머지가 0일때 정답 변수의 값을 1 증가 시켰는데 굳이 그럴 필요가 없었다. 구간합을 구하면서 나누어 떨어진 수가 0이라면 나머지 저장 배열의 0번 인덱스에 저장될 것이므로, 계산 루틴이 끝난 후 0번 인덱스의 값을 꺼내고 + 각 인덱스에 저장된 값의 경우의 수를 계산하여 더해주면 되는 것이었다.

### 백준 2018  수들의 합 5
- https://www.acmicpc.net/problem/2018
- 투 포인터를 이용하여 O(n)의 시간복잡도로 특정 구간합을 계산할 수 있다는 것을 배웠다.
- 단, 투 포인터를 이용하려면 배열이 오름차순 정렬되어 있어야 한다.

### 백준 1940 주몽의 명령
- https://www.acmicpc.net/problem/1940
- 문제를 제대로 읽지 않아 두 수의 합을 구하는 것을 지나쳐서 어떤 알고리즘을 적용해야 하는지 고민만 했다. 문제의 요구사항과 예제 입출력을 잘 살펴보자. 

### 백준 1253 좋은 수
- https://www.acmicpc.net/problem/1253
- 투 포인터의 위치와 좋은 수의 배열에서의 위치는 별개로 생각해야 하는데 투 포인터의 위치를 좋은 수의 위치와 합쳐서 생각하는 오류가 있었다. 

### 백준 12891 DNA 비밀번호
* https://www.acmicpc.net/problem/12891
- 최초 부분 문자열 처리 loop가 종료된 후 ACGT의 문자열 개수가 요구하는 문자열 개수와 맞는지 체크해야 했는데, loop 도는 중에 계속 ACGT 문자의 개수를 체크하는 실수를 했다.
- 디버거 돌렸을 때도 체크된 값은 정상적으로 나왔기에 로직 이상을 발견하는데 시간이 많이 걸렸다.  

### 백준 11003 최솟값 찾기
- https://www.acmicpc.net/problem/11003
- ArrayDeque 클래스는 스택으로 사용할 경우 Stack 보다 빠르며, Queue 로 사용 할 경우 LinkedList 보다 빠를 가능성이 높다.
- ArrayDeque 에 Null 은 허용되지 않는다. 
- https://www.baeldung.com/java-array-deque
- https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html

### 백준 1874 스택 수열
- https://www.acmicpc.net/problem/1874
- 동시성 문제가 없다면 Stack 보다는 속도가 빠른 ArrayDeque 를 사용하자. Deque 의 addLast() 와 pollLast() 로 스택과 같은 기능을 구현할 수 있다. 
- 코드 작성보다 문제의 지문과 출력 예제를 보고 문제의 요구 사항을 파악하는 게 더 어려웠다.

### 백준 17298 오큰수
- https://www.acmicpc.net/problem/17298
- 반복문에서 출력을 해야 하는 경우 BufferedWriter를 쓰기 보다는 StringBuilder를 사용하여 `append()`를 해주고 나중에 `System.out.print()`를 해주는 게 조금 더 빠른 것 같다.
- 배열을 역순으로 탐색하면서 오큰수를 계산하는 아이디어를 떠올리지 못했다.

### 백준 2164 카드2
- https://www.acmicpc.net/problem/2164
- Queue와 Stack의 `poll()` 했을 때 데이터가 빠지는 위치를 헷갈려서 슈도 코드 작성에 애를 먹었다. Stack의 LIFO, Queue의 FIFO 특징을 잘 기억해두자.

### 백준 11286 절댓값 힙
- https://www.acmicpc.net/problem/11286
- `PriorityQueue` 대해서 알고 있고, customizing 할 수 있는지가 문제 풀이의 핵심이었는데 이 아이디어를 떠올리지 못했다.

### 백준 1377 버블소트
- https://www.acmicpc.net/problem/1377
- 처음에는 배열을 정렬해서 index 위치를 비교한다는 아이디어를 떠올리지 못해다.
- 굳이 배열을 정렬할 필요 없이 우선순위 큐를 이용하면 배열의 정렬에 드는 O(nlogn)의 시간을 줄일 수 있다.
 
# 패스트캠퍼스 알고리즘 코딩테스트 with Java 강의
## Chapter 01. 문자열
### 백준 2744 대소문자 변환
- https://www.acmicpc.net/problem/2744
- 처음에 입력된 문자열을 char[] 배열로 변환했는데 굳이 변환할 필요가 없었다.
- Character.isLowerCase() / Character.isUpperCase()로 비교가 가능하다. 예전에 Character 클래스에 대해서 공부했는데 메서드를 모두 살펴보지 않아서 불필요한 로직을 구현하였다.

### 백준 1919 애너그램 만들기
- https://www.acmicpc.net/problem/1919
- 최초 아이디어는 두 문자열을 비교해서 같은 문자가 있는지 없는지 비교하는 것이었는데 이 아이디어는 두 문자열의 길이가 같을 때만 유효한 아이디어였다.
- 두 문자열의 길이가 다를 수 있으므로 각 문자열의 알파벳 갯수를 세서 차이만큼 result에 더해주면 되었는데 이 아이디어를 떠올리지 못했다.

### 백준 1543 문서검색
- https://www.acmicpc.net/problem/1543
- `String.equals()`로 비교할 생각만 하고 `indexOf`로 문자열의 위치를 검색하는 아이디어를 떠올리지 못했다.
- `replace()` 함수로 문자열을 지우고 남은 문자열의 길이로 답을 구할 수도 있다.

### 백준 1157 단어 공부
- https://www.acmicpc.net/problem/1157
- 반복문을 돌 때 char를 직접 지정해서 돌면 많이 사용된 알파벳 저장시 명시적 type casting을 생략할 수 있다.
```java
for (char alp = 'A'; alp <= 'Z'; alp++) { }
```

## Chapter 03. 배열
### 백준 1236 성 지키기
- https://www.acmicpc.net/problem/1236
- 각 행과 열에 필요한 경비원 수를 구하고 그 중 큰값을 출력해 주면 되었는데 이 아이디어를 떠올리지 못했다.
### 백준 10431 줄세우기
- https://www.acmicpc.net/problem/10431
- 삽입 정렬의 개념을 적용하면 풀 수 있는 문제였는데 삽입 정렬의 아이디어를 떠올리지 못했다. 삽입 정렬 알고리즘에 대해서 다시 복습하자.

### 백준 10989 수 정렬하기 3
- https://www.acmicpc.net/problem/10989
- 문자열 index를 사용해서 문자의 갯수를 셌던 아이디어를 수열에도 똑같이 적용할 수 있다. 일반적인 정렬 알고리즘의 최악의 시간복잡도는 O(N^2)이므로 입력되는 수의 개수가 일천만이 넘아간다면 일반적일 정렬 방법으로는 시간 초과가 날 가능성이 높다.

### 백준 3273 두 수의 합
- https://www.acmicpc.net/problem/3273
- 시간 제한이 1초고 N의 크기가 백만이라 배열을 정렬하면 무조건 시간 초과가 난다. 백준 10989의 문제처럼 백열의 index를 활용해서 풀 수 있다. `pairValue = X - num[i]`라고 할 때 `exist[pairValue]` 배열에 존재한다면 입력받은 모든 값들을 순회하지 않아도 답을 구할 수 있다. 

## Part 5. 단기완성 알고리리즘
## 완전 탐색(Brute Force)
### 백준 15649 N과 M(1) ~ 백준 15652N과 M(4)
- https://www.acmicpc.net/problem/15649
- https://www.acmicpc.net/problem/15650
- https://www.acmicpc.net/problem/15651
- https://www.acmicpc.net/problem/15652
- 완전 탐색 알고리즘을 사용해야 풀 수 있는 문제 유형이었다. 재귀 함수 호출 포인트를 잡는 연습을 많이 해야겠다.
- 완전 탐색 알고리즘의 시간 복잡도와 공간 복잡도 정리 

  | 중복 | 순서 | 시간 복잡도                                                | 공간 복잡도 |
  | --- | --- |-------------------------------------------------------| --- |
  | YES | YES | $\large O(N^M)$                                       | $O(M)$ |
  | NO | YES | $\large O(^N_MP=O \left( \frac{N!}{(N-M)!} \right)$   | $O(M)$ |
  | YES | NO | $\large O(N^M)$ 보단 작음                                 | $O(M)$ |
  | NO | NO | $\large O(^N_MP=O \left( \frac{N!}{M!(N-M)!} \right)$ | $O(M)$ |

### 백준 14888 연산자 끼워넣기
- https://www.acmicpc.net/problem/14888
- 숫자의 순서가 바뀌면 안되고, 연산자의 순서는 바뀌면서 연산 결과 최대 값과 최소 값을 찾아야 하는데 연산자를 어떻게 섞어야 할지 아이디어를 떠올리지 못해서 결국 강의를 보고 말았다. 알고리즘이 단시일내에 해결되는 게 아닌데 마음만 너무 앞서 갔던 것 같다. 기본으로 돌아가서 내가 어떤 부분을 모르고 어떤 부분에 강정이 있는지 차분하게 점검하는 시간을 가져야 겠다.     

