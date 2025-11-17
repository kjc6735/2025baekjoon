package b1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int sum = 0;
    int result = -10000;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      result = Math.max(result, tmp);

      if (tmp + sum >= 0) {
        sum += tmp;
        result = Math.max(sum, result);
      } else {
        sum = 0;

      }
    }

    System.out.println(result);
  }

}
