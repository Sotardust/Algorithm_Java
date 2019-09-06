package com.dai.designpattern.iteratorpattern.dinermergercafe;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
