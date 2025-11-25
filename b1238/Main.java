package b1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static boolean[] visited = new boolean[1001];
  static int dist[] = new int[1001];

  static int N, M, X;
  static int arr[][] = new int[1001][1001];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++)
      Arrays.fill(arr[i], 10_000_000);
    for (int i = 0; i <= N; i++)
      arr[i][i] = 0;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      arr[a][b] = t;
    }

    int result = 0;
    for (int i = 1; i <= N; i++) {
      if (i == X)
        continue;

      int a = fn(i, X);
      int b = fn(X, i);
      result = Math.max(result, a + b);
    }

    System.out.println(result);

  }

  static int fn(int start, int dst) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(visited, false);

    dist[start] = 0;
    pq.add(new int[] { start, 0 });
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int u = curr[0];
      if (visited[u])
        continue;
      if (u == dst)
        return curr[1];

      visited[u] = true;

      for (int v = 1; v <= N; v++) {
        if (dist[v] > dist[u] + arr[u][v]) {
          dist[v] = dist[u] + arr[u][v];
          pq.add(new int[] { dist[v], v });
        }
      }
    }

    return Integer.MAX_VALUE;
  }

}
