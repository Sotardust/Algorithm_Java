package com.dai.designpattern.commandpattern.undo;

public interface Command {
	public void execute();
	public void undo();
}
