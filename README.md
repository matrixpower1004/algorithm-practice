# 자료구조와 알고리즘 공부(Do it! 알고리즘 코딩테스트)
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
