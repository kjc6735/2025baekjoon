package b12933;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  static Map<Character, Integer> hashmap = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String sound = br.readLine();
    int arr[] = new int[5];
    hashmap.put('q', 0);
    hashmap.put('u', 1);
    hashmap.put('a', 2);
    hashmap.put('c', 3);
    hashmap.put('k', 4);
    int result = 0;
    for (int i = 0; i < sound.length(); i++) {
      char c = sound.charAt(i);
      int currIdx = hashmap.get(c);
      if (c != 'q') {
        int prevIdx = hashmap.get(c) - 1;

        int currCnt = arr[currIdx] + 1;
        int prevCnt = arr[prevIdx];
        // 이전것보다 커지면 -1
        if (currCnt > prevCnt) {
          System.out.println(-1);
          return;
        }
      }
      arr[currIdx] += 1;
      result = Math.max(result, arr[0]);

      if (currIdx == 4) {
        for (int a = 0; a < 5; a++) {
          arr[a] -= 1;
        }
      }
    }
    for (int i = 0; i < 5; i++) {
      if (arr[i] != 0) {
        System.out.println(-1);
        return;
      }
    }

    System.out.println(result == 0 ? -1 : result);
  }
}
