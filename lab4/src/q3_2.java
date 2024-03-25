/*
import java.io.*;
import java.util.StringTokenizer;

public class q3_2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for (int jjjj = 0; jjjj < T; jjjj++) {


            int n = in.nextInt();
            node head = new node(-1000000001, -1000000001);//fake head
            node cur = head;
            node tail = new node(1000000001, 1000000001);


            long[][] arr1 = new long[n][2];
            for (int i = 0; i < n; i++) {
                arr1[i][0] = in.nextLong();
                arr1[i][1] = in.nextLong();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (arr1[j - 1][1] > arr1[j][1]) {
                        long tem0 = arr1[j - 1][0];
                        long tem1 = arr1[j - 1][1];
                        arr1[j - 1][0] = arr1[j][0];
                        arr1[j - 1][1] = arr1[j][1];
                        arr1[j][0] = tem0;
                        arr1[j][1] = tem1;
                    }
                }
            }


            for (int i = 0; i < n; i++) {
                node temp = new node(arr1[i][0], arr1[i][1]);
                cur.next = temp;
                cur = cur.next;
            }

            cur.next = tail;

            int m = in.nextInt();
            if (n==0&&m==0){
                out.print(0);
                out.close();
            }

            long[][] arr2 = new long[m][2];
            for (int i = 0; i < m; i++) {
                arr2[i][0] = in.nextLong();
                arr2[i][1] = in.nextLong();
            }

            for (int i = 0; i < m; i++) {
                for (int j = 1; j < m; j++) {
                    if (arr2[j - 1][1] > arr2[j][1]) {
                        long tem0 = arr2[j - 1][0];
                        long tem1 = arr2[j - 1][1];
                        arr2[j - 1][0] = arr2[j][0];
                        arr2[j - 1][1] = arr2[j][1];
                        arr2[j][0] = tem0;
                        arr2[j][1] = tem1;
                    }
                }
            }
            cur = head;
            for (int i = 0; i < m; i++) {
                long coe = arr2[i][0];
                long exp = arr2[i][1];
                while (true) {
                    if (exp < cur.next.exp) {
                        break;
                    }
                    cur = cur.next;
                }
                if (cur.exp == exp) {
                    cur.coe += coe;

                } else {
                    node temp = new node(coe, exp);
                    temp.next = cur.next;
                    cur.next = temp;
                }

            }


            int count = 0;
            cur = head.next;
            while (cur != tail) {
                count++;
                cur = cur.next;
            }
            boolean res = false;
            cur = head;
            cur = cur.next;
            if (cur.coe != 0) {
                res = true;
                //first
                if (cur.coe > 0) {
                    if (Math.abs(cur.coe) != 1) {
                        if (cur.exp == 0) {
                            out.print(cur.coe);
                        } else if (cur.exp == 1) {
                            out.print(cur.coe + "x");
                        } else {
                            out.print(cur.coe + "x^" + cur.exp);
                        }
                    } else {
                        if (cur.exp == 0) {
                            out.print(cur.coe);
                        } else if (cur.exp == 1) {
                            out.print("x");
                        } else {
                            out.print("x^" + cur.exp);
                        }
                    }
                } else {
                    if (Math.abs(cur.coe) != 1) {
                        if (cur.exp == 0) {
                            out.print(cur.coe);
                        } else if (cur.exp == 1) {
                            out.print(cur.coe + "x");
                        } else {
                            out.print(cur.coe + "x^" + cur.exp);
                        }
                    } else {
                        if (cur.exp == 0) {
                            out.print(cur.coe);
                        } else if (cur.exp == 1) {
                            out.print("-x");
                        } else {
                            out.print("-x^" + cur.exp);
                        }
                    }

                }
            }
            int num=count;
            for (int i = 0; i < count - 1; i++) {
                cur = cur.next;
                if (cur.coe==0){
                    num--;
                }
                if (cur.coe > 0) {
                    res = true;
                    if (Math.abs(cur.coe) != 1) {
                        if (cur.exp == 0) {
                            out.print("+" + cur.coe);
                        } else if (cur.exp == 1) {
                            out.print("+" + cur.coe + "x");
                        } else {
                            out.print("+" + cur.coe + "x^" + cur.exp);
                        }
                    } else {
                        if (cur.exp == 0) {
                            out.print("+" + cur.coe);
                        } else if (cur.exp == 1) {
                            out.print("+x");
                        } else {
                            out.print("+x^" + cur.exp);
                        }
                    }
                }
                else if (cur.coe < 0) {
                    res = true;
                    if (Math.abs(cur.coe) != 1) {
                        if (cur.exp == 0) {
                            out.print(cur.coe);
                        } else if (cur.exp == 1) {
                            out.print(cur.coe + "x");
                        } else {
                            out.print(cur.coe + "x^" + cur.exp);
                        }
                    } else {
                        if (cur.exp == 0) {
                            out.print(cur.coe);
                        } else if (cur.exp == 1) {
                            out.print("-x");
                        } else {
                            out.print("-x^" + cur.exp);
                        }
                    }
                }
            }
            if (num==0){
                out.print(0);
            }
            if (!res) {
                out.println(0);
            } else {
                out.println("");
            }
        }
        out.close();
    }
}

class node {
    node next;
    long coe;
    long exp;

    public node(long coe, long exp) {
        this.coe = coe;
        this.exp = exp;
    }

}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

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
}*/

