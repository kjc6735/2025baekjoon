package b2461;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int arr[][] = new int[1000][1000];
    static PriorityQueue<Integer> pq[] = new PriorityQueue[1000];
    static int N, M;
    static int minGap = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i =0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M ; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        
    }    
}
