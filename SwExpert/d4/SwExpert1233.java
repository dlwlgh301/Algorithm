package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SwExpert1233 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] datas;
        for(int t=1; t<=10; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            boolean flag = false;
            datas = new String[N+1];
            for(int k=0; k<N; k++) {
                st = new StringTokenizer(br.readLine());
                if(!flag){
                    int idx = Integer.parseInt(st.nextToken());
                    String data = st.nextToken();
                    datas[idx] = data;
                    if(st.countTokens() == 2 && !data.equals("+") && !data.equals("-") && !data.equals("*") && !data.equals("/")){
                        flag = true;
                        System.out.println("#"+t+" "+0);    
                    }
                    else if(!st.hasMoreTokens() && (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/"))){
                        flag = true;
                        System.out.println("#"+t+" "+0);
                    }
                }
            }
            if(!flag) System.out.println("#"+t+" "+1);
        }
    }
}