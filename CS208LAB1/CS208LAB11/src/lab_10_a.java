import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class lab_10_a {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        int [] ans=new int[m+1];
        thing[] a=new thing[n];
        for (int i=0;i<n;i++){
            a[i]=new thing();
            a[i].w=in.nextInt();
        }
        for (int i=0;i<n;i++){
            a[i].c=in.nextInt();
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o.c));
        for (int i=0;i<m+1;i++){
            if (a[0].c<=i){
                ans[i]=a[0].w;
            }else {
                ans[i]=0;
            }
        }
        for (int i=1;i<n;i++){
            for (int j=m;j>=0;j--){
                if(j<a[i].c){

                }else {
                    ans[j]=Math.max(ans[j],ans[j-a[i].c]+a[i].w);
                }
            }
        }
        out.println(ans[m]);




        out.close();
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
class thing{
    int w;
    int c;
}