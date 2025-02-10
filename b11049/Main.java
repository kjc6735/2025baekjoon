package b11049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    public int a, b;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
}
public class Main {
    static int arr[] = new int[501], N;
    static Node nodes[] = new Node[501];
   
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
        }

        fn(int curr);
    }

    private static void fn(int curr){
        if()
    }

    private static int min(int a, int b){
        return a > b ? b : a;
    }
    
}
