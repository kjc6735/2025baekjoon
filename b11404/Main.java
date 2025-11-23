package b11404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int M = Integer.parseInt(br.readLine());
    int arr[][] = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++)
      Arrays.fill(arr[i], 10_000_000);

    for (int i = 1; i <= N; i++) {
      arr[i][i] = 0;
    }
    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());

      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr[a][b] = Math.min(arr[a][b], c);
    }

    for (int i = 1; i <= N; i++) {
      for (int a = 1; a <= N; a++) {
        for (int c = 1; c <= N; c++) {
          arr[a][c] = Math.min(arr[a][c], arr[a][i] + arr[i][c]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int a = 1; a <= N; a++) {
      for (int c = 1; c <= N; c++) {
        sb.append(arr[a][c]).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb.toString());

  }
}
