package org.autotest;

import java.util.Arrays;
import randoop.CheckRep;

public class StackAr {

	private final static int DEFAULT_CAPACITY = 10;

	private final Object[] elems;

	private int readIndex = -1;

	public StackAr() {
		this(DEFAULT_CAPACITY);
	}

	public StackAr(int capacity) throws IllegalArgumentException {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.elems = new Object[capacity];
		for (int i = 0; i < capacity; i++) {
			this.elems[i] = null;
		}
	}

	public int size() {
		return readIndex+1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == elems.length;
	}

	public void push(Object o) throws IllegalStateException {
		if (isFull()) {
			throw new IllegalStateException();
		}
		this.readIndex++;
		this.elems[readIndex] = o;
	}

	public Object pop() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		Object rv = this.top();
		this.elems[readIndex] = null;
		readIndex--;
		return rv;
	}

	@CheckRep
	public boolean repOK() {
		if (this.elems == null) return false;
		if (this.readIndex < -1 || this.readIndex >= elems.length) return false;
		for (int i = this.readIndex + 1; i < elems.length; i++) {
			if (this.elems[i] != null) return false;
		}
		return true;
	}

	public Object top() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		Object rv = this.elems[readIndex];
		return rv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(elems);
		result = prime * result + readIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StackAr other = (StackAr) obj;
		if (!Arrays.equals(elems, other.elems))
			return false;
		if (readIndex != other.readIndex)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[");
		for (int i = 0; i <= readIndex; i++) {
			if (i > 0) {
				b.append(",");
			}
			Object o = elems[i];
			String s = String.valueOf(o);
			b.append(s);
		}
		b.append("]");
		return b.toString();
	}
}