package b15925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int vertical = 0;
        int horizontal = 0;
    }

    static int[] arr= new int[32];
    static int N;
    static int target;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N ; k++){
                String tmp = st.nextToken();
                if(tmp.equals("1")){
                    arr[i] = arr[i] | (1 << k);
                }
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        fn()
    }

    private static void fn(){

    }


    private static boolean check(){
        int r = target == 1 ? (1 << N) -1 : 0;
        for(int i = 0; i < N ; i++){
            if(arr[i] != r) return false;
        }
        return true;
    }
    
}
