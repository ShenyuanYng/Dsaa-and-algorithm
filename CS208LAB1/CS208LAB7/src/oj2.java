import java.io.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class oj2{
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        fruit[] fruits = new fruit[n];
        for (int i = 0; i < n; i++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long val = in.nextLong();
            fruits[i] = new fruit(l, r, val);
        }
        Arrays.sort(fruits, new Comparator<fruit>() {
            @Override
            public int compare(fruit o1, fruit o2) {
                return (int) (o1.l - o2.l);
            }
        });
        ts[] ts = new ts[n];
        HashMap<Long,ts> map = new HashMap<>();
        long x = 0;
        for (int i = 0; i < n; i++) {
            x = Math.max(x + 1, fruits[i].l);
            ts[i] = new ts(i, true);
            ts[i].x = x;
            map.put(x,ts[i]);
            if (i > 0) {
                ts[i - 1].next = ts[i];
            }
        }
        Arrays.sort(fruits, new Comparator<fruit>() {
            @Override
            public int compare(fruit o1, fruit o2) {
                return (int) (o2.val - o1.val);
            }
        });
        long earning = 0;
        for (int i = 0; i < n; i++) {
            long l = fruits[i].l;
            ts ts1 = map.get(l);
            if (linearMatch(fruits[i],ts1)){
                earning+=fruits[i].val;
            }
        }
        out.println(earning);
        out.close();

    }

    public static boolean linearMatch(fruit fruit, ts ts) {
        if (ts.x > fruit.r) return false;
        if (ts.free) {
            ts.free = false;
            ts.f = fruit;
            return true;
        }
        fruit fruit1 = ts.getF();
        if (fruit.r > fruit1.r) {
            return linearMatch(fruit, ts.next);
        } else {
            if (linearMatch(fruit1, ts.next)) {
                ts.f = fruit;
                return true;
            }
        }
        return false;
    }
}

class fruit {
    long l;
    long r;
    long val;

    public fruit(long l, long r, long val) {
        this.val = val;
        this.l = l;
        this.r = r;
    }
}

class ts {
    int index;
    fruit f;

    long x;
    boolean free;
    ts next;

    public ts(int index, boolean free) {
        this.index = index;
        this.free = free;
    }

    public fruit getF() {
        return f;
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
}