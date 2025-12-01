package b11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int arr[] = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    int dp[] = new int[N];
    int max = 0;
    for (int i = 0; i < N; i++) {
      dp[i] = 1;

      for (int k = 0; k < i; k++) {

        if (arr[k] < arr[i] && dp[k] + 1 > dp[i])
          dp[i] = dp[k] + 1;
      }
      max = Math.max(max, dp[i]);

    }

    System.out.println(max);
  }
}
