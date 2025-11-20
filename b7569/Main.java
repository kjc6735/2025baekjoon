package b7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int arr[][][] = new int[100][100][100];
  static int N, M, H;
  static int dir[][] = {
      { 1, 0, 0 },
      { -1, 0, 0 },
      { 0, 1, 0 },
      { 0, -1, 0 },
      { 0, 0, 1 },
      { 0, 0, -1 }
  };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    int rCnt = 0;

    Queue<int[]> queue = new LinkedList<>();
    for (int j = 0; j < H; j++) {
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          int tmp = Integer.parseInt(st.nextToken());

          arr[j][i][k] = tmp;

          if (tmp == 1) {
            queue.add(new int[] { j, i, k });
          } else if (tmp == 0) {
            rCnt++;
          }
        }
      }
    }
    if (rCnt == 0) {
      System.out.println(0);
      return;
    }

    int result = 0;
    while (!queue.isEmpty()) {
      int cnt = 0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] position = queue.poll();

        for (int d = 0; d < dir.length; d++) {
          int h = position[0] + dir[d][0];
          int n = position[1] + dir[d][1];
          int m = position[2] + dir[d][2];

          if (!inRange(h, n, m))
            continue;
          if (arr[h][n][m] == -1)
            continue;
          if (arr[h][n][m] == 1)
            continue;
          arr[h][n][m] = 1;
          queue.add(new int[] { h, n, m });
          rCnt--;
          cnt++;
        }
      }
      if (cnt != 0)
        result++;
    }
    System.out.println(rCnt == 0 ? result : -1);
  }

  static boolean inRange(int h, int n, int m) {
    return h >= 0 && n >= 0 && m >= 0 && h < H && n < N && m < M;
  }
}
