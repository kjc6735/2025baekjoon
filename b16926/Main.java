package b16926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    int arr[][] = new int[N][M];
    int result[][] = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int layer = 0; layer < Math.min(N, M) / 2; layer++) {
      int startX = layer;
      int startY = layer;
      int endX = N - 1 - layer;
      int endY = M - 1 - layer;

      int perimeter = 2 * (endX - startX + endY - startY);
      int actualR = R % perimeter;

      int currX = startX;
      int currY = startY;

      for (int i = 0; i < perimeter; i++) {
        int prevX = currX;
        int prevY = currY;

        for (int r = 0; r < actualR; r++) {
          int[] prevPos = getPrev(prevX, prevY, startX, startY, endX, endY);
          prevX = prevPos[0];
          prevY = prevPos[1];
        }

        result[currX][currY] = arr[prevX][prevY];

        int[] next = getNext(currX, currY, startX, startY, endX, endY);
        currX = next[0];
        currY = next[1];
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  static int[] getNext(int currX, int currY, int startX, int startY, int endX, int endY) {
    if (currX == startX && currY > startY) {
      return new int[] { currX, currY - 1 };
    } else if (currY == startY && currX < endX) {
      return new int[] { currX + 1, currY };
    } else if (currX == endX && currY < endY) {
      return new int[] { currX, currY + 1 };
    } else {
      return new int[] { currX - 1, currY };
    }
  }

  static int[] getPrev(int currX, int currY, int startX, int startY, int endX, int endY) {
    if (currX == startX && currY < endY) {
      return new int[] { currX, currY + 1 };
    } else if (currY == endY && currX < endX) {
      return new int[] { currX + 1, currY };
    } else if (currX == endX && currY > startY) {
      return new int[] { currX, currY - 1 };
    } else {
      return new int[] { currX - 1, currY };
    }
  }
}