

import java.io.*;
import java.util.*;

public class lab10_2 {
    static List<Interval> a=new ArrayList<>();
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int[] data=new int[n];
        shu[] data1=new shu[n];
        for (int i=0;i<n;i++){
            data1[i]=new shu();
            data1[i].x=in.nextInt();
            data1[i].index=i;
        }
        Arrays.sort(data1);
        int dense=1;
        int what=data1[0].x;
        data[data1[0].index]=dense;
        for (int i=0;i<n;i++){
            if (what!=data1[i].x){
                what=data1[i].x;
                dense++;
            }
            data[data1[i].index]=dense;
        }
        sort(0,n-1,1,dense+1,data);
        for (int i=0;i<a.size();i++){
            out.println(a.get(i).l+" "+a.get(i).r);
        }

        out.println("-1 -1");

        out.close();
    }
    static void reverseSubset(int left, int right, int[] B)
    {

        a.add(new Interval(left+1,right+1));
        while (left < right)
        {
            int x=B[left];
            B[left]=B[right];
            B[right]=x;

            left++;
            right--;
        }
    }

    static  int bd(int l,int r, int z,int[]yuan){
        if (r>l){
            int mid=l+((r-l)/2);
            int lbd=bd(l,mid,z,yuan);
            int rbd=bd(mid+1,r,z,yuan);

            if (l+lbd<mid+rbd){

                reverseSubset(l+lbd,mid+rbd,yuan);
            }
            return lbd+rbd;
        }else {
            if (yuan[l]<=z){
                return 1;
            }else {
                return 0;
            }
        }
    }
    static void sort(int l,int r,int x,int y, int[]yuan){
        if (r>l){
            int t=(x+y)/2;
            int g=bd(l,r,t,yuan);
            int mid=l+g;
            if (g>0&y>x){
                sort(l,mid-1,x,t,yuan);
                sort(mid,r,t,y,yuan);
            }

        }
    }
    static class shu implements Comparable <shu>{
        int x;
        int index;




        @Override
        public int compareTo(shu o) {
            return Integer.compare(this.x, o.x);
        }
    }
    static class Interval {
        int l, r;

        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static class QReader {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class QWriter implements Closeable {
        private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        public void print(Object object) {
            try {
                writer.write(object.toString());
            } catch (IOException e) {
                return;
            }
        }

        public void println(Object object) {
            try {
                writer.write(object.toString());
                writer.write("\n");
            } catch (IOException e) {
                return;
            }
        }

        @Override
        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                return;
            }
        }
    }
}
