package b1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int dp[][] = new int[N][3];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      dp[i][0] = a;
      dp[i][1] = b;
      dp[i][2] = c;
    }

    for (int i = 1; i < N; i++) {
      dp[i][0] = dp[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
      dp[i][1] = dp[i][1] + Math.min(dp[i - 1][2], dp[i - 1][0]);
      dp[i][2] = dp[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);

    }
    System.out.println(Math.min(dp[N - 1][2], Math.min(dp[N - 1][0], dp[N - 1][1])));
  }

}
