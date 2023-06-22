import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.Deque;
import java.util.Collections;
import java.util.StringTokenizer;
 
class CCStart89B {
    private static FastReader reader = new FastReader();
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        // int test = 1;
        int test = reader.nextInt();
        while (test-- > 0) {
            int n = read();
            int arr[] = intArray(n);
            if(arr[0]==1 || arr[n-1]==1){
                out.println(n-1);
                continue;
            }
            PriorityQueue<int[]> que = new PriorityQueue<>(n, (a,b)->{
                return b[0]-a[0];
            });
            int ind = 0;
            for(int i=0;i<n;i++){
                if(arr[i]==1){
                    ind = i;
                }
                que.offer(new int[]{arr[i], i});
            }
            int start = que.peek()[1];
            int end = que.poll()[1];
            int max = 1;
            int count = 1;
            while(true){
                if(que.size()==1){
                    break;
                }

                int t[] = que.poll();

                if(t[1]<=end && t[1]>=start){
                    count++;
                }
                else if(t[1]<start){
                    start = t[1];
                    count++;
                }
                else{
                    end = t[1];
                    count++;
                }

                if(ind>=start && ind<=end){
                    break;
                }
                if(end-start+1==count){
                    max = count;
                }


            }

            out.println(max);
        }
            
        
        out.flush();
        out.close();
    }

 
    private static String[] array(int n){
        String s[] = new String[n];
        for(int i=0;i<n;i++){
            s[i] = reader.next();
        }
        return s;
    }
    private static int[] intArray(int n){
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = reader.nextInt();
        }
        return arr;
    }
    private static int read(){
        return reader.nextInt();
    }
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        int[] readIntArray(int arr[], int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
 
        long[] readLongArray(long arr[], int n) {
            arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
}