package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
  
public class SwExpert1251 {
    //PRIM
    public static int N;
    public static double E;
    public static double[][] maps;
    public static double[] w;
    public static double INF = Double.MAX_VALUE;
    public static ArrayList<Long> Xs;
    public static ArrayList<Long> Ys;
    public static BufferedReader br;
    public static StringTokenizer st;
    public static void main(String[] args)throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
          
        int T = Integer.parseInt(br.readLine());
          
        for(int tc = 1; tc<= T; tc++) {
            INIT();
            w = new double[N];
            System.out.println("#" + tc + " " + Math.round(prim()));
              
              
        }//TESTCASE END
        br.close();
    }
    public static void INIT() throws Exception {
        N = Integer.parseInt(br.readLine());
        Xs = new ArrayList<Long>();
        Ys = new ArrayList<Long>();
        //X 좌표
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            Xs.add(Long.parseLong(st.nextToken()));
        }
        //Y 좌표 
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            Ys.add(Long.parseLong(st.nextToken()));
        }
        E = Double.parseDouble(br.readLine());
        maps = new double[N][N];
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(i!=j) {
                    //E * L^2
                    maps[i][j] = E * (Math.pow(Xs.get(i)-Xs.get(j), 2) + Math.pow(Ys.get(i)-Ys.get(j), 2));
                }
            }
        }
        /*
         * for(int i = 0; i<N; i++) { for(int j = 0; j<N; j++) {
         * System.out.print(maps[i][j] + " "); } System.out.println(); }
         */
          
    }//INIT END
      
    public static double prim() {
        Arrays.fill(w, -1);     //w배열을 -1로 채움
        w[0] = 0;
        for(int k = 1; k<N; k++) {
            double minWeight = INF;
            int minVertax = 0;
            for(int i = 0; i<N; i++) {
                if(w[i] < 0) continue;   //가중치 배열
                for(int j = 0; j<N; j++) {
                    if(w[j] >= 0) continue;
                    //if(minWeight>maps[i][j])
                      
                    if(Double.compare(minWeight, maps[i][j]) == 1) {
                        minWeight = maps[i][j];
                        minVertax = j;
                    }
                }
                  
            }
            w[minVertax] = minWeight;
        }//초기화
        double sum = 0;
        for(int i = 0; i<N; i++) sum += w[i];
        return sum;
    }
  
  
}