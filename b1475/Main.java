package b1475;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int arr[] = new int[10];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - '0'] ++;
        }

        int min69 = Math.min(arr[6], arr[9]);
        int result69 = Math.max(arr[6], arr[9]);
        
        int tmp = (result69 - min69)%2 == 1 ? (result69 - min69)/2 + 1 : (result69 - min69)/2;
        int result = min69 + tmp;
        int cnt = 0;
        for(int i = 0 ; i < 9; i++){
            if(i == 6 || i == 9) continue;
            cnt = Math.max(arr[i], cnt);
        }
        cnt = Math.max(cnt,result);
        System.out.println(cnt);
    }
}
