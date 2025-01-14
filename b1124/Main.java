package b1124;

import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int value;
        int cnt = 0;
        public Node(int value){
            this.value = value;
        }
    }
    static Node arr[] = new Node[100_001];

    static {
        for(int i = 0;i < 100_001; i++){
            arr[i] = new Node(i);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int i = 2; i <= B ;i++){
            if(arr[i].value == 1) {
                if(A <= i && i <= B && set.contains(arr[i].cnt)){
                    result++;
                }
                continue;
            }
            if(arr[i].value == i) set.add(i);
            int tmp = arr[i].value;
            for(int cnt = 1 ; cnt * i <= B; cnt ++){
                arr[i * cnt].value /= tmp;
                arr[i * cnt].cnt += 1;
            }
            if(A <= i && i <= B && set.contains(arr[i].cnt)){
                result++;
            }
        }
        System.out.println(result);
    }
}
