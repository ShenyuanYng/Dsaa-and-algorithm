import java.util.HashMap;
import java.util.Scanner;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode buildTree(char[] inorder, char[] postorder) {
        HashMap<Character, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public TreeNode buildTreeHelper(char[] postorder, int postStart, int postEnd, char[] inorder, int inStart, int inEnd,
                                    HashMap<Character, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        char rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inMap.get(rootVal);
        int leftSubtreeSize = rootIndex - inStart;

        root.left = buildTreeHelper(postorder, postStart, postStart + leftSubtreeSize - 1, inorder, inStart,
                rootIndex - 1, inMap);
        root.right = buildTreeHelper(postorder, postStart + leftSubtreeSize, postEnd - 1, inorder, rootIndex + 1,
                inEnd, inMap);

        return root;
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}

public class q3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1=input.next();
        String str2=input.next();
        char[] inorder = new char[str1.length()];
        char[] postorder = new char[str2.length()];
        for (int i = 0; i <str1.length() ; i++) {
            inorder[i]= str1.charAt(i);
            postorder[i]= str2.charAt(i);
        }


        Solution solution = new Solution();
        TreeNode root = solution.buildTree(inorder, postorder);

        solution.preOrderTraversal(root);
    }
}


