//Joshua Weg
//COMP 282 TR 200PM - 315PM
//Program 2 - Splay Trees
//10/27/2022



class StringNode {
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

} // StringNode
// So that a String can change. There is nothing you need to add
// to this class
class WrapString {
// Yes, I am allowing (and encouraging) direct access to the String
// in this class
public String string;
public WrapString(String str) {
this.string = str;
}
}
class SplayBST {
// member variable pointing to the root of the splay tree
// It really should be private but I need access to it for the test program
public StringNode root;
// default constructor
public SplayBST() { root = null; }
// copy constructor
// Be sure to make a copy of the entire tree
// Do not make two pointers point to the same tree
public SplayBST(SplayBST t) {
       this.root = copy(t.root);
}
// like last time
public static String myName() {return "Joshua Weg"; }
// a final zig here, not in the recursive method
// You will also have to write the 2-parameter recursive insert method
public void insert(String s) { 
            root = insert(s,root); //driver
           //checks to see if the inserted value is at the root
            if(root.getString().compareTo(s) != 0){
              if(s.compareTo(root.getString()) < 0){
                //zig (left)
                  root=rotateRight(root);//if value is in the left child
                  
              }
              else{
                //zig (right)
                  root=rotateLeft(root);//if value is in the right child
                  
             }
            }
}
// The 2-parameter recursive method
private static StringNode insert(String d, StringNode t) {
if( t == null){ //inserts node
    t = new StringNode(d);
}
else{
    //checks if the current node value is less than d
    if(d.compareTo(t.getString())<0){
        //recursice call insert on left tree
        t.setLeft(insert(d,t.getLeft()));
        if(d.compareTo(t.getLeft().getString())==0){//base case

        }
        else{
            //if leftchild is not null
            if(t.getLeft()!=null){
            //if  leftchild of left child is not null
            if(t.getLeft().getLeft()!=null){
            // if leftchild of leftchild has value of d
            if(d.compareTo(t.getLeft().getLeft().getString())==0){
                //zig zig to the right
                t=rotateRight(rotateRight(t));
                
            }
        }
    }
            if(t.getLeft()!=null){
                //if right child of left child is not null
            if(t.getLeft().getRight()!=null){
                //if value of right child of left child is d
            if(d.compareTo(t.getLeft().getRight().getString())==0){
                //zig zag (right left)
                t.setLeft(rotateLeft(t.getLeft()));
                t=rotateRight(t);
                
                
            }
        }
            }
        }
    }
     //if current value is greater than d
    else if(d.compareTo(t.getString())>0){
        //recursive call insert on right child
        t.setRight(insert(d,t.getRight()));
        if(d.compareTo(t.getRight().getString())==0){//base case

        }
        else{
            if(t.getRight()!=null){
            if(t.getRight().getLeft()!=null){
            if(d.compareTo(t.getRight().getLeft().getString())==0){
                // zig zag rotation (left-right)
                t.setRight(rotateRight(t.getRight()));
                t=rotateLeft(t);
               
                
            }
        }
        }
        if(t.getRight()!=null){
            if(t.getRight().getRight()!=null){
            if(d.compareTo(t.getRight().getRight().getString())==0){
                /// zig zig rotation (left-left)
                t=rotateLeft(rotateLeft(t));
                
            }
          }
        }
        }
        
    }
    else{}//do nothing
}
return t;

}
// if s is not in the tree, splay the last node visited
// final zig, if needed, is done here
// Return null if the string is not found
public StringNode search(String s) {
    StringNode res = root; //return variable
    WrapString tes =new WrapString(s); // accessable for any changes
    root = search( tes, root);//driver
    //checks if searched value is at the root
    if(root.getString().compareTo(tes.string) != 0){
        if(s.compareTo(root.getString()) < 0){
          //zig (left)
            root=rotateRight(root);//if in left childe
            
        }
        else{
          //zig (right)
            root=rotateLeft(root);//if in right child
            
       }
      }
      //sees if the root value is the searched value
      if(s.compareTo(root.getString())!=0){
         res=null; // if not
      }
      else
         res=root; //if it is
    return res;

}
// recursive search method
// if str not in the tree str backtracks with value of last node visited
private static StringNode search(WrapString str, StringNode t) {
    if( t == null){  //do nothing
        t= null;
    }
    else{
        //checks if the current node value is less than str.string
        if(str.string.compareTo(t.getString())<0){
            //recursive call insert on left tree
            t.setLeft(search(str,t.getLeft()));
            //determine if left child is null
            //end of search
            if(t.getLeft()==null){
                //update Wrapstring to current node value
                str.string=t.getString();
            }
            if((t.getLeft()!=null)&&(str.string.compareTo(t.getLeft().getString())==0)){//base case
    
            }
            else{
                //if leftchild is not null
                if(t.getLeft()!=null){
                //if  leftchild of left child is not null
                if(t.getLeft().getLeft()!=null){
                // if leftchild of leftchild has value of str.string
                if(str.string.compareTo(t.getLeft().getLeft().getString())==0){
                    //zig zig to the right
                    t=rotateRight(rotateRight(t));
                    
                }
            }
        }
                if(t.getLeft()!=null){
                    //if right child of left child is not null
                if(t.getLeft().getRight()!=null){
                    //if value of right child of left child is str.string
                if(str.string.compareTo(t.getLeft().getRight().getString())==0){
                    //zig zag (right left)
                    t.setLeft(rotateLeft(t.getLeft()));
                    t=rotateRight(t);
                    
                    
                }
            }
                }
        }
        }
         //if current value is greater than str.string
        else if(str.string.compareTo(t.getString())>0){
            //recursive call insert on right child
            t.setRight(search(str,t.getRight()));
            if(t.getRight()==null){
                //update WrapString to value at current node
                str.string =t.getString();
            }
            
            if((t.getRight()!=null)&&(str.string.compareTo(t.getRight().getString())==0)){//base case
    
            }
            else{
                if(t.getRight()!=null){
                if(t.getRight().getLeft()!=null){
                if(str.string.compareTo(t.getRight().getLeft().getString())==0){
                    // zig zag rotation (left-right)
                    t.setRight(rotateRight(t.getRight()));
                    t=rotateLeft(t);
                   
                    
                }
            }
            }
            if(t.getRight()!=null){
                if(t.getRight().getRight()!=null){
                if(str.string.compareTo(t.getRight().getRight().getString())==0){
                    /// zig zig rotation (left-left)
                    t=rotateLeft(rotateLeft(t));
                    
                }
              }
            }
            }
        
            
        }
        else{} //do nothing
    }
    return t;
 }
public static StringNode rotateLeft(StringNode t) {
       //get right subtree
       StringNode right = t.getRight();
       //reassign tree right child to right subtree left child
       //reassign right sub tree left child to tree
       if(right!=null){
       t.setRight(right.getLeft());
       right.setLeft(t);
       }
       
    return right;
    
        
        
       
}
public static StringNode rotateRight(StringNode t) {
    //getting left subtree of root
    StringNode left = t.getLeft();
    //check is left is null
    if(left!= null){
    //setting the left child root to the right child of the left subtree
    t.setLeft(left.getRight());
    //if left child is not null, point parent to root
    //setting the right subtree to the root
    left.setRight(t);
    
  } 
  return left; 
  
}
// How many leaves in the splay tree?
public int leafCt() {
     return leafCt(root);//driver
}
private static int leafCt(StringNode t){
    int res = 0;
    if(t!=null) res=leafCt(t.getLeft())+leafCt(t.getRight())+1;
    return res;
}
// What is the height the splay tree?
public int height() {return height(root); } //driver

private static int height (StringNode t){
    int height=0;
    int left ;
    int right;
    if (t!=null){
        left=height(t.getLeft());
        right=height(t.getRight());
    if(left>right) height = left+1;
    else height = right+1;
    }
    return height;
}
// How many nodes have exactly 1 non-null children
public int stickCt() {return stickCt(root); } //driver
private static int stickCt(StringNode t){
    int count = 0;
    if(t!=null){
        if((t.getRight()==null)&&(t.getLeft()!=null)){
           count+=stickCt(t.getLeft())+1;
        } //left child stick
        else if((t.getRight()!=null)&&(t.getLeft()==null)){
            count+=stickCt(t.getRight())+1;
        }//right child stick
        else{
            count+=stickCt(t.getRight());
            count+=stickCt(t.getLeft());
        }// not stick

    }
    return count;
}
private StringNode copy(StringNode nd){
   StringNode node = new StringNode(nd.getString());//create new String Node
   if(nd != null){
   node.setLeft(copy(nd.getLeft()));//copy left subtree
   node.setRight(copy(nd.getRight()));//copy right subtree
   }

   return node;
} 

}
