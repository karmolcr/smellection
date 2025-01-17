// ***************************************************************************
// Copyright (c) 2014, Industrial Logic, Inc., All Rights Reserved.
//
// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
// used by students during Industrial Logic's workshops or by individuals
// who are being coached by Industrial Logic on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Industrial Logic, Inc.
// ****************************************************************************

package com.industriallogic.collections;

public class List extends AbstractList {
    public static final int INITIAL_SIZE = 10;
    private Object[] elements = new Object[INITIAL_SIZE];
	private int size = 0;
	private boolean readOnly;

	public boolean getReadOnly(){
		return readOnly;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Object element) {
        if (readOnly) {
            return;
        }
        extendCapacity();
        appendElement(element);
    }

    private void extendCapacity() {
        if (size + 1 > elements.length) {
            Object[] newElements =
                new Object[elements.length + INITIAL_SIZE];
            for (int i = 0; i < size; i++)
                newElements[i] = elements[i];
            elements = newElements;
        }
    }

    private void appendElement(Object element) {
        elements[size++] = element;
    }

    public boolean contains(Object element) {
		for (int i=0; i<size; i++) 
			if (elements[i].equals(element))
				return true;
		return false;
	}

	public int size() {
		return size;
	}

	public boolean remove(Object element) {
		if (readOnly)
			return false;
		else 	
			for (int i = 0; i < size; i++)
				if (elements[i].equals(element)) {
					elements[i] = null;
					Object[] newElements = new Object[size - 1];
					int k = 0;
					for (int j = 0; j < size; j++) {
						if (elements[j] != null)
							newElements[k++] = elements[j];
					}
					size--;
					elements = newElements;
					return true;
				}
		return false;
	}
	
	public Object get(int i) {
		return elements[i];
	}

	public int capacity() {
		return elements.length;
	}

	public void set(int i, Object value) {
		if (!readOnly) {
			if (i >= size)
				throw new ArrayIndexOutOfBoundsException();
			elements[i] = value;
		}
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
