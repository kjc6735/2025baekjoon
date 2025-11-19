package b17182;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int ans = Integer.MAX_VALUE;
  static boolean[] visited;
  static int N, K, arr[][];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new int[N][N];
    // input
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int k = 0; k < N; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    // 플로이드 워셜

    for (int i = 0; i < N; i++) {
      for (int k = 0; k < N; k++) {
        for (int t = 0; t < N; t++) {
          arr[k][t] = Math.min(arr[k][t], arr[k][i] + arr[i][t]);
        }
      }
    }

    visited = new boolean[N];
    visited[K] = true;
    perm(1, K, 0);
    System.out.println(ans);
  }

  static void perm(int cnt, int prev, int d) {
    if (cnt == N) {
      ans = Math.min(ans, d);
    }

    for (int i = 0; i < N; i++) {
      if (visited[i])
        continue;
      visited[i] = true;
      perm(cnt + 1, i, d + arr[prev][i]);
      visited[i] = false;
    }
  }
}
