package b7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int arr[][] = new int[1000][1000];
  static boolean visited[][] = new boolean[1000][1000];
  static int N, M;
  static int dir[][] = {
      { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
  };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    Queue<int[]> queue = new LinkedList<>();
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int k = 0; k < M; k++) {
        int tmp = Integer.parseInt(st.nextToken());
        arr[i][k] = tmp;

        if (tmp == 1) {
          queue.add(new int[] { i, k });
          visited[i][k] = true;
        } else if (tmp == 0) {
          cnt += 1;
        }
      }
    }
    int result = 0;
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      int changeCnt = 0;
      for (int i = 0; i < queueSize; i++) {
        int curr[] = queue.poll();

        for (int d[] : dir) {
          int x = curr[0] + d[0];
          int y = curr[1] + d[1];

          if (!inRagne(x, y))
            continue;
          if (visited[x][y])
            continue;
          if (arr[x][y] == -1)
            continue;

          queue.add(new int[] { x, y });
          cnt--;
          visited[x][y] = true;
          changeCnt++;
        }
      }

      if (changeCnt != 0) {
        result++;
      }

    }
    System.out.println(cnt == 0 ? result : -1);
  }

  static boolean inRagne(int x, int y) {
    return x >= 0 && y >= 0 && x < N && y < M;
  }
}
