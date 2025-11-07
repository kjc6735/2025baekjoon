package b21318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int arr[] = new int[N + 1];
    int check[] = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (i == 1)
        continue;
      check[i] = arr[i - 1] > arr[i] ? check[i - 1] + 1 : check[i - 1];
    }
    StringBuilder sb = new StringBuilder();
    int Q = Integer.parseInt(br.readLine());

    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      sb.append(check[y] - check[x]).append("\n");
    }

    System.out.print(sb);

  }
}
