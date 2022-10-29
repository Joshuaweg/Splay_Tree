public class StringNode {
    private String word;
    private StringNode left, right;
    // The only constructor you will need
    public StringNode(String w) {word = w; left = null; right = null; }
    public String getString() {return word; }
    public void setString(String w){word =w ;}
    public StringNode getLeft() {return left; }
    public void setLeft(StringNode pt) {left = pt; }
    public StringNode getRight() {return right; }
    public void setRight(StringNode pt) {right = pt; }
    
    }