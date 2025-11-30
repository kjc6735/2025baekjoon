package b15684;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int result = Integer.MAX_VALUE;
  static int N, M, H;
  static boolean[][] ladder;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 세로선
    M = Integer.parseInt(st.nextToken()); // 가로선
    H = Integer.parseInt(st.nextToken()); // 위치 H

    ladder = new boolean[H + 1][N];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      ladder[a][b] = true;
    }

    for (int maxLine = 0; maxLine <= 3; maxLine++) {
      fn(1, 1, maxLine, 0);
      if (result != Integer.MAX_VALUE) {
        break;
      }
    }

    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }

  static void fn(int x, int y, int maxLineCnt, int currLineCnt) {
    if (result != Integer.MAX_VALUE) {
      return;
    }

    if (currLineCnt == maxLineCnt) {
      if (go()) {
        result = currLineCnt;
      }
      return;
    }

    for (int i = x; i <= H; i++) {
      int start = (i == x) ? y : 1;
      for (int j = start; j < N; j++) {
        if (validate(i, j)) {
          ladder[i][j] = true;
          fn(i, j + 2, maxLineCnt, currLineCnt + 1);
          ladder[i][j] = false;
        }
      }
    }
  }

  static boolean validate(int x, int y) {
    if (ladder[x][y])
      return false;
    if (y > 1 && ladder[x][y - 1])
      return false;
    if (y < N - 1 && ladder[x][y + 1])
      return false;
    return true;
  }

  static boolean go() {
    for (int start = 1; start <= N; start++) {
      if (simulate(start) != start) {
        return false;
      }
    }
    return true;
  }

  static int simulate(int start) {
    int pos = start;

    for (int h = 1; h <= H; h++) {
      if (pos > 1 && ladder[h][pos - 1]) {
        pos--;
      } else if (pos < N && ladder[h][pos]) {
        pos++;
      }
    }

    return pos;
  }
}