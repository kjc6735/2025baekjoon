package b12904;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S = br.readLine();
    String T = br.readLine();

    StringBuilder sb = new StringBuilder();

    sb.append(T);

    while (sb.length() > S.length()) {

      if (sb.charAt(sb.length() - 1) == 'A') {
        sb.deleteCharAt(sb.length() - 1);
        continue;
      }

      // b 제거
      sb.deleteCharAt(sb.length() - 1);

      // 반대로 돌리기
      sb.reverse();

    }

    if (sb.toString().equals(S)) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }

  }
}
