package b13549;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Queue<int[]> queue = new LinkedList<>();
    int arr[] = new int[100_001];
    Arrays.fill(arr, Integer.MAX_VALUE);
    queue.add(new int[] { N, 1 });
    arr[N] = 1;

    while (!queue.isEmpty()) {
      int curr[] = queue.poll();

      int prev = curr[0] - 1;
      int next = curr[0] + 1;
      int mul = curr[0] * 2;
      int cnt = curr[1] + 1;

      if (prev >= 0 && arr[prev] > cnt) {
        queue.add(new int[] { prev, cnt });
        arr[prev] = cnt;
      }
      if (next <= 100_000 && arr[next] > cnt) {
        queue.add(new int[] { next, cnt });
        arr[next] = cnt;
      }
      if (mul <= 100_000 && arr[mul] > curr[1]) {
        queue.add(new int[] { mul, curr[1] });
        arr[mul] = curr[1];
      }
    }
    System.out.println(arr[K] - 1);
  }

}
