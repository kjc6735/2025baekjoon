package b15989;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int MAX = 10001;
    long[][] dp = new long[MAX][4];

    dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = 1;

    for (int i = 1; i < MAX; i++) {
      dp[i][1] = dp[i - 1][1];

      if (i >= 2) {
        dp[i][2] = dp[i][1] + dp[i - 2][2];
      } else {
        dp[i][2] = dp[i][1];
      }

      if (i >= 3) {
        dp[i][3] = dp[i][2] + dp[i - 3][3];
      } else {
        dp[i][3] = dp[i][2];
      }
    }

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(dp[n][3]).append('\n');
    }

    System.out.print(sb);

  }
}
