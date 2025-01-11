package b28278;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N ;i ++){
            String cmd = br.readLine();
            if(cmd.charAt(0) == '1') {
                int value = Integer.parseInt(cmd.split(" ")[1]);
                stack.add(value);
            }else if(cmd.charAt(0) == '2'){
                if(!stack.isEmpty()){
                    sb.append(stack.pop()).append("\n");
                }else {
                    sb.append(-1).append("\n");
                }
            }else if(cmd.charAt(0) == '3'){
                sb.append(stack.size()).append("\n");
            }else if(cmd.charAt(0) == '4'){
                if(!stack.isEmpty()){
                    sb.append(0).append("\n");
                }else {
                    sb.append(1).append("\n");
                }
            }else{
                if(!stack.isEmpty()){
                    sb.append(stack.peek()).append("\n");
                }else {
                    sb.append(-1).append("\n");
                }
            }
            
        }
        System.out.println(sb.toString());
    }
}
