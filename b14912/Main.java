package b14912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[10];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N ; i++){
            int tmp = i;
            while (tmp != 0) {
                arr[tmp % 10]++;
                tmp/=10;
            }
        }
        System.out.println(arr[d]);
    }
    
}
