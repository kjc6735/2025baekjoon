package b1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int dir[][] = {
      { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
  };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int TC = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    int arr[][] = new int[50][50];
    for (int tc = 0; tc < TC; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      // init
      for (int i = 0; i < N; i++)
        Arrays.fill(arr[i], 0);

      for (int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        arr[x][y] = 1;
      }
      int cnt = 0;

      for (int i = 0; i < N; i++) {
        for (int k = 0; k < M; k++) {
          if (arr[i][k] == 0)
            continue;

          arr[i][k] = 0;
          cnt += 1;

          Queue<int[]> queue = new LinkedList<>();

          queue.add(new int[] { i, k });

          while (!queue.isEmpty()) {
            int curr[] = queue.poll();

            for (int d = 0; d < 4; d++) {
              int x = curr[0] + dir[d][0];
              int y = curr[1] + dir[d][1];
              if (!inRange(N, M, x, y))
                continue;
              if (arr[x][y] == 0)
                continue;

              arr[x][y] = 0;
              queue.add(new int[] { x, y });
            }
          }
        }
      }

      sb.append(cnt).append("\n");
    }
    System.out.print(sb.toString());

  }

  static boolean inRange(int a, int b, int x, int y) {
    return x >= 0 && y >= 0 && x < a && y < b;
  }
}
