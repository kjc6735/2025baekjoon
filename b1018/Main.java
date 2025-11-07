package b1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    long map[] = new long[50];

    long a = 0b10101010;
    long b = 0b01010101;

    for (int i = 0; i < H; i++) {
      String str = br.readLine();
      for (int k = 0; k < W; k++) {
        if (str.charAt(k) == 'B') {
          map[i] += (1L << k);
        }
      }
    }
    long result = Long.MAX_VALUE;
    for (int i = 0; i <= H - 8; i++) {
      for (int k = 0; k <= W - 8; k++) {
        long sumA = 0;
        long sumB = 0;
        for (int j = 0; j < 8; j++) {
          long targetLine = (map[i + j] >> k) & 0b11111111L;
          sumA += Long.bitCount((j % 2 == 0 ? targetLine ^ a : targetLine ^ b));
          sumB += Long.bitCount((j % 2 == 0 ? targetLine ^ b : targetLine ^ a));
        }

        long sumMin = Long.min(sumA, sumB);
        result = Long.min(result, sumMin);
      }
    }
    System.out.println(result);
  }
}
