/*import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        BST bst=new BST();
        int arr[]=new int[number];
        int j=0;
        for (int i = 0; i <number ; i++) {
            int n=input.nextInt();
            if (n==1){
                int m=input.nextInt();
                bst.add(m);
                arr[j]=m;
                j++;
            } else if (n == 2) {
                int k=input.nextInt();
               mergeSort(arr,0,j-1);
               System.out.println(arr[k-1]);
            } else if (n==3){
                bst.print(bst.root);
                System.out.println();
            }
        }
        bst.preOrder(bst.root);
    }

    public static void mergeSort(int[] arr,int l,int r){
        if (l>=r){
            return;
        }
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static void merge(int[] arr,int l,int mid,int r){
        int[] temp=new int[r-l+1];
        for (int i = l; i <=r ; i++) {
            temp[i-l]=arr[i];
        }
        int i=l;
        int j=mid+1;
        for (int k = l; k <=r ; k++) {
            if (i>mid){
                arr[k]=temp[j-l];
                j++;
            }
            else if (j>r){
                arr[k]=temp[i-l];
                i++;
            }
            else if (temp[i-l]<temp[j-l]){
                arr[k]=temp[i-l];
                i++;
            }
            else {
                arr[k]=temp[j-l];
                j++;
            }
        }
    }

}
class BST{
    Node root;
    private int size;
    public BST(){
        root=null;
        size=0;
    }

    public void add(int val){
        root=add(root,val);
    }
    private Node add(Node node,int val){
        if (node==null){
            size++;
            return new Node(val);
        }
        if (val<node.val){
            node.left=add(node.left,val);
        }
        else if (val>node.val){
            node.right=add(node.right,val);
        }
        return node;
    }*/




/*

    public int min(){
        if (size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return min(root).val;
    }
    private Node min(Node node){
        if (node.left==null){
            return node;
        }
        return min(node.left);
    }


    public void print(Node node){
        if (node.left!=null){
            print(node.left);
        }
        System.out.print(node.val+" ");
        if (node.right!=null){
            print(node.right);
        }
    }



    void preOrder(Node node){
        if (node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }


    private class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }
}*/



