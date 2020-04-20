public class BST {
  private TreeNode root;

  protected void insert(int value) {
    if (root == null) {
      root = new TreeNode(value);
      return;
    }

    TreeNode currentNode = root;
    boolean inserted = false;

    while (!inserted) {
      if (value < currentNode.value) {
        if (currentNode.left == null) {
          currentNode.left = new TreeNode(value);
          inserted = true;
        } else {
          currentNode = currentNode.left;
        }
      } else if (value == currentNode.value) {
        inserted = true;
      } else {
        if (currentNode.right == null) {
          currentNode.right = new TreeNode(value);
          inserted = true;
        } else {
          currentNode = currentNode.right;
        }
      }
    }
  }

  protected void remove(int value) {
    if (root == null) {
      return;
    }

    TreeNode parent = null;
    TreeNode currentNode = root;

    while (currentNode.value != value) {
      parent = currentNode;

      if (value < currentNode.value && currentNode.left != null) {
        currentNode = currentNode.left;
      } else if (value > currentNode.value && currentNode.right != null) {
        currentNode = currentNode.right;
      } else {
        return;
      }
    }

    if (currentNode.left == null && currentNode.right == null) {
      if (currentNode == root) {
        root = null;
        return;
      }

      if (parent.left == currentNode) {
        parent.left = null;
      } else {
        parent.right = null;
      }

      return;
    }

    if (currentNode.right == null) {
      if (currentNode == root) {
        root = root.left;
        return;
      }

      if (parent.left == currentNode) {
        parent.left = currentNode.left;
      } else {
        parent.right = currentNode.left;
      }

      return;
    }

    if (currentNode.left == null) {
      if (currentNode == root) {
        root = root.right;
        return;
      }

      if (parent.left == currentNode) {
        parent.left = currentNode.right;
      } else {
        parent.right = currentNode.right;
      }

      return;
    }

    if (currentNode.right.left == null) {
      currentNode.value = currentNode.right.value;
      currentNode.right = currentNode.right.right;
      return;
    }

    TreeNode succ = currentNode.right;
    TreeNode succParent = currentNode;

    while (succ.left != null) {
      succParent = succ;
      succ = succ.left;
    }

    currentNode.value = succ.value;
    succParent.left = succ.right;
  }

  protected void printTree() {
    reverseInOrderTraverse(root, 0);
  }

  protected void reverseInOrderTraverse(TreeNode currentNode, int space) {
    if (currentNode == null) {
      return;
    }

    space += 10;
    reverseInOrderTraverse(currentNode.right, space);

    System.out.println();
    for (int i = 10; i < space; i++) {
      System.out.print(" ");
    }
    System.out.println(currentNode.value);

    reverseInOrderTraverse(currentNode.left, space);
  }
}
