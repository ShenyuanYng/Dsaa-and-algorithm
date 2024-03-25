import java.io.*;
import java.util.StringTokenizer;

public class lab_10_b {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T=in.nextInt();
        for (int i=0;i<T;i++){
            String s=in.nextLine();
           int n=s.length();
           int [] ans=new int[n];
           int length=2;
           for (int j=0;j<n-1;j++){
               if (s.charAt(j)!=s.charAt(j+1)){
                   ans[j]=-1;
               }else {
                   ans[j]=0;
               }
           }
           while (length<n){

               length+=2;
               for (int j=0;j+length<=n;j++){
                    char s1=s.charAt(j);
                    char s2=s.charAt(j+1);
                    char s3=s.charAt(j+length-2);
                    char s4=s.charAt(j+length-1);




                    if(s1==s4){
                         if (s2<s1&s3<s4){
                             ans[j]=1;
                         }
                        if (s2>s1&s3>s4){
                            ans[j]=ans[j+1];
                        }
                        if (s2>s1&s3<s1){
                            ans[j]=ans[j+1];
                        }
                        if (s3>s1&s2<s1){
                            ans[j]=ans[j+1];
                        }
                        if(s1==s2&s2==s3){
                            ans[j]=Math.max(ans[j+1],ans[j+2]);
                        }
                        if (s1==s2&&s1>s3){
                            ans[j]=Math.max(ans[j+1],ans[j+2]);
                        }
                        if (s1==s3&s1>s2){
                            ans[j]=Math.max(ans[j],ans[j+1] );
                        }
                        if (s1==s2&s1<s3){
                            ans[j]=Math.max(ans[j+1],Math.max(ans[j+1], ans[j+2]) );
                        }
                        if (s1==s3&s1<s2){
                            ans[j]=Math.max(ans[j+1], Math.max(ans[j],ans[j+1] ));
                        }
                    }else {
                        if(s1>s4){
                            if (s4>s3){
                                ans[j]=1;
                            }else if (s4==s3){
                                ans[j]=ans[j];
                            }else {
                                ans[j]=-1;
                            }
                        }else {
                              if (s1>s2){
                                  ans[j]=1;
                              }else if (s1==s2){
                                  ans[j]=ans[j+2];
                              }else {
                                  ans[j]=-1;
                              }
                        }
                    }





               }

           }
           if (ans[0]==-1){
               out.println("Alice");
           }else if (ans[0]==0){
               out.println("Draw");
           }else {
              out.println("Bob");
           }



        }

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
