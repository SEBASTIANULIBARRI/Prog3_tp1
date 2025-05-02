public class Node<T extends Comparable<T>> {

	private T info;
	private Node<T> left;
	private Node<T> right;

	public Node() {
		this.info = null;
		this.left = null;
		this.right = null;
	}
	public Node(T info ) {
		this.setInfo(info);
		this.setLeft(null);
		this.setRight(null);
	}
	public Node(T info, Node<T> left, Node<T> right ) {
		this.setInfo(info);
		this.setLeft(left);
		this.setRight(right);
	}

	public Node<T> getLeft() {
		return left;
	}
	public Node<T> getRight() {
		return right;
	}
	public boolean hasChilds() {
		return right!= null || left !=null;
	}
	public boolean hasOneChild() {
		return right!= null && left ==null || right== null && left !=null;
	}
	public Node<T> child() {
		return (right != null) ? right : left ;
	}




	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "" + info;
	}



}
