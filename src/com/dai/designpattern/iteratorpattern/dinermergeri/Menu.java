package com.dai.designpattern.iteratorpattern.dinermergeri;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
