/*
    Student name: Yongteng Li
    Student id: B00940715
    Course: csci2110
    Project: assignment 4
 */

import java.util.LinkedList;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	private static LinkedList<BinaryTree> treeList;		//since we don't need indexes, linked list is chosen for efficiency

	public BinaryTree() {
		parent = left = right = null;
		data = null;
		treeList = new LinkedList<>();
	}

	public void makeRoot(T data) {
		if (!isEmpty()) {
			System.out.println("Can't make root. Already exists");
		} else
			this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(BinaryTree<T> tree) {
		left = tree;
	}

	public void setRight(BinaryTree<T> tree) {
		right = tree;
	}

	public void setParent(BinaryTree<T> tree) {
		parent = tree;
	}

	public T getData() {
		return data;
	}

	public BinaryTree<T> getParent() {
		return parent;
	}

	public BinaryTree<T> getLeft() {
		return left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void attachLeft(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (left != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setLeft(tree);
		}
	}

	public void attachRight(BinaryTree<T> tree) {
		if (tree == null)
			return;
		else if (right != null || tree.getParent() != null) {
			System.out.println("Can't attach");
			return;
		} else {
			tree.setParent(this);
			this.setRight(tree);
		}
	}

	public BinaryTree<T> detachLeft() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft != null)
			retLeft.setParent(null);
		return retLeft;
	}

	public BinaryTree<T> detachRight() {
		if (this.isEmpty())
			return null;
		BinaryTree<T> retRight = right;
		right = null;
		if (retRight != null)
			retRight.setParent(null);
		return retRight;
	}

	public boolean isEmpty() {
		if (data == null)
			return true;
		else
			return false;
	}

	public void clear() {
		left = right = parent = null;
		data = null;
	}

	public BinaryTree<T> root() {
		if (parent == null)
			return this;
		else {
			BinaryTree<T> next = parent;
			while (next.getParent() != null)
				next = next.getParent();
			return next;
		}
	}

	// this method returns the number of nodes/trees in a BinaryTree
	public static <T> int nodes(BinaryTree<T> t) {
		//terminate condition: t is null
		if(t == null) return 0;
		else return nodes(t.getLeft()) + nodes(t.getRight()) + 1;
	}

	// this method returns the height of a BinaryTree
	// (the number of edges separating a root node/tree from its most distant,
	// descendant leaf)
	public static <T> int height(BinaryTree<T> t) {
		//terminate condition: t is null
		if(t == null) return -1;
		if(height(t.getLeft()) > height(t.getRight())) return height(t.getLeft()) + 1;
		else return height(t.getRight()) + 1;
	}

	// this method tests whether a tree is height balanced
	public static <T> boolean heightBalanced(BinaryTree<T> t) {
		return (height(t.getLeft()) == height(t.getRight()) || Math.abs(height(t.getLeft()) - height(t.getRight())) == 1);
	}

	public static <T> void preorder(BinaryTree<T> t) {
		if (t != null) {
			System.out.print(t.getData() + "\t");
			preorder(t.getLeft());
			preorder(t.getRight());
		}
	}

	public static <T> void inorder(BinaryTree<T> t) {
		if (t != null) {
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}

	public static <T> void postorder(BinaryTree<T> t) {
		if (t != null) {
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}

	// this method uses a modified BFS to print the data associated with all
	// nodes/trees in level order
	public static <T> void levelOrder(BinaryTree<T> t) {
		 treeList.add(t);
		 while(!treeList.isEmpty()) {
			 //update t to the first element in the list, and remove it from the list
			 t = treeList.removeFirst();
			 System.out.print(t.getData() + "\t");
			 //add the left and right children of t to the linked list
			 //avoid adding null element to the list
			 if(t.getLeft() != null)
				 treeList.add(t.left);
			 if(t.getRight() != null)
				 treeList.add(t.right);
		 }
	}
}
