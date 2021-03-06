public class TreeNode<T> {

	TreeNode<T> left, right;
	T data;

	public TreeNode() {
		left = null;
		right = null;
		// data = null;
	}

	public TreeNode(T data) {
		left = null;
		right = null;
		this.data = data;
	}

	public void setLeft(TreeNode<T> tn) {
		left = tn;
	}

	public void setRight(TreeNode<T> tn) {
		right = tn;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}
