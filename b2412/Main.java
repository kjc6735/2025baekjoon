package b2412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  static int n, T;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    Set<String> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { 0, 0, 0 });

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];
      int cnt = poll[2];

      if (y >= T) {
        System.out.println(cnt);
        return;
      }

      for (int i = -2; i <= 2; i++) {
        if (x + i < 0)
          continue;
        for (int k = -2; k <= 2; k++) {
          if (y + k < 0)
            continue;
          int nextX = x + i;
          int nextY = y + k;

          String key = nextX + " " + nextY;

          if (!set.contains(key))
            continue;

          set.remove(key);
          queue.add(new int[] { nextX, nextY, cnt + 1 });

        }
      }
    }

    System.out.println(-1);

  }

  static boolean inRange(int x, int y) {
    return x >= 0 && y >= 0;
  }

}
