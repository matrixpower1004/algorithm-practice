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
### 백준 10431 줄세우기 (Silver V)
- https://www.acmicpc.net/problem/10431
- 삽입 정렬의 개념을 적용하면 풀 수 있는 문제였는데 삽입 정렬의 아이디어를 떠올리지 못했다. 삽입 정렬 알고리즘에 대해서 다시 복습하자.

### 백준 10989 수 정렬하기 3 ()
- https://www.acmicpc.net/problem/10989
- 문자열 index를 사용해서 문자의 갯수를 셌던 아이디어를 수열에도 똑같이 적용할 수 있다. 일반적인 정렬 알고리즘의 최악의 시간복잡도는 $O(N^2)$이므로 입력되는 수의 개수가 일천만이 넘아간다면 일반적일 정렬 방법으로는 시간 초과가 날 가능성이 높다.

### 백준 3273 두 수의 합
- https://www.acmicpc.net/problem/3273
- 시간 제한이 1초고 N의 크기가 백만이라 배열을 정렬하면 무조건 시간 초과가 난다. 백준 10989의 문제처럼 백열의 index를 활용해서 풀 수 있다. `pairValue = X - num[i]`라고 할 때 `exist[pairValue]` 배열에 존재한다면 입력받은 모든 값들을 순회하지 않아도 답을 구할 수 있다. 

## Chapter 04. 완전탐색- 시뮬레이션
### 백준 2309 일곱 난쟁이
- https://www.acmicpc.net/problem/2309
- 모두 더해서 100이 되는 수를 찾을 생각만 하고, 두 개의 수를 빼서 100이 되는 경우의 수를 찾는다는 아이디어를 떠올리지 못했다.
- 찾은 두 수를 -1이나 0으로 변경하고 sort를 하면 합해서 100이 되지 않는 수는 무조건 0번과 1번 index에 위치할 것이므로 불필요한 if 로직을 생략할 수 있다.

### 백준 10448 유레카 이론
- https://www.acmicpc.net/problem/10448
- 문제를 잘못 이해해서 삼각함수로 표현될 수 있는 숫자로 판단을 했는데, 문제가 요구하는 사항은 삼각함수 3개의 합으로 표현될 수 있는 수인지 나타내는 것이었다.
- 시간제한 때문에 3중 for문을 쓸 생각을 하지 않았는데, 문제를 잘못 이해해서 N의 범위를 넓게 잡았기 때문이었다. 문제를 잘 읽고 생각을 깊게 하는 연습을 계속하자.

### 백준 11005 진법 변환 2
- https://www.acmicpc.net/problem/11005
- 진법변환 과정에서 나머지 연산결과를 저장하기 위해 stack 자료구조를 사용했는데 StringBuilder에 저장하고 `sb.reverse()` 로 역순으로 출력하는 방법도 있었다.

### 백준 11068 회문인 수
- https://www.acmicpc.net/problem/11068
- 진법 변환시 전체 자리수가 몇 개인지 구할 때 N % B(진법) 연산을 반복하면서 자리수를 카운트 해주면 되었다.
- 회문인 검사할 때 center, left, right 인덱스를 모두 변수를 선언했는데 진법 변환된 수가 담긴 배열의 길이 / 2까지 for를 돌리고 이걸 left 인덱스로 쓰면서, 대칭인 right 인덱스는 배열의 길이 - for 변수 -1을 해주면 되었다.

### 백준 3085 사탕 게임 
- https://www.acmicpc.net/problem/3085
- 문제의 요구 사항을 이해하는데 시간이 많이 걸렸다. 구현 자체는 모든 경우를 다 탐색하면 되는데, 문제 이해를 잘못해서 잘못된 구현이 나오고 수정하는 일이 자주 발생하고 있다. 문제를 이해하는 훈련에 시간을 조금 더 투자할 필요가 있다. 

