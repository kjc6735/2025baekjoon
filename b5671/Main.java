package b5671;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    int arr[] = new int[5001];
    HashSet<Character> set = new HashSet<>();
    for(int i = 1; i <= 5000; i++){
      str = String.valueOf(i);
      for(int k = 0; k < str.length(); k++) set.add(str.charAt(k));
      if(set.size() == str.length()) arr[i] = arr[i-1] + 1;
      else arr[i] = arr[i-1];
      set.clear();
    }
    
    str = null;
    StringBuilder sb = new StringBuilder();
    while ((str = br.readLine()) != null) {
      if (str.trim().isEmpty()) break; 
      String tmp[] = str.split(" ");
      int N = Integer.parseInt(tmp[0]);
      int M = Integer.parseInt(tmp[1]);
      sb.append(arr[M] - arr[N-1]).append("\n");
    }

    System.out.print(sb.toString());
  }
}
