package com.xuguo.BST;

import java.util.Stack;

/**
 * Created by xu on 2016/7/18.
 */
public class BST {

    public TreeNode root;


    public void insert(int val) {
        root = insertHelper(root, val);
    }

    private TreeNode insertHelper(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertHelper(root.left, val);
        } else {
            root.right = insertHelper(root.right, val);
        }
        return root;
    }

    public boolean contains(int val) {
        return containsHelper(root, val);
    }

    public boolean containsHelper(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (val == root.val) {
            return true;
        } else if (val < root.val) {
            return containsHelper(root.left, val);
        } else {
            return containsHelper(root.right, val);
        }
    }

    public void print() {
        //preorderPrintHelper(root);
        //System.out.println();
        inorderPrintHelper(root);
        System.out.println();
        //postorderPrintHelper(root);
        //System.out.println();
    }


    //中序遍历：左子树->根节点->右子树
    private void inorderPrintHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderPrintHelper(root.left);
        System.out.print(root.val + " ");
        inorderPrintHelper(root.right);
    }

    private void nonRecursiveInorderPrintHelper(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                visit(node);
                node = node.right;
            }
        }
    }


    //前序遍历：根节点->左子树->右子树
    private void preorderPrintHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderPrintHelper(root.left);
        preorderPrintHelper(root.right);
    }

    private void nonRecursivePreorderPrintHelper(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                visit(node);
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    //后序遍历：左子树->右子树->根节点
    private void postorderPrintHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderPrintHelper(root.right);
        System.out.print(root.val + " ");
        postorderPrintHelper(root.left);
    }

    private void nonRecursivePostorderPrintHelper(TreeNode root) {
        TreeNode node = root;
        TreeNode prev = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                TreeNode temp = stack.peek().right;
                if (temp == null || temp == prev) {
                    node = stack.pop();
                    visit(node);
                    prev = node;
                    node = null;
                } else {
                    node = temp;
                }
            }
        }
    }

    private void visit(TreeNode node) {
        System.out.print(node.val);
    }

    public static boolean isBalenced(TreeNode root) {
        if (null == root) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalenced(root.left) && isBalenced(root.right);
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private class TreeNode {

        private int val = 0;

        private TreeNode left = null;
        private TreeNode right = null;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

    }

}
