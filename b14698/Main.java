package b14698;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int tc = Integer.parseInt(br.readLine());
    long MOD = 1_000_000_007;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tc; i++) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      PriorityQueue<Long> pq = new PriorityQueue<>();

      for (int k = 0; k < N; k++) {
        long tmp = Long.parseLong(st.nextToken());
        pq.add(tmp);
      }
      long result = 1;
      while (pq.size() >= 2) {
        long a = pq.poll();
        long b = pq.poll();
        long mul = a * b;
        result = (result * (mul % MOD)) % MOD;
        pq.add(mul);
      }
      sb.append(result).append("\n");
    }
    System.out.print(sb.toString());
  }
}
