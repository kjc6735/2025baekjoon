package b1302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        String result = "";
        int maxCnt = 0;
        for(int i = 0; i < N ; i++){
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
            if(map.get(title) > maxCnt) {
                maxCnt = map.get(title);
                result = title;

            }else if(map.get(title) == maxCnt){
                result = result.compareTo(title) > 0? title : result;
            }
        }

        System.out.println(result);
    }
}
