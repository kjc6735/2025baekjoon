package b15591;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static class Edge {
    int to;
    int usado;

    Edge(int to, int usado) {
      this.to = to;
      this.usado = usado;
    }
  }

  static int N, Q;
  static ArrayList<Edge>[] graph = new ArrayList[5001];
  static long usado[] = new long[5001];
  static boolean visited[] = new boolean[5001];
  static {
    Arrays.fill(usado, Long.MAX_VALUE);
    for (int i = 0; i < 5001; i++) {
      graph[i] = new ArrayList<>();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());

      graph[a].add(new Edge(b, r));
      graph[b].add(new Edge(a, r));
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      int count = dfs(v, k, Long.MAX_VALUE);
      Arrays.fill(visited, false);
      sb.append(count).append('\n');
    }

    System.out.print(sb.toString());
  }

  static int dfs(int node, int k, long minUsado) {
    visited[node] = true;
    int count = 0;

    for (Edge edge : graph[node]) {
      if (!visited[edge.to]) {
        long newMinUsado = Math.min(minUsado, edge.usado);

        if (newMinUsado >= k) {
          count++;
          count += dfs(edge.to, k, newMinUsado);
        }
      }
    }

    return count;
  }
}
