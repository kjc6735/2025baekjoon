package b16724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static HashMap<Character, Integer> hashmap = new HashMap<>();
  static HashMap<Integer, Character> rHashmap = new HashMap<>();

  static int dir[][] = {
      { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }
  };
  static String arr[] = new String[1000];
  static boolean visited[][] = new boolean[1000][1000];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    hashmap.put('U', 0);
    hashmap.put('L', 1);
    hashmap.put('D', 2);
    hashmap.put('R', 3);

    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }

    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int k = 0; k < M; k++) {
        if (visited[i][k])
          continue;
        // 한번의 존이 필요한 상황
        result++;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { i, k });
        visited[i][k] = true;

        // 자신한테 들어오는 것이랑 자신이 가야할 방향을 큐에 넣기

        // 1. 내가 가야 할 방향

        while (!queue.isEmpty()) {
          int curr[] = queue.poll();
          int next = hashmap.get(arr[curr[0]].charAt(curr[1]));

          int nextX = curr[0] + dir[next][0];
          int nextY = curr[1] + dir[next][1];

          if (!visited[nextX][nextY]) {
            visited[nextX][nextY] = true;

            queue.add(new int[] { nextX, nextY });
          }

          // 나에게 들어오는 방향 찾기 ?

          for (int d = 0; d < 4; d++) {
            int tmpX = curr[0] + dir[d][0];
            int tmpY = curr[1] + dir[d][1];
            if (!inRange(tmpX, tmpY))
              continue;
            if (visited[tmpX][tmpY])
              continue;

            // 만약에 현재 (d + 2)%4 랑 다음 위치 값이 같으면 되는거임
            int currPosDir = hashmap.get(arr[tmpX].charAt(tmpY));
            int corrDir = (int) (d + 2) % 4;
            if (currPosDir != corrDir)
              continue;

            visited[tmpX][tmpY] = true;

            queue.add(new int[] { tmpX, tmpY });
            System.out.println(tmpX + " " + tmpY);
          }
        }
      }
    }
    System.out.println(result);

  }

  static boolean inRange(int x, int y) {
    return x >= 0 && y >= 0 && x < N && y < M;
  }
}
