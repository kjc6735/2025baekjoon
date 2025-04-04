package b2502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int D = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    // 피보나치 수열 계산
    int[] fib = new int[31];
    fib[1] = 1;
    fib[2] = 1;
    for (int i = 3; i <= 30; i++) {
        fib[i] = fib[i-1] + fib[i-2];
    }
    
    int a = 1;
    while (true) {
        // B 계산: (K - fib[D-2] * A) / fib[D-1]
        int numerator = K - fib[D-2] * a;
        if (numerator % fib[D-1] == 0) {
            int b = numerator / fib[D-1];
            if (a <= b) {  // A ≤ B 조건 확인
                System.out.println(a);
                System.out.println(b);
                break;
            }
        }
        a++;
    }
    
  }
}
