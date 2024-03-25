import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        AVLTree avl=new AVLTree();
        for (int i = 0; i <number ; i++) {
            int n=input.nextInt();
            if(n==1){
                int m=input.nextInt();

                avl.add(m);
            }
            else if (n==2){
                int k=input.nextInt();

                avl.delete(k);
            }
            else if (n==3){
                System.out.println(avl.rank(avl.root, input.nextInt())+1);
            }
            else if (n==4){
                System.out.println(avl.select(avl.root, input.nextInt()));
            }
            else if (n == 5) {
                System.out.println(avl.findMax(avl.root, input.nextInt()));
               // System.out.println();
            }
            else {
                System.out.println(avl.findMin(avl.root, input.nextInt()));
             //   System.out.println();
            }
            }
        }

    }


/*创建一个平衡二叉树类,包括add，delete，找到比k小的最大值等方法*/
class AVLTree {
    Node root;
    private int size;

    public AVLTree() {
        size = 0;
        root = null;
    }

    /*创建节点方法*/
    class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
            height = 1;
        }
    }

    public void add(int data) {
        root = add(root, data);
    }
    //递归添加节点

    private Node add(Node node, int data) {
        if (node == null) {
            size++;
            node = new Node(data);
        } else {
            if (data < node.data) {
                node.left = add(node.left, data);
            } else {
                node.right = add(node.right, data);
            }
            node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
            int balanceFactor = getBalanceFactor(node);
            if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
                return rightRotate(node);
            }
            if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
                return leftRotate(node);
            }
            if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    //查找节点

    public void delete(int data) {
        root = delete(root, data);
    }
    //递归删除节点

    private Node delete(Node node, int data) {
        if (node == null) {
            return null;
        } else {
            if (data < node.data) {
                node.left = delete(node.left, data);
            } else if (data > node.data) {
                node.right = delete(node.right, data);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    Node temp = node;
                    node = min(temp.right);
                    node.right = deleteMin(temp.right);
                    node.left = temp.left;
                }
            }
        }
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
            return node;
        }
    }

    /*Print the ranking of x (Ranking is defined as (the number of numbers less than x) + 1 )*/
    public int rank(Node node, int data) {
        if (node == null) {
            return 0;
        }
        if (data < node.data) {//如果小于当前节点的值，就去左子树中寻找
            return rank(node.left, data);//递归
        } else if (data > node.data) {//如果大于当前节点的值，就去右子树中寻找
            return 1 + size(node.left) + rank(node.right, data);//递归
        } else {//如果等于当前节点的值，就返回左子树的节点数
            return size(node.left);//如果等于当前节点的值，就返回左子树的节点数
        }
    }

    /*创建size方法*/
    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + size(node.right) + 1;
        }
    }

    /*将bst中的数值按照升序排序并打印第k个数*/
    public int select(Node node, int k) {
        if (node == null) {
            return 0;
        }
        int t = size(node.left);
        if (t > k - 1) {
            return select(node.left, k);
        } else if (t < k - 1) {
            return select(node.right, k - t - 1);
        } else {
            return node.data;
        }
    }
    //获取节点高度

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    //获取平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        } else {
            return getHeight(node.left) - getHeight(node.right);
        }
    }
    //左旋转

    private Node leftRotate(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        temp.height = 1 + Math.max(getHeight(temp.left), getHeight(temp.right));
        return temp;
    }
    //右旋转

    private Node rightRotate(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        temp.height = 1 + Math.max(getHeight(temp.left), getHeight(temp.right));
        return temp;
    }

    /*将avl中的数值按升序排序并存到数组里，并输出数组里面比k小的最大值*/
    public int findMax(Node node, int data) {
        if (node == null) {
            return 0;
        }
        if (node.left != null) {
            if (data < node.data && data <= node.left.data) {//如果小于当前节点的值，就去左子树中寻找
                return findMax(node.left, data);//递归
            }
            if (data == node.data) {
                return node.left.data;
            }
            if (node.right != null) {
                if (data > node.data && data <= node.right.data) {
                    return node.data;
                }
                if (data > node.right.data) {
                    return findMax(node.right, data);
                }
            } else {
                if (data > node.data) {
                    return node.data;
                }
            }
        } else {
            if (data <= node.data) {//如果小于当前节点的值，就去左子树中寻找
                return 0;//递归
            }
            if (node.right != null) {
                if (data > node.data && data <= node.right.data) {
                    return node.data;
                } else if (data > node.right.data) {
                    return findMax(node.right, data);
                }
            } else {
                if (data > node.data) {
                    return node.data;
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }


    //找到比k大的最小值

    public int findMin(Node node, int data) {
        if (node == null) {
            return 0;
        }
        if (node.left != null) {
            if (node.data > data && node.left.data > data) {
                return findMin(node.left, data);
            }
            if (node.left.data == data) {
                return node.data;
            }
            if (node.right != null) {
                if (node.data <= data && node.right.data > data) {
                    return node.data;
                }
                if (node.right.data >= data) {
                    return findMin(node.right, data);
                }
            } else {
                if (node.data<=data){
                    return 0;
                }
                else {
                    return node.data;
                }
            }
        }
        else {//zuokong
            if (node.data>data){
                return node.data;
            }
            else {
                if (node.right!=null){
                    if (node.data==data){
                        return node.right.data;
                    }
                    if (node.right.data>data){
                        return node.right.data;
                    }
                    return findMin(node.right, data);
                }
                else {//youkong
                    if (data<node.data){
                        return node.data;
                    }
                    else {
                        return 0;
                    }

                }
            }
        }
        return 0;
    }
}


