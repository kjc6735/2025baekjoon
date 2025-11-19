package b14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static class Schedule {
    int time;
    int value;

    public Schedule(int time, int value) {
      this.time = time;
      this.value = value;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int dp[] = new int[N + 1];
    ArrayList<Schedule>[] schedules = new ArrayList[N + 1];

    for (int i = 0; i <= N; i++) {
      schedules[i] = new ArrayList<>();
    }

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int t = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      if (i + t - 1 > N)
        continue;
      schedules[i + t - 1].add(new Schedule(t, v));
    }

    for (int i = 1; i <= N; i++) {
      int max = dp[i - 1];
      for (Schedule sc : schedules[i]) {
        int lastIndex = i - sc.time;
        max = Math.max(dp[lastIndex] + sc.value, max);
      }

      dp[i] += max;
    }

    System.out.println(dp[N]);
  }

}