package b17298;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int index; int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    static int result[] = new int[1_000_001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Arrays.fill(result, -1);

        int N = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nge0 = Integer.parseInt(st.nextToken());
        Node nge0Node = new Node(0, nge0);


        stack.push(nge0Node);
        for(int i = 1; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().value < tmp) {
                Node currnode = stack.pop();
                result[currnode.index] = tmp;    
            }
            Node node = new Node(i, tmp);
            stack.push(node);
        }

        StringBuilder sb  =new StringBuilder();

        for(int i = 0;  i < N ; i++){
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
