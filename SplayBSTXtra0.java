public class SplayBSTXtra0 extends SplayBST {

	public SplayBSTXtra0() {
		super();
	}

	public StringNode getRoot() {
		return root;
	}

	// for output purposes -- override Object version
	public String toString() {
		return toString(root, 0);
	}

	private static String toString(StringNode l, int x) {
		String s = "";
		if (l == null)
			; // nothing to output
		else {
			if (l.getLeft() != null) // don't output empty subtrees
				s = '(' + toString(l.getLeft(), x + 1) + ')';
			s = s + l.getString() + "-" + x;
			if (l.getRight() != null) // don't output empty subtrees
				s = s + '(' + toString(l.getRight(), x + 1) + ')';
		}
		return s;
	}

}