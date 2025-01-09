package b1094;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int curr = 64;
        int X = Integer.parseInt(br.readLine());
        int cnt = 0;
        int tmp = 0;
        int r = X;
        while (true) {
            if(X == 64){
                cnt += 1;
                break;
            }

            curr /= 2;
            if(curr <= X){
                tmp += curr;
                cnt ++;
                if(r == tmp) break;
                X -= curr;
            }
        }

       
        System.out.println(cnt);
    }
}
