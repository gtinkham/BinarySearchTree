package assign9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * The Binary Search Tree Data Structure Class
 * @author Grant Tinkham
 * 
 */

public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type>{

	private int size;
	private BinaryNode<Type> root;

	public BinarySearchTree()
	{
		size = 0;
		root = null;
	}
	@Override
	public boolean add(Type item) {
		
		BinaryNode<Type> itemNode = new BinaryNode<Type>(item);//creates a new node with the item to be set in
		boolean isAdded = false;
		//throw exception if the item is null
		if(itemNode.getData() == null)
		{
			throw new NullPointerException();
		}
		//if the root is null, then the root will no longer be null and increases the size by one
		if(root == null)
		{
			root = itemNode;
			size++;
			return true;
		}
		//call to recursive method
		isAdded = root.add(itemNode);

		if(isAdded)
			size++;
		return isAdded;

	}

	@Override
	public boolean addAll(Collection<? extends Type> items) {
		boolean flag = false;
		if (items.isEmpty())
		{
			return flag;
		}
		else
		{
			for(Type element: items)
			{
				flag = add(element);
				if(flag == false)
				{
					return flag;
				}
			}
			return flag;
		}
	}

	@Override
	public void clear() {
		size = 0;
		root.setLeftChild(null);
		root.setRightChild(null);
		root = null;
		
		
	}

	@Override
	public boolean contains(Type item) {
		if(item == null)
		{
			throw new NullPointerException();
		}
		if(isEmpty())
		{
			return false;
		}

		
		BinaryNode<Type> itemNode = new BinaryNode<Type>(item);
		BinaryNode<Type> temp;
		//call to recursive method
		temp = root.searchTree(itemNode);
		
		if(temp == null)
		{
			return false;
		}
		else
		{
			return true;
		}

	}

	@Override
	public boolean containsAll(Collection<? extends Type> items) {

		boolean flag = false;
		if (items.isEmpty())
		{
			return flag;
		}
		else
		{
			for(Type element: items)
			{
				flag = contains(element);
				if(flag == false)
				{
					return flag;
				}
			}
			return flag;
		}
	}

	@Override
	public Type first() throws NoSuchElementException {
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		return root.getLeftmostNode().getData();
	}

	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}

	@Override
	public Type last() throws NoSuchElementException {

		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		return root.getRightmostNode().getData();
	}

	@Override
	public boolean remove(Type item) {

		if(item == null)
		{
			return false;
		}
		if(!contains(item) || isEmpty())
		{
			return false;
		}
		
		BinaryNode<Type> itemNode = new BinaryNode<Type>(item);
		BinaryNode<Type> temp;
		
		boolean isRemoved = false;
		//call to recursive methods
		temp = root.searchTree(itemNode);
		isRemoved = removeRecursive(temp);

		if(isRemoved)
		{
			size--;
		}
		return isRemoved;
}	
	
		
	
	/**
	   * The helper method for the remove method
	   * 
	   * @param temp
	   *          - the BinaryNode that is to be checked and removed
	   * @return true or false. Depending on whether the node is removed or not.
	   */
	private boolean removeRecursive(BinaryNode<Type> temp) {
		
		if(temp.isLeaf())
		{
			temp.setData(null);
			return true;
		}
		if(temp.getLeftChild() != null && temp.getRightChild() != null)
		{
			temp.setData(temp.getRightChild().getLeftmostNode().getData());
			return removeRecursive(temp.getRightChild().getLeftmostNode());
		}
		if(temp.getLeftChild() != null)
		{
			temp.setData(temp.getLeftChild().getData());
			return removeRecursive(temp.getLeftChild());
		}
		if(temp.getRightChild() != null)
		{
			temp.setData(temp.getRightChild().getData());
			return removeRecursive(temp.getRightChild());
		}
		return false;
	}
	@Override
	public boolean removeAll(Collection<? extends Type> items) {
		boolean flag = false;
		if (items.isEmpty())
		{
			return flag;
		}
		else
		{
			for(Type element: items)
			{
				flag = remove(element);
				if(flag == false)
				{
					return flag;
				}
			}
			return flag;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<Type> toArrayList() {

		ArrayList<Type> list = addInOrder(root);
		
		return list;
	
		
	}
	/**
	   * The helper method for the toArrayList which actually sorts in order
	   * 
	   * @param temp
	   *          - the BinaryNode that is to be checked and added to the list
	   * @return list
	   * 		  - the list of data types in order
	   */
	private ArrayList<Type> addInOrder(BinaryNode<Type> temp)
	{
		ArrayList<Type> list = new ArrayList<Type>();//array list to be added in and returned
		BinaryNode<Type> current = temp;
		//checks whether the left child is null or not

		if(current.getLeftChild() != null)
		{
			//adds all from the left side of the root
			list.addAll(addInOrder(current.getLeftChild()));
		}
		//adds the item to the list
		if(current.getData() != null)
			list.add(current.getData());
		//checks whether the right child is null or not
		if(current.getRightChild() != null )
		{
			//adds all from the right side of the root
			list.addAll(addInOrder(current.getRightChild()));
		}
		return list;
	}
	

}
