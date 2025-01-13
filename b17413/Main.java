package b17413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean check = true;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '<' || str.charAt(i) == ' '){
                if(str.charAt(i) == '<') check = false;
                
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
            if(str.charAt(i) == '>') {
                check = true;
            }
            if(str.charAt(i) == '>' || str.charAt(i) == '<' || str.charAt(i) == ' ') sb.append(str.charAt(i));
            else {
                if(!check) sb.append(str.charAt(i));
                else stack.add(str.charAt(i));
            }    
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
