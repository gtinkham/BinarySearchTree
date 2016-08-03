package assign9;

/**
 * Represents a generically-typed binary tree node. Each binary node contains
 * data, a left child, and a right child.
 * 
 * @author Grant Tinkham
 */
public class BinaryNode<Type extends Comparable<? super Type>> {

  private Type data;

  private BinaryNode<Type> leftChild;

  private BinaryNode<Type> rightChild;

  public BinaryNode(Type _data, BinaryNode<Type> _leftChild,
      BinaryNode<Type> _rightChild) {
    data = _data;
    leftChild = _leftChild;
    rightChild = _rightChild;
  }

  public BinaryNode(Type _data) {
    this(_data, null, null);
  }

  /**
   * Getter method.
   * 
   * @return the node data.
   */
  public Type getData() {
    return data;
  }

  /**
   * Setter method.
   * 
   * @param _data
   *          - the node data to be set.
   */
  public void setData(Type _data) {
    data = _data;
  }

  /**
   * Getter method.
   * 
   * @return the left child node.
   */
  public BinaryNode<Type> getLeftChild() {
    return leftChild;
  }

  /**
   * Setter method.
   * 
   * @param _leftChild
   *          - the left child node to be set.
   */
  public void setLeftChild(BinaryNode<Type> _leftChild) {
    leftChild = _leftChild;
  }

  /**
   * Getter method.
   * 
   * @return the right child node.
   */
  public BinaryNode<Type> getRightChild() {
    return rightChild;
  }

  /**
   * Setter method.
   * 
   * @param _rightChild
   *          - the right child node to be set.
   */
  public void setRightChild(BinaryNode<Type> _rightChild) {
    rightChild = _rightChild;
  }

  /**
   * Returns the leftmost node in the binary tree rooted at this node.
   */
  public BinaryNode<Type> getLeftmostNode() {
	  if(this.getLeftChild() == null)
	  {
	    	return this;
	  }
	    return this.getLeftChild().getLeftmostNode();
  }

  /**
   * Returns the rightmost node in the binary tree rooted at this node.
   */
  public BinaryNode<Type> getRightmostNode() {
    if(this.getRightChild() == null)
    {
    	return this;
    }
    	return this.getRightChild().getRightmostNode();
  }

  /**
   * Returns the height of the binary tree rooted at this node. The height of a
   * tree is the length of the longest path to a leaf node. Consider a tree with
   * a single node to have a height of zero. 
   */
  public int height() {
    if(isLeaf())
    {
    	return 0;
    }
    return 1 + Math.max(getLeftChild().height(), getRightChild().height());
  }
  
  /**
   * Returns whether or not this node is a leaf or not;
   * 
   */
  public boolean isLeaf()
  {
	  return (getRightChild() == null && getLeftChild() == null);
  }
  /**
   * Adds a lesser item to the left, greater to the right.
   */
  public boolean add(BinaryNode<Type> item)
  {
	  
	  int compareValue = this.getData().compareTo(item.getData());
	  
	  if(compareValue > 0)
		{
			if(this.getLeftChild() == null)
			{
				this.setLeftChild(item);
				return true;
			}
			return this.getLeftChild().add(item);
		}
	  else if(compareValue == 0){
		  return false;
	  }
		else
		{
			if(this.getRightChild() == null)
			{
				this.setRightChild(item);
				return true;
			}
			return this.getRightChild().add(item);
		}
  }

  /**
   * Searches the tree for a specific node.
   * @param item
   * 		--The item in the tree we are seaching for.
   * @return
   * 		--The desired node
   * 		--Null if not found
   */
	public BinaryNode<Type> searchTree(BinaryNode<Type> item) {

		int compareValue = this.getData().compareTo(item.getData());

		if (compareValue > 0) {
			if (this.getLeftChild() == null) {
				return null;
			}
			return this.getLeftChild().searchTree(item);
		} else if (compareValue == 0) {
			return this;
		} else {
			if (this.getRightChild() == null) {
				return null;
			}
			return this.getRightChild().searchTree(item);
		}
	}
	/**
	 * Returns the node above the given child node.
	 * @param item
	 * 		-- The child of the node we want to find.
	 * @return
	 *		--  The parent node to the item.
	 */
	public BinaryNode<Type> getParent(BinaryNode<Type> item)
		{
			
			if(this.getLeftChild().getData().compareTo(item.getData()) == 0 || 
					this.getRightChild().getData().compareTo(item.getData())==0)
			{
				return this;
			}
	
			int compareValue = this.getData().compareTo(item.getData());
			if (compareValue > 0) {
				if (this.getLeftChild() == null) {
					return null;
				}
				return this.getLeftChild().getParent(item);
			} 
			 else 
			{
				
				return this.getRightChild().getParent(item);
			}
			
		}

}
