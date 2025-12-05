package b1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, arr[][] = new int[500][500];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int k = 0; k <= i; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    fn(N - 2);
    System.out.println(arr[0][0]);
  }
  // 0 -> 0 1
  // 1 -> 1 2
  // 2 -> 2 3

  static void fn(int x) {
    if (x < 0)
      return;

    for (int i = 0; i < x + 1; i++) {
      arr[x][i] += Math.max(arr[x + 1][i], arr[x + 1][i + 1]);
    }

    fn(x - 1);
  }
}
