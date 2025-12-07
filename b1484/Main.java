package b1484;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long G = Long.parseLong(br.readLine());

    long a = 1;
    long b = 1;

    StringBuilder sb = new StringBuilder();

    while (a <= 50_000) {
      long aa = a * a;
      long bb = b * b;
      long result = aa - bb;
      if (G > result) {
        a++;
      } else if (G < result) {
        b++;
      } else {
        sb.append(a).append("\n");
        a++;
      }
    }
    String result = sb.toString();
    if (result.length() == 0) {
      System.out.println(-1);
    } else {
      System.out.print(result);
    }
  }
}
