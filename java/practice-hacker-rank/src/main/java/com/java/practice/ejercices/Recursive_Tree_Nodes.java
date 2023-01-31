package com.java.practice.ejercices;

// in a binary tree
class Recursive_Tree_Nodes {

  // Binary tree node
  static class Node {

    int value;
    Node left, right;

    Node(int data) {
      this.value = data;
      left = right = null;
    }
  }

  // Recursive function for finding the node with the given key.
  static Integer find(Node node, int key) {
    if (node == null) return null;

    if (node.value == key) return node.value;

    // then recur on left subtree
    Integer resLeft = find(node.left, key);
    if (resLeft != null) return resLeft;

    // node is not found in left, so recur on right subtree
    Integer resRight = find(node.right, key);
    if (resRight != null) return resRight; else return null;
  }

  // Driver Code
  public static void main(String args[]) {
    Node root = new Node(0);
    root.left = new Node(1);
    root.left.left = new Node(3);
    root.left.left.left = new Node(7);
    root.left.right = new Node(4);
    root.left.right.left = new Node(8);
    root.left.right.right = new Node(9);
    root.right = new Node(2);
    root.right.left = new Node(5);
    root.right.right = new Node(6);

    int key = 9;

    System.out.println(
      find(root, key) != null ? find(root, key) : "The key node is not found"
    );
  }
}
