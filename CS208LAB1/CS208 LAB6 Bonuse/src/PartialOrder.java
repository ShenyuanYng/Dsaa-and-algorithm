import java.util.Arrays;
import java.util.Scanner;

class ppp {
    static class Data implements Comparable<Data> {
        int x, y, z;

        public Data(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Data o) {
            if (x != o.x) return Integer.compare(x, o.x);
            if (y != o.y) return Integer.compare(y, o.y);
            return Integer.compare(z, o.z);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Data data = (Data) obj;
            return x == data.x && y == data.y && z == data.z;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }

    }

    static class Seg {
        static class Node {
            int val;
            Node[] ch;

            Node(int val) {
                this.val = val;
                this.ch = new Node[2];
            }
        }

        Node rt;

        Seg() {
            rt = null;
        }

        void modify(Node now, int pos, int val, int nl, int nr) {
            if (now == null) now = new Node(0);
            if (nl == nr) {
                now.val += val;
                return;
            }
            int mid = nl + nr >> 1;
            if (pos <= mid) {
                if (now.ch[0] == null) now.ch[0] = new Node(0);
                modify(now.ch[0], pos, val, nl, mid);
            } else {
                if (now.ch[1] == null) now.ch[1] = new Node(0);
                modify(now.ch[1], pos, val, mid + 1, nr);
            }
            now.val = (now.ch[0] != null ? now.ch[0].val : 0) + (now.ch[1] != null ? now.ch[1].val : 0);
        }


        int query(Node now, int l, int r, int nl, int nr) {
            if (now == null) return 0;
            if (l == nl && r == nr) return now.val;
            int mid = nl + nr >> 1;
            if (r <= mid) return query(now.ch[0], l, r, nl, mid);
            else if (l > mid) return query(now.ch[1], l, r, mid + 1, nr);
            return query(now.ch[0], l, mid, nl, mid) + query(now.ch[1], mid + 1, r, mid + 1, nr);
        }
    }

    static Seg[] tree;
    static int[] cnt;
    static int k = 50000;

    static int lb(int x) {
        return x & -x;
    }

    static void modify(int posx, int posy, int val) {
        for (int i = posx; i <= k; i += lb(i))
            tree[i].modify(tree[i].rt, posy, val, 1, k);
    }

    static int query(int x, int y) {
        int ret = 0;
        for (int i = x; i > 0; i -= lb(i))
            ret += tree[i].query(tree[i].rt, 1, y, 1, k);
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        cnt = new int[n + 1];
        tree = new Seg[k + 6];

        for (int i = 0; i <= k + 5; i++)
            tree[i] = new Seg();

        Data[] data = new Data[n + 1];

        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt();
            data[i] = new Data(x, y, z);
        }

        Arrays.sort(data, 1, n + 1);

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            if (i < n && data[i + 1].equals(data[i])) {
                sum++;
                continue;
            }
            modify(data[i].y, data[i].z, sum);
            int res = query(data[i].y, data[i].z);
            cnt[res] += sum;
            sum = 1;
        }

        for (int i = 1; i <= n; i++)
            System.out.println(cnt[i]);
    }
}
