package b1446;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static int N, D;
  static Map<String, Integer> map = new HashMap<>();
  static int[] dist = new int[10_001]; 
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    
    List<int[]>[] shortcuts = new ArrayList[10_001];
    for (int i = 0; i <= D; i++) {
      shortcuts[i] = new ArrayList<>();
      dist[i] = i; 
    }
    
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int length = Integer.parseInt(st.nextToken());
      
      if (end > D || end - start <= length) continue;
      
      shortcuts[start].add(new int[]{end, length});
    }
    
    for (int i = 0; i <= D; i++) {
      if (i > 0) {
        dist[i] = Math.min(dist[i], dist[i-1] + 1);
      }
      
      for (int[] shortcut : shortcuts[i]) {
        int end = shortcut[0];
        int length = shortcut[1];
        
        dist[end] = Math.min(dist[end], dist[i] + length);
      }
    }
    
    System.out.println(dist[D]);
  }
}