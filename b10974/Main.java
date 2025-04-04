package b10974;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args)throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    fn(0, 0, "");
    System.out.println(sb.toString());
  }

  private static void fn(int cnt, int visited, String str){
    if(cnt == N){
      sb.append(str).append("\n");
      return ;
    }

    for(int i = 1; i <= N; i++){
      if((visited & (1 << i)) != 0) continue;
      fn(cnt + 1 , visited | ( 1<<i), str.length() == 0 ? i + "" : str + " " + i);
    }
  }
}
