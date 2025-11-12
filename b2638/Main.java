package b2638;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int dir[][] = {
      { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
  };
  static int N, M, arr[][] = new int[100][100];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    HashSet<String> cheese = new HashSet<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int k = 0; k < M; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
        if (arr[i][k] == 1)
          cheese.add(i + " " + k);
      }
    }

    // 초기화
    // 10 부터 시작
    int airNum = 10;
    for (int i = 0; i < N; i++) {
      for (int k = 0; k < M; k++) {
        if (arr[i][k] != 0)
          continue;

        arr[i][k] = airNum;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { i, k });

        while (!queue.isEmpty()) {
          int[] poll = queue.poll();

          int x = poll[0];
          int y = poll[1];

          for (int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];

            if (!inRange(dx, dy) || arr[dx][dy] == 1 || arr[dx][dy] == airNum)
              continue;

            arr[dx][dy] = airNum;
            queue.add(new int[] { dx, dy });
          }
        }
        airNum++;
      }
    }

    // 시작이 10이니까 10이 붙어있으면 사라지는거임
    int result = 0;
    while (cheese.size() != 0) {
      Queue<int[]> rm = new LinkedList<>();

      for (String s : cheese) {
        st = new StringTokenizer(s);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
          int dx = x + dir[d][0];
          int dy = y + dir[d][1];
          if (!inRange(dx, dy) || arr[dx][dy] == 1)
            continue;

          if (arr[dx][dy] == 10) {
            cnt++;
          }
        }
        if (cnt >= 2) {
          rm.add(new int[] { x, y });
        }
      }

      if (rm.size() == 0) {
        continue;
      }

      result++;
      // 치즈 삭제하기
      for (int[] r : rm) {
        String s = r[0] + " " + r[1];
        cheese.remove(s);

        // 삭제된 위치에서 옆에 구멍이 생기면 안쪽 바꿔주기
        int x = r[0];
        int y = r[1];

        arr[x][y] = 10;
        for (int d = 0; d < 4; d++) {
          int dx = x + dir[d][0];
          int dy = y + dir[d][1];
          if (!inRange(dx, dy) || arr[dx][dy] == 1 || arr[dx][dy] == 10)
            continue;
          Queue<int[]> q = new LinkedList<>();
          q.add(new int[] { dx, dy });
          arr[dx][dy] = 10;
          while (!q.isEmpty()) {
            int tmp[] = q.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];

            for (int dd = 0; dd < 4; dd++) {
              int tmpdx = tmpX + dir[dd][0];
              int tmpdy = tmpY + dir[dd][1];
              if (!inRange(tmpdx, tmpdy) || arr[tmpdx][tmpdy] == 1 || arr[tmpdx][tmpdy] == 10)
                continue;

              arr[tmpdx][tmpdy] = 10;
              q.add(new int[] { tmpdx, tmpdy });
            }
          }
        }
      }
    }
    System.out.println(result);
  }

  static boolean inRange(int x, int y) {
    return x >= 0 && y >= 0 && x < N && y < M;

  }
  // 1 => 치즈
  // 다른 숫자들 => 공기

  static Queue<int[]> findCheese() {
    return new LinkedList<>();
  }
}
