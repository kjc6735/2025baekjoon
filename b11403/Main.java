package b11403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int arr[][] = new int[N][N];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int k = 0; k < N; k++) {
        int tmp = Integer.parseInt(st.nextToken());
        arr[i][k] = tmp;
      }
    }

    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {

          if (arr[i][k] == 1 && arr[k][j] == 1) {
            arr[i][j] = 1;
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      for (int k = 0; k < N; k++) {
        sb.append(arr[i][k] != 0 ? 1 : 0).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb.toString());

  }
}
