package b1120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String A = st.nextToken();
    String B = st.nextToken();
    int min = Integer.MAX_VALUE;
    for(int i = 0; i <= B.length() - A.length(); i++){
      int cnt = 0;
;
      for(int k = 0; k < A.length(); k++){
        if(A.charAt(k) != B.charAt(i + k)) cnt++;
      }
      if(cnt < min) min = cnt;
    }
    
    System.out.println(min);
  }
}
