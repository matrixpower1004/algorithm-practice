package fastcampus.part3.dfs_bfs.bj2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 2573 빙산: https://www.acmicpc.net/problem/2573
 */
public class Main {
    static int N, M;
    static int[][] earth;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상하
    static int[] dc = {0, 0, -1, 1}; // 좌우
    static List<Ice> iceList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        earth = new int[N][M];
        visited = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                earth[row][col] = Integer.parseInt(st.nextToken());
                if (earth[row][col] > 0) {
                    iceList.add(new Ice(row, col, earth[row][col]));
                }
                visited[row][col] = true; // iceList에 있는 빙산들의 좌표를 방문처리
            }
        }
        // 시간이 흐를 때마다 빙산 녹이기
        for (int year = 1; !iceList.isEmpty(); year++) {
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                for (int j = 0; j < 4; j++) {
                    int nr = ice.row + dr[j];
                    int nc = ice.col + dc[j];
                    if (earth[nr][nc] == 0) {
                        ice.height--;
                    }
                }
            }

            // 녹은 빙산의 높이를 갱신한다.
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) { // 녹은 빙산의 높이가 0보다 작다면 바다로 처리.
                    earth[ice.row][ice.col] = 0;
                    // 제일 마지막 칸의 원소를 i번째 컨에 넣고 마지막 칸을 삭제한다.
                    iceList.set(i, iceList.get(iceList.size() - 1));
                    iceList.remove(iceList.size() - 1);
                    i--; // 빙산의 개수가 하나 줄어 들었기 때문에 i의 수를 하나 줄여준다.
                } else {
                    // 빙산이 남아있다면 빙산이 분리가 되었는지 탐색한다.
                    visited[ice.row][ice.col] = false;
                }
            }
            // iceList 첫번째 빙산이 몇개와 연결 되어 있는지 카운트.
            // 모든 빙산의 개수와, 첫번째 빙산과 연결된 빙산의 개수가 다르면 빙산이 분리되었다는 뜻.
            if (iceList.size() > 0 && dfs(iceList.get(0).row, iceList.get(0).col) != iceList.size()) {
                System.out.println(year);
                return;
            }
        }
        // 모든 빙산이 쪼개지지 않고 한번에 녹은 상황
        System.out.println(0);
    }

    static int dfs(int row, int col) {
        visited[row][col] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) { // 상하좌우 4방향 탐색
            int nr = row + dr[i];
            int nc = col + dc[i];
            // 다음에 방문할 좌표에 방문 이력이 있는지 체크한다.
            if (visited[nr][nc]) {
                continue;
            }
            count += dfs(nr, nc);
        }
        return count;
    }
}

class Ice {
    int row;
    int col;
    int height;

    public Ice(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
