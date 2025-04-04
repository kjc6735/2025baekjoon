package b1235;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] arr = new String[N];
    HashSet<String> set = new HashSet<>();
    int maxLen = 0;
    for(int i = 0 ; i < N ; i++){
      arr[i] = br.readLine();
      if(maxLen < arr[i].length()) maxLen = arr[i].length();
    }
    
    for(int i = 0; i < N; i++){
      for(int len = 1; len <= maxLen; len++){
        for(int k = 0; k < N; k++){
          set.add(new String(arr[k].toCharArray(), arr[k].length() - len, len));
        }
        if(set.size() == N) {
          System.out.println(len);
          return;
        }
        set.clear();
      }
    }
  }
}