### 백준 10250 ACM 호텔
- https://www.acmicpc.net/problem/10250
- 층수와 방번호를 구할 때 경계값을 생각하지 못하고 계산식을 도출해서 계속 오류가 발생했다. 예를 들어 W가 12, H가 10이라고 가정했을 때 110번째 손님의 방 번호는 1011호가 되어야 하지만 층수를 구하기 위해 단순히 `110 % 10`을 하게 되면 몫이 0이 되어 1층에 손님이 배치되는 오류가 생긴다. 이런 오류를 방지라혀면 `(N - 1)`을 먼저 해주고 그 결과에 `%H` 모듈러 연산을 한 다음 `+1`을 해주어야 한다.
- N번째 손님의 층수: H로 나눈 나머지가 0이 나오는 케이스가 있으므로 [0, H-1] -> [1, H]가 나오도록 변환해야 한다.
- `int floor = (N - 1) % H + 1;`
- N번째 손님의 호수 : H로 나눈 몫. 테스트 케이스가 `1 ~ 10` 이라고 했을 때 `1 ~ 9` 까지는 몫이 0이 나오고 10만 몫이 1이 나온다. 층수를 구할 때와 마찬가지로 `N-1`을 먼저 해준 값을 H로 나누고 그 결과에 1을 더해준다.
- 결론적으로 `1 ~ H => 1 / H+1 ~ 2H => 2` 로 변환하는 작업을 해줘야 한다.
- `int distance = (N - 1 / H + 1;`
- 문제에 나오는 테스트 케이스를 통과했다고 만족하지 말고 다양한 테스트 케이스를 직접 만들어서 테스트 하는 습관을 만들자.

### 백준 1730 판화
- https://www.acmicpc.net/problem/1730
- 주어진 N의 크기를 벗어나는 좌표를 계산할 때 N의 크기는 1 ~ N 까지이지만, 배열의 index는 0부터 N-1 까지 계산해야 하는데, N으로 계산해서 오류가 계속 발생했다. 다음에는 조금 더 주의를 기울이자.

### 백준 2840 행운의 바퀴
- https://www.acmicpc.net/problem/2840
- 환형 구조의 배열 index를 구할 때 modular 연산을 하면 되는데 원리를 몰라서 불필요한 계산 로직으로 구현을 했다.
- 바퀴의 방향과 화살표의 방향은 반대이므로 `curIndex - S`를 해주는데 몇 바퀴나 돌았는지 모르니까 `(curIndex - S) % N` 연산을 해준다.
- 이 때 주의할 점은 Java의 modular 연산은 `(curIndex - S)`의 값이 음수면 읍수 값을 리턴할 수 있기 때문에 음수 방지를 위해서 N을 더해서 양수로 만든 후 다시 % N으로 나누어 준다.
- 환형 구조를 배열로 구현할 때 index를 구하는 공식은 `currentIndex + x % N`. 잘 기억해 두자. 

### 백준 2817 ALPS식 투표
- https://www.acmicpc.net/problem/2817
- 문제가 요구하는 것은 각 스태프별로 득표수를 `1~14`까지의 숫자로 나눈 값을 각각 배열로 저장한 후, `1~14`위에 해당하는 값을 찾아 그 값에 해당하는 스태프의 칩을 1증가 시키는 것이었다.
- 칩 분배 로직을 이해하지 못해서 구현에 애를 먹었는데, 한번만이라도 표를 손으로 그려보았다면 조금은 빨리 이해할 수 있는 문제였다. 다음에는 먼저 손으로 표를 그려보자.    

### 백준 2745 진법 변환
- https://www.acmicpc.net/problem/2745
- char type 을 Ascii Code가 아닌 숫자로 변환하려면 두 가지 방법이 있다.
```java
int a = Character.getNumericValue(x);
int a = x - '0';
```
### 백준 1233 주사위
- https://www.acmicpc.net/problem/1233
- 세 주사위의 합을 배열의 index로 사용해 놓고, 정작 index와 index에 저장된 값을 혼동해서 버그를 찾는데 불필요한 시간을 사용했다. 다음에는 슈도 코드를 꼭 작성해서 흐름을 머리속에 그려두고 코딩을 하자. 

### 백준 2331 분해합
- https://www.acmicpc.net/problem/2231
- 어떤 수 x가 있다면 `x % 10` 연산을 `x / 10` 연산의 결과가 0이 될 때까지 계속하면 각 자리수들의 합을 쉽게 구할 수 있었는데 이 아이디어를 떠올리지 못하고 각 자리수마다 0에서 9까지 반복하면서 재귀를 돌린다는 아이디어에 매몰되었다. 문제를 여러 관점에서 생각하는 힘을 기르자. 
- 어려운 문제가 아니었는데 로직의 도출 관점이 문제가 요구하는 방향과 어긋나면 쉬운 문제도 풀기 어렵다는 것을 배웠다.

### 백준 1110 더하기 사이클
- https://www.acmicpc.net/problem/1110
- while 보다는 do - while이 코드가 더 깔끔해지는 문제였다. 종료 조건이 처음에 N과 같고 계속 변화하다가 다시 N과 같아진다면 do - while을 고려해 보자. 

