# 자료구조와 알고리즘 공부(Do it! 알고리즘 코딩테스트)
## 백준 11720 숫자의 합 구하기
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
## 백준 1546 평균
- https://www.acmicpc.net/problem/1546
- 주어진 공식대로 배열을 순회하면서 max 값보다 작으면 점수를 조작했는데, 식을 간소화 하면 이런 불필요한 로직을 줄일 수 있었다.    
- `(A / M * 100 + B / M * 100 + C / M * 100) / 3 = (A + B + C) * 100 / M /3`
## 백준 11659 구간 합 구하기 4
- StringTokenizer 사용 시 불필요한 hasMoreTokens() 체크 로직은 빼자.
- 합배열 공식 : `S[i] = S[i - 1] + A[i]`
- 구간 합 공식 : `S[toIndex] - S[fromIndex - 1]`
## 백준 11660 구간 합 구하기 5
- 처음 구간합을 구할 때 행의 합만 구하고 열의 합을 구할 아이디어를 떠올리지 못했다.
- 2차원 배열 index : `int[][] arr = new int[row][column]`
- 합배열 공식 : `D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]`
- X1, Y1, X2, Y2 구간 합을 구하는 공식 : `D[X2][Y2] - D[X1-1][y2] - D[X2][Y1-1] + D[X1-1][Y1-1]`
