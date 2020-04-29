package Tree;

public class subtree {
    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {

            return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);

        }

        public boolean isSame(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            } else if (s == null || t == null)
                return false;

            if (s.val == t.val) {
                return isSame(s.left, t.left) && isSame(s.right, t.right);
            } else {
                return false;
            }
        }
    }
}