### 백준 4673 셀프 넘버
- https://www.acmicpc.net/problem/4673
- 인자로 넘긴 수 x와, x의 각 자리수를 더하는 함수에서 넘겨받은 x에 합산을 하지 않고 0부터 합산하는 로직 오류가 있었다. 

### 백준 1018 체스판 다시 칠하기
- https://www.acmicpc.net/problem/1018
- 실버 IV 문제인데 최초 아이디어를 떠올리고도 막상 구현을 하지 못했다. %2를 하면 row를 바꿔가면서 비교할 수 있다는 기초 지식이 있음에도 그걸 응용할 생각을 하지 못했다.

### 백준 1120 문자열
- https://www.acmicpc.net/problem/1120
- 배열의 index는 0부터 다룰지, 1부터 다룰지 확실하게 정하고 코드를 작성하자.

### 백준 1181 단어 정렬
- https://www.acmicpc.net/problem/1181
- 중복 제거를 위해서 Set을 이용해서 입력을 받고 -> Set을 List로 변환 후 정렬했는데 변환 시간이 생각보다 오래 걸렸다.
- 배열에 모두 입력을 받고 배열의 정렬을 먼저 하면 같은 문자열끼리 모여 있기 때문에 중복을 제거하는데 오히려 효과적이었다.
- HashSet 보다 LinkedHashSet에서 중복을 제거하는 시간이 조금 더 걸렸다. 참고하자.

### 백준 10814 나이순 정렬
- https://www.acmicpc.net/problem/10814
- Arrays.sort는 배열을, Collections.sort는 Collection을 정렬한다. TimSort는 stable한 특성을 갖고 있다. 

### 백준 7785 회사에 있는 사람
* https://www.acmicpc.net/problem/7785
* Comparator와 Comparable의 사용법을 잘 복습해두자.

### 백준 1302 베스트셀러
* https://www.acmicpc.net/problem/1302
* Comparator 정의 방법을 잘 기억해 두고 자주 연습하자.
```java
Comparator<Map.Entry<String, Integer>> valueThenKeyComparator = (o1, o2) -> {
	if (o2.getValue().equals(o1.getValue())) {
		return o1.getKey().compareTo(o2.getKey());
	}
	return o2.getValue().compareTo(o1.getValue());
};
```
* Map의 메서드 중 `getOrDefault()`는 아래의 로직을 깔끔하게 한줄로 줄여준다. Collection에서 지원하는 메서드가 어떤 게 있는지 조금 더 관심을 가지자.
```java
if (books.containsKey(key)) {
	int currentValue = books.get(key);
	books.put(key, currentValue + 1);
} else {
	books.put(key, 1);
}
```

### 백준 18870 좌표 압축
* https://www.acmicpc.net/problem/18870
* 처음에 Map을 이용하여 구현했지만 시간 초과를 받았다. 이유는 입력된 값을 key로, 압축된 좌표를 value로 저장했다면 `get()` 메서드로 손쉽게 압축된 좌표를 꺼내올 수 있었는데 좌표를 key로, 입력된 값을 value로 저장하여 Map의 특성을 전혀 살리지 못하는 로직이 되었기 때문이다.
* Map의 처음부터 N의 크기만큼 순회하니 결국 시간복잡도가 $O(N^2)$이 되어 시간 초과가 되었던 것이다. Java Collection에 대해서 좀 더 깊이 있는 공부가 필요하다는 것을 배웠다.

### 백준 1931 회의실 배정
* https://www.acmicpc.net/problem/1931
* int 타입의 배열 정렬이 불완전 정렬이긴 하지만 속도는 Boxed 타입에 비해서 확실히 빠르다.
  
### 백준 1431 시리얼 번호
* https://www.acmicpc.net/problem/1431
* char type을 int 값으로 변환하는 방법은 2가지. `Charcter.getIntValue(x)`, `charValue - '0'`. 자주 잊어버리는데 확실히 기억해 두자.

## Part 5. 단기완성 알고리즘
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
- 숫자의 순서가 바뀌면 안되고, 연산자의 순서는 바뀌면서 연산 결과 최대 값과 최소 값을 찾아야 하는데 연산자를 어떻게 섞어야 할지 아이디어를 떠올리지 못해서 결국 강의를 보고 말았다. 알고리즘이 단시일내에 해결되는 게 아닌데 마음만 너무 앞서 갔던 것 같다. 기본으로 돌아가서 내가 어떤 부분을 모르고 어떤 부분에 강점이 있는지 차분하게 점검하는 시간을 가져야 겠다.     

