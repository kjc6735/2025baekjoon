package b1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int arr[] = new int[1001];
  static ArrayList<Integer>[] E = new ArrayList[1001];
  static int result = 0;
  static int dp[] = new int[1001];
  static int indegree[] = new int[1001];

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int TEST_CASE_CNT = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < TEST_CASE_CNT; tc++) {

      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      Arrays.fill(arr, 0);
      Arrays.fill(dp, 0);
      for (int i = 0; i <= N; i++)
        E[i] = new ArrayList<>();
      int K = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= N; i++) {
        int tmp = Integer.parseInt(st.nextToken());
        arr[i] = tmp;
      }

      for (int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        E[a].add(b);
        indegree[b]++;
      }

      int W = Integer.parseInt(br.readLine());
      dp[W] = arr[W];
      Queue<Integer> queue = new LinkedList<>();

      for (int i = 1; i <= N; i++) {
        if (indegree[i] == 0) {
          queue.add(i);
          dp[i] = arr[i];
        }
      }

      while (!queue.isEmpty()) {
        int curr = queue.poll();

        for (int next : E[curr]) {
          if (next > 0) {
            dp[next] = Math.max(dp[next], dp[curr] + arr[next]);
            if (--indegree[next] == 0) {
              queue.add(next);
            }
          }
        }

      }

      sb.append(dp[W]).append('\n');
    }
    System.out.print(sb.toString());
  }

}
