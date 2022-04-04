package com.vti.DoubleLinkedList;

public class Node {

	public Node next = null;
	
	public Node prev = null;

	public int Data = 0;
	
	public int temp;
	
	public Node(int Data) {
		
		this.Data = Data;
	}
	

	public void Print() {
		System.out.println("\t Data : " + this.Data);
		
	}
}
