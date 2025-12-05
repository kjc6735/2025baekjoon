package b1931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      pq.add(new int[] { a, b });
    }

    int l = 0;
    int cnt = 0;
    while (!pq.isEmpty()) {
      int curr[] = pq.poll();

      if (l > curr[0])
        continue;

      l = curr[1];
      cnt++;
    }
    System.out.println(cnt);

  }
}
