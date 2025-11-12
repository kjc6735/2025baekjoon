package b2872;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int N, arr[] = new int[300_000];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int idx = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      if (arr[i] == N)
        idx = i;
    }

    int cnt = 1;

    int tmp = N - 1;
    idx -= 1;

    for (int i = idx; i >= 0; i--) {
      if (arr[i] == tmp) {
        cnt++;
        tmp--;
      }
    }

    System.out.println(N - cnt);
  }
}
