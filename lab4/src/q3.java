/*import java.io.*;
import java.util.*;

class q3 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T=in.nextInt();
        for (int j = 0; j <T ; j++) {

        int N = in.nextInt();
        SpecialList list = new SpecialList();
        for (int i = 0; i < N; i++) {
            list.add(in.nextLong(), in.nextLong());
        }

        list.refresh();

        int M=in.nextInt();
        for (int i = 0; i < M; i++) {
            list.add(in.nextLong(), in.nextLong());
        }

        Node node = list.head;
        long count = 0L;
        while (node.next != null) {
            node = node.next;
            if (node.coefficient != 0) {
                count++;
            }
        }

       // out.println(count);
        node = list.head;

        while (node.next != null) {
            node = node.next;
            if(node.coefficient!=0) {

                //系数指数都正常
                if (node.coefficient != 1 && node.exponent != 0&&node.exponent!=1&&node.coefficient!=-1) {
                    out.print(node.coefficient + "x^" + node.exponent);
                    count--;
                }
                //系数正常指数为1
                if (node.coefficient != 1 && node.exponent == 1&&node.coefficient!=-1) {
                    out.print(node.coefficient + "x^");
                    count--;
                }
                //指数为0
                if (node.coefficient != 0 && node.exponent == 0) {
                    out.print(node.coefficient);
                    count--;
                }
                //指数为1系数为1
                if (node.exponent == 1 && node.coefficient == 1) {
                    out.print("x");
                    count--;
                }
                //系数为1指数不为0且不为1
                if (node.coefficient == 1 && node.exponent != 0 && node.exponent != 1) {
                    out.print("x^" + node.exponent);
                    count--;
                }
                //系数为-1指数为0
                if (node.coefficient==-1&&node.exponent==0){
                    out.print("-1");
                    count--;
                }
                //系数为-1指数为1
                if (node.coefficient==-1&&node.exponent==1){
                    out.print("-x");
                    count--;
                }
                //系数为-1指数大于1
                if (node.coefficient==-1&&node.exponent>1){
                    out.print("-x^"+node.exponent);
                    count--;
                }


                if (count >= 1 && node.next.coefficient > 0 && node.coefficient != 0) {
                    out.print("+");
                }
            }
            if (node.coefficient==0){
                out.print(0);
            }
        }
        out.print("\n");
    }
        out.close();
    }
}

class SpecialList {
    // fake head
    Node head = new Node(-100000001L, -100000001L, null);
    Node current = head;

    public void add(long coefficient, long exponent) {
        while (current.next != null) {
            if (current.exponent == exponent || current.next.exponent > exponent) {
                break;
            }
            current = current.next;
        }

        // add one node
        if (current.exponent != exponent) {
            Node newNode = new Node(0, exponent, current.next);
            current.next = newNode;
            current = newNode;
        }

        current.coefficient += coefficient;
    }

    public void refresh() {
        current = head;
    }
}


class Node {
    long coefficient;
    long exponent;
    Node next;

    public Node(long coefficient, long exponent, Node next) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = next;
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