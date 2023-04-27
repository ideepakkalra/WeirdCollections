/**
 * 
 */
package com.github.ideepakkalra.weirdcollections;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Deepak
 *
 */
public class LinkedArrayList<E> extends AbstractList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayHolder arrayHolder;	
	private int curArrayIndex;	
	private int maxArrayIndex;
	
	private int startArrayindex;
	private int endArrayIndex;
	
	private int newArraySize = 10;
	
	private LinkedList<Object[]> arrayHolderList;
	private Object[] elementData;
	
	public LinkedArrayList() {
		arrayHolderList = new LinkedList<>();
		elementData = new Object[newArraySize];
		curArrayIndex = 0;
		maxArrayIndex = newArraySize - 1;
		startArrayindex = 0;
		endArrayIndex = maxArrayIndex;
		//arrayHolderList.add(elementData);
	}
	
	private void reinitializeArray() {
		/*arrayHolder = new ArrayHolder(elementData, startArrayindex, endArrayIndex);
		arrayHolderList.add(arrayHolder);*/
		
		arrayHolderList.add(elementData);
		newArraySize += (0.5 * newArraySize);
		elementData = new Object[newArraySize];
		curArrayIndex = 0;
		//arrayHolderList.add(elementData);
		
		/*startArrayindex = curArrayIndex;
		endArrayIndex = maxArrayIndex;*/
	}
	
	public boolean add(E e) {
		if(curArrayIndex >= elementData.length) {
			reinitializeArray();
		}
		elementData[curArrayIndex++] = e;
		return true;
	}

	class ArrayHolder {
		private int size;
		private int pointer;
		private int startIndex;
		private int endIndex;
		private Object[] elementData;
		
		public ArrayHolder(Object[] elementData, int startIndex, int endIndex) {
			this.elementData = elementData;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.pointer = -1;
		}

		public void add(E e) {
			elementData[++pointer] = e;			
		}

		/**
		 * @return the size
		 */
		public int getSize() {
			return size;
		}

		/**
		 * @param size the size to set
		 */
		public void setSize(int size) {
			this.size = size;
		}

		/**
		 * @return the pointer
		 */
		public int getPointer() {
			return pointer;
		}

		/**
		 * @param pointer the pointer to set
		 */
		public void setPointer(int pointer) {
			this.pointer = pointer;
		}

		/**
		 * @return the startIndex
		 */
		public int getStartIndex() {
			return startIndex;
		}

		/**
		 * @param startIndex the startIndex to set
		 */
		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}

		/**
		 * @return the endIndex
		 */
		public int getEndIndex() {
			return endIndex;
		}

		/**
		 * @param endIndex the endIndex to set
		 */
		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}

		/**
		 * @return the elementData
		 */
		public Object[] getElementData() {
			return elementData;
		}

		/**
		 * @param elementData the elementData to set
		 */
		public void setElementData(Object[] elementData) {
			this.elementData = elementData;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ArrayHolder [size=" + size + ", pointer=" + pointer + ", startIndex=" + startIndex + ", endIndex="
					+ endIndex + ", elementData=" + Arrays.toString(elementData) + "]";
		}
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
