package b10942;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int arr[] = new int[N];
    int dp[][] = new int[N][N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      dp[i][i] = 1;
    }

    int M = Integer.parseInt(br.readLine());

    fn(arr, dp);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(dp[a - 1][b - 1]).append("\n");
    }
    System.out.print(sb.toString());
  }

  public static void fn(int arr[], int dp[][]) {
    int N = arr.length;

    for (int i = 0; i < arr.length; i++)
      dp[i][i] = 1;
    for (int i = 0; i < arr.length - 1; i++)
      dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 0;

    for (int cnt = 0; cnt < N - 2; cnt++) {
      for (int i = 0; i < N - 2 - cnt; i++) {
        int j = i + 2 + cnt;
        if (arr[i] == arr[j] && dp[i + 1][j - 1] == 1) {
          dp[i][j] = 1;
        }
      }
    }
  }

  
}
