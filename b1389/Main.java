package b1389;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int arr[][] = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++)
      Arrays.fill(arr[i], 1_000_000);
    for (int i = 0; i <= N; i++)
      arr[i][i] = 0;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    for (int c = 1; c <= N; c++) {
      for (int a = 1; a <= N; a++) {
        for (int b = 1; b <= N; b++) {
          arr[a][b] = Math.min(arr[a][b], arr[a][c] + arr[c][b]);
        }
      }
    }

    int result = Integer.MAX_VALUE;
    int index = 1;
    for (int a = 1; a <= N; a++) {
      int sum = 0;
      for (int b = 1; b <= N; b++) {
        if (a == b)
          continue;
        sum += arr[a][b];
      }

      if (sum < result) {
        result = sum;
        index = a;
      }
    }
    System.out.println(index);
  }
}
