package Tree;

import java.util.ArrayList;
import java.util.List;

//Two elements of a binary search tree (BST) are swapped by mistake.
//Recover the tree without changing its structure.
public class RecoverbinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(2);

        recoverTree(treeNode);
        System.out.println(treeNode);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void recoverTree(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrderTraversal(root, arr);
        int[] swapped = findMisplacedArray(arr);
        fixTree(root,2,swapped[0],swapped[1]);

    }

    private static void fixTree(TreeNode root, int count, int i1, int i2) {
        if (root==null)return;
        if (root.val==i1 || root.val==i2){
            root.val=root.val==i1?i2:i1;
            if (--count<=0)
                return;
        }

        fixTree(root.left,count,i1,i2);
        fixTree(root.right,count,i1,i2);
    }

    private static int[] findMisplacedArray(List<Integer> arr) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) < arr.get(i)) {
                x = arr.get(i + 1);
                if(y==-1) y = arr.get(i);
                else break;
            }
        }
        return new int[]{x, y};
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrderTraversal(root.left, nums);
        nums.add(root.val);
        inOrderTraversal(root.right, nums);

    }
}
