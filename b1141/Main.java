package b1141;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
  static class Node{
    Node[] next = new Node[30];
    int cnt = 0;
  }
  public static void main(String[] args)throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    char[][] arr = new char[N][50];
    for(int i = 0 ; i < N; i++) arr[i] = br.readLine().toCharArray();
    Arrays.sort(arr,(a, b) ->  b.length - a.length);
    int max = 0;
    Node[] nodes = new Node[30];
    
    Node[] currNode;
    for(int i =0; i < N ; i++){
      currNode = nodes;
      for(int k = 0; k < arr[i].length; k++){
        if(currNode[arr[i][k] - 'a'] == null){
          currNode[arr[i][k] - 'a'] = new Node();
        }
        
        currNode[arr[i][k] - 'a'].cnt ++;
        if(k == arr[i].length- 1) {
          if(currNode[arr[i][k] - 'a'].cnt == 1) {
            max++;
          }
        } else {
          if(currNode[arr[i][k] - 'a'].next == null) currNode[arr[i][k] - 'a'].next = new Node[30];
          currNode = currNode[arr[i][k] - 'a'].next;    
        }
      }
    }

    System.out.println(max);
  }
}
