package b5052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  static class Node{
    boolean end = false;
    Node next[] = new Node[10];

  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (tc -- > 0) {
      int N = Integer.parseInt(br.readLine());
      boolean check = false;
      Node node[] = new Node[10]; 
      for(int i = 0; i < N ; i++){
        String str = br.readLine();
        if(check) continue;
        Node currNode[] = node;
        for(int k = 0 ; k  < str.length(); k++){
          char curr = str.charAt(k);
          int charToInt = curr - '0';
          if(currNode[charToInt] != null && str.length() - 1 == k){
            check = true; 
            break;
          }
          if(currNode[charToInt] == null) currNode[charToInt] = new Node();
          if(currNode[charToInt].end == true){
            check = true;
            break;
          }
          if(str.length()-1 == k) {
            currNode[charToInt].end = true;
          }
          currNode = currNode[charToInt].next;
         }
      }
      sb.append(check ? "NO" : "YES").append("\n");
    }

    System.out.print(sb.toString());
  }
}
